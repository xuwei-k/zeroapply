package zeroapply

import scala.language.experimental.macros

object ValidationNelApply {

  import zeroapply.{ValidationNelImpl => Impl}
  import scalaz.{ValidationNel => F}


  final def apply2[A1, A2, L, Z](a1: F[L, A1], a2: F[L, A2])(f: (A1, A2) => Z): F[L, Z] =
    macro Impl.apply2[A1, A2, L, Z]

  final def tuple2[A1, A2, L](a1: F[L, A1], a2: F[L, A2]): F[L, (A1, A2)]=
    macro Impl.tuple2[A1, A2, L]

  final def apply3[A1, A2, A3, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3])(f: (A1, A2, A3) => Z): F[L, Z] =
    macro Impl.apply3[A1, A2, A3, L, Z]

  final def tuple3[A1, A2, A3, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3]): F[L, (A1, A2, A3)]=
    macro Impl.tuple3[A1, A2, A3, L]

  final def apply4[A1, A2, A3, A4, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4])(f: (A1, A2, A3, A4) => Z): F[L, Z] =
    macro Impl.apply4[A1, A2, A3, A4, L, Z]

  final def tuple4[A1, A2, A3, A4, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4]): F[L, (A1, A2, A3, A4)]=
    macro Impl.tuple4[A1, A2, A3, A4, L]

  final def apply5[A1, A2, A3, A4, A5, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5])(f: (A1, A2, A3, A4, A5) => Z): F[L, Z] =
    macro Impl.apply5[A1, A2, A3, A4, A5, L, Z]

  final def tuple5[A1, A2, A3, A4, A5, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5]): F[L, (A1, A2, A3, A4, A5)]=
    macro Impl.tuple5[A1, A2, A3, A4, A5, L]

  final def apply6[A1, A2, A3, A4, A5, A6, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6])(f: (A1, A2, A3, A4, A5, A6) => Z): F[L, Z] =
    macro Impl.apply6[A1, A2, A3, A4, A5, A6, L, Z]

  final def tuple6[A1, A2, A3, A4, A5, A6, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6]): F[L, (A1, A2, A3, A4, A5, A6)]=
    macro Impl.tuple6[A1, A2, A3, A4, A5, A6, L]

  final def apply7[A1, A2, A3, A4, A5, A6, A7, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7])(f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[L, Z] =
    macro Impl.apply7[A1, A2, A3, A4, A5, A6, A7, L, Z]

  final def tuple7[A1, A2, A3, A4, A5, A6, A7, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7]): F[L, (A1, A2, A3, A4, A5, A6, A7)]=
    macro Impl.tuple7[A1, A2, A3, A4, A5, A6, A7, L]

  final def apply8[A1, A2, A3, A4, A5, A6, A7, A8, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8])(f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[L, Z] =
    macro Impl.apply8[A1, A2, A3, A4, A5, A6, A7, A8, L, Z]

  final def tuple8[A1, A2, A3, A4, A5, A6, A7, A8, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8)]=
    macro Impl.tuple8[A1, A2, A3, A4, A5, A6, A7, A8, L]

  final def apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[L, Z] =
    macro Impl.apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, L, Z]

  final def tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9)]=
    macro Impl.tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9, L]

  final def apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[L, Z] =
    macro Impl.apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L, Z]

  final def tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)]=
    macro Impl.tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L]

  final def apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[L, Z] =
    macro Impl.apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L, Z]

  final def tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)]=
    macro Impl.tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L]

  final def apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[L, Z] =
    macro Impl.apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L, Z]

  final def tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)]=
    macro Impl.tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L]

  final def apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[L, Z] =
    macro Impl.apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L, Z]

  final def tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)]=
    macro Impl.tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L]

  final def apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[L, Z] =
    macro Impl.apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L, Z]

  final def tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)]=
    macro Impl.tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L]

  final def apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[L, Z] =
    macro Impl.apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L, Z]

  final def tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)]=
    macro Impl.tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L]

  final def apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[L, Z] =
    macro Impl.apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L, Z]

  final def tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)]=
    macro Impl.tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L]

  final def apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[L, Z] =
    macro Impl.apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L, Z]

  final def tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)]=
    macro Impl.tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L]

  final def apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[L, Z] =
    macro Impl.apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L, Z]

  final def tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)]=
    macro Impl.tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L]

  final def apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18], a19: F[L, A19])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[L, Z] =
    macro Impl.apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L, Z]

  final def tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18], a19: F[L, A19]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)]=
    macro Impl.tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L]

  final def apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18], a19: F[L, A19], a20: F[L, A20])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[L, Z] =
    macro Impl.apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L, Z]

  final def tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18], a19: F[L, A19], a20: F[L, A20]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)]=
    macro Impl.tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L]

  final def apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18], a19: F[L, A19], a20: F[L, A20], a21: F[L, A21])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[L, Z] =
    macro Impl.apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L, Z]

  final def tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18], a19: F[L, A19], a20: F[L, A20], a21: F[L, A21]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)]=
    macro Impl.tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L]

  final def apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L, Z](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18], a19: F[L, A19], a20: F[L, A20], a21: F[L, A21], a22: F[L, A22])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[L, Z] =
    macro Impl.apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L, Z]

  final def tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L](a1: F[L, A1], a2: F[L, A2], a3: F[L, A3], a4: F[L, A4], a5: F[L, A5], a6: F[L, A6], a7: F[L, A7], a8: F[L, A8], a9: F[L, A9], a10: F[L, A10], a11: F[L, A11], a12: F[L, A12], a13: F[L, A13], a14: F[L, A14], a15: F[L, A15], a16: F[L, A16], a17: F[L, A17], a18: F[L, A18], a19: F[L, A19], a20: F[L, A20], a21: F[L, A21], a22: F[L, A22]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)]=
    macro Impl.tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L]
}
