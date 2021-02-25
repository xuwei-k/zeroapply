import sbt._, Keys._
import sbtrelease.Git
import sbtrelease.ReleasePlugin.autoImport.ReleaseStep
import scala.sys.process.Process

object UpdateReadme {
  private val sonatypeURL = "https://oss.sonatype.org/service/local/repositories/"

  val updateReadmeTask = { state: State =>
    val extracted = Project.extract(state)
    val scalaV = extracted get scalaBinaryVersion
    val v = extracted get version
    val org = extracted get organization
    val modules = build.modules
    val snapshotOrRelease = if (extracted get isSnapshot) "snapshots" else "releases"
    val readme = "README.md"
    val readmeFile = file(readme)
    val newReadme = Predef
      .augmentString(IO.read(readmeFile))
      .lines
      .map { line =>
        val matchReleaseOrSnapshot = line.contains("SNAPSHOT") == v.contains("SNAPSHOT")
        if (line.startsWith("libraryDependencies") && matchReleaseOrSnapshot) {
          val i = modules.map("\"" + _ + "\"").indexWhere(line.contains)
          s"""libraryDependencies += "${org}" %% "${modules(i)}" % "$v""""
        } else if (line.contains(sonatypeURL) && matchReleaseOrSnapshot) {
          val n = extracted.get(LocalRootProject / name)
          val sxrIndexHtml = "-sxr.jar/!/index.html"
          val javadocIndexHtml = "-javadoc.jar/!/index.html"
          val baseURL = s"${sonatypeURL}${snapshotOrRelease}/archive/${org.replace('.', '/')}/${n}_${scalaV}/${v}/${n}_${scalaV}-${v}"
          if (line.contains(javadocIndexHtml)) {
            s"- [API Documentation](${baseURL}${javadocIndexHtml})"
          } else if (line.contains(sxrIndexHtml)) {
            s"- [sxr](${baseURL}${sxrIndexHtml})"
          } else line
        } else line
      }
      .mkString("", "\n", "\n")
    IO.write(readmeFile, newReadme)
    val git = new Git(extracted get baseDirectory)
    git.add(readme) ! state.log
    git.commit(message = "update " + readme, sign = false, signOff = false) ! state.log
    Process("git diff HEAD^") ! state.log
    state
  }

  val updateReadmeProcess: ReleaseStep = updateReadmeTask
}
