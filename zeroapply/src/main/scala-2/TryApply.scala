package zeroapply

import scala.language.experimental.macros

object TryApply {

  import zeroapply.{TryImpl => Impl}
  import scala.util.{Try => F}


  final def apply[A1, A2, Z](a1: F[A1], a2: F[A2])(f: (A1, A2) => Z): F[Z] =
    macro Impl.apply2[A1, A2, Z]

  final def apply2[A1, A2, Z](a1: F[A1], a2: F[A2])(f: (A1, A2) => Z): F[Z] =
    macro Impl.apply2[A1, A2, Z]

  final def tuple[A1, A2](a1: F[A1], a2: F[A2]): F[(A1, A2)] =
    macro Impl.tuple2[A1, A2]

  final def tuple2[A1, A2](a1: F[A1], a2: F[A2]): F[(A1, A2)] =
    macro Impl.tuple2[A1, A2]

  final def apply[A1, A2, A3, Z](a1: F[A1], a2: F[A2], a3: F[A3])(f: (A1, A2, A3) => Z): F[Z] =
    macro Impl.apply3[A1, A2, A3, Z]

  final def apply3[A1, A2, A3, Z](a1: F[A1], a2: F[A2], a3: F[A3])(f: (A1, A2, A3) => Z): F[Z] =
    macro Impl.apply3[A1, A2, A3, Z]

  final def tuple[A1, A2, A3](a1: F[A1], a2: F[A2], a3: F[A3]): F[(A1, A2, A3)] =
    macro Impl.tuple3[A1, A2, A3]

  final def tuple3[A1, A2, A3](a1: F[A1], a2: F[A2], a3: F[A3]): F[(A1, A2, A3)] =
    macro Impl.tuple3[A1, A2, A3]

  final def apply[A1, A2, A3, A4, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4])(f: (A1, A2, A3, A4) => Z): F[Z] =
    macro Impl.apply4[A1, A2, A3, A4, Z]

  final def apply4[A1, A2, A3, A4, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4])(f: (A1, A2, A3, A4) => Z): F[Z] =
    macro Impl.apply4[A1, A2, A3, A4, Z]

  final def tuple[A1, A2, A3, A4](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4]): F[(A1, A2, A3, A4)] =
    macro Impl.tuple4[A1, A2, A3, A4]

  final def tuple4[A1, A2, A3, A4](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4]): F[(A1, A2, A3, A4)] =
    macro Impl.tuple4[A1, A2, A3, A4]

  final def apply[A1, A2, A3, A4, A5, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5])(f: (A1, A2, A3, A4, A5) => Z): F[Z] =
    macro Impl.apply5[A1, A2, A3, A4, A5, Z]

  final def apply5[A1, A2, A3, A4, A5, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5])(f: (A1, A2, A3, A4, A5) => Z): F[Z] =
    macro Impl.apply5[A1, A2, A3, A4, A5, Z]

  final def tuple[A1, A2, A3, A4, A5](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5]): F[(A1, A2, A3, A4, A5)] =
    macro Impl.tuple5[A1, A2, A3, A4, A5]

  final def tuple5[A1, A2, A3, A4, A5](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5]): F[(A1, A2, A3, A4, A5)] =
    macro Impl.tuple5[A1, A2, A3, A4, A5]

  final def apply[A1, A2, A3, A4, A5, A6, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6])(f: (A1, A2, A3, A4, A5, A6) => Z): F[Z] =
    macro Impl.apply6[A1, A2, A3, A4, A5, A6, Z]

  final def apply6[A1, A2, A3, A4, A5, A6, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6])(f: (A1, A2, A3, A4, A5, A6) => Z): F[Z] =
    macro Impl.apply6[A1, A2, A3, A4, A5, A6, Z]

  final def tuple[A1, A2, A3, A4, A5, A6](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6]): F[(A1, A2, A3, A4, A5, A6)] =
    macro Impl.tuple6[A1, A2, A3, A4, A5, A6]

  final def tuple6[A1, A2, A3, A4, A5, A6](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6]): F[(A1, A2, A3, A4, A5, A6)] =
    macro Impl.tuple6[A1, A2, A3, A4, A5, A6]

  final def apply[A1, A2, A3, A4, A5, A6, A7, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7])(f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[Z] =
    macro Impl.apply7[A1, A2, A3, A4, A5, A6, A7, Z]

  final def apply7[A1, A2, A3, A4, A5, A6, A7, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7])(f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[Z] =
    macro Impl.apply7[A1, A2, A3, A4, A5, A6, A7, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7]): F[(A1, A2, A3, A4, A5, A6, A7)] =
    macro Impl.tuple7[A1, A2, A3, A4, A5, A6, A7]

  final def tuple7[A1, A2, A3, A4, A5, A6, A7](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7]): F[(A1, A2, A3, A4, A5, A6, A7)] =
    macro Impl.tuple7[A1, A2, A3, A4, A5, A6, A7]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8])(f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[Z] =
    macro Impl.apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z]

  final def apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8])(f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[Z] =
    macro Impl.apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8]): F[(A1, A2, A3, A4, A5, A6, A7, A8)] =
    macro Impl.tuple8[A1, A2, A3, A4, A5, A6, A7, A8]

  final def tuple8[A1, A2, A3, A4, A5, A6, A7, A8](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8]): F[(A1, A2, A3, A4, A5, A6, A7, A8)] =
    macro Impl.tuple8[A1, A2, A3, A4, A5, A6, A7, A8]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[Z] =
    macro Impl.apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z]

  final def apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[Z] =
    macro Impl.apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9)] =
    macro Impl.tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9]

  final def tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9)] =
    macro Impl.tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[Z] =
    macro Impl.apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z]

  final def apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[Z] =
    macro Impl.apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)] =
    macro Impl.tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]

  final def tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)] =
    macro Impl.tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[Z] =
    macro Impl.apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z]

  final def apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[Z] =
    macro Impl.apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)] =
    macro Impl.tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]

  final def tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)] =
    macro Impl.tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[Z] =
    macro Impl.apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z]

  final def apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[Z] =
    macro Impl.apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)] =
    macro Impl.tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]

  final def tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)] =
    macro Impl.tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[Z] =
    macro Impl.apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z]

  final def apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[Z] =
    macro Impl.apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)] =
    macro Impl.tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]

  final def tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)] =
    macro Impl.tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[Z] =
    macro Impl.apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z]

  final def apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[Z] =
    macro Impl.apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)] =
    macro Impl.tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]

  final def tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)] =
    macro Impl.tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[Z] =
    macro Impl.apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z]

  final def apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[Z] =
    macro Impl.apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)] =
    macro Impl.tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]

  final def tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)] =
    macro Impl.tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[Z] =
    macro Impl.apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z]

  final def apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[Z] =
    macro Impl.apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)] =
    macro Impl.tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]

  final def tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)] =
    macro Impl.tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[Z] =
    macro Impl.apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z]

  final def apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[Z] =
    macro Impl.apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)] =
    macro Impl.tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]

  final def tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)] =
    macro Impl.tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[Z] =
    macro Impl.apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z]

  final def apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[Z] =
    macro Impl.apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)] =
    macro Impl.tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]

  final def tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)] =
    macro Impl.tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[Z] =
    macro Impl.apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z]

  final def apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[Z] =
    macro Impl.apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)] =
    macro Impl.tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]

  final def tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)] =
    macro Impl.tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[Z] =
    macro Impl.apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z]

  final def apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[Z] =
    macro Impl.apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)] =
    macro Impl.tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]

  final def tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)] =
    macro Impl.tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[Z] =
    macro Impl.apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z]

  final def apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[Z] =
    macro Impl.apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)] =
    macro Impl.tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]

  final def tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)] =
    macro Impl.tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21], a22: F[A22])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[Z] =
    macro Impl.apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z]

  final def apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21], a22: F[A22])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[Z] =
    macro Impl.apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z]

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21], a22: F[A22]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)] =
    macro Impl.tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22]

  final def tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21], a22: F[A22]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)] =
    macro Impl.tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22]
}
