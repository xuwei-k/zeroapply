package zeroapply

import scalaz.{Equal, Order}
import scala.language.experimental.macros

object CaseClass {
  def equal[Z]: Equal[Z] =
    macro CaseClassImpl.equalImpl[Z]

  def order[Z]: Order[Z] =
    macro CaseClassImpl.orderImpl[Z]
}
