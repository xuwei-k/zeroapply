package zeroapply

object OptionApply {

  import scala.{Option => F}


  final def apply[A1, A2, Z](a1: F[A1], a2: F[A2])(f: (A1, A2) => Z): F[Z] =
    apply2[A1, A2, Z](a1, a2)(f)

  final def apply2[A1, A2, Z](a1: F[A1], a2: F[A2])(f: (A1, A2) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2 } yield f(x1, x2)

  final def tuple[A1, A2](a1: F[A1], a2: F[A2]): F[(A1, A2)] =
    tuple2[A1, A2](a1, a2)

  final def tuple2[A1, A2](a1: F[A1], a2: F[A2]): F[(A1, A2)] =
    apply2(a1, a2)(Tuple2.apply)

  final def apply[A1, A2, A3, Z](a1: F[A1], a2: F[A2], a3: F[A3])(f: (A1, A2, A3) => Z): F[Z] =
    apply3[A1, A2, A3, Z](a1, a2, a3)(f)

  final def apply3[A1, A2, A3, Z](a1: F[A1], a2: F[A2], a3: F[A3])(f: (A1, A2, A3) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3 } yield f(x1, x2, x3)

  final def tuple[A1, A2, A3](a1: F[A1], a2: F[A2], a3: F[A3]): F[(A1, A2, A3)] =
    tuple3[A1, A2, A3](a1, a2, a3)

  final def tuple3[A1, A2, A3](a1: F[A1], a2: F[A2], a3: F[A3]): F[(A1, A2, A3)] =
    apply3(a1, a2, a3)(Tuple3.apply)

  final def apply[A1, A2, A3, A4, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4])(f: (A1, A2, A3, A4) => Z): F[Z] =
    apply4[A1, A2, A3, A4, Z](a1, a2, a3, a4)(f)

  final def apply4[A1, A2, A3, A4, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4])(f: (A1, A2, A3, A4) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4 } yield f(x1, x2, x3, x4)

  final def tuple[A1, A2, A3, A4](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4]): F[(A1, A2, A3, A4)] =
    tuple4[A1, A2, A3, A4](a1, a2, a3, a4)

  final def tuple4[A1, A2, A3, A4](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4]): F[(A1, A2, A3, A4)] =
    apply4(a1, a2, a3, a4)(Tuple4.apply)

  final def apply[A1, A2, A3, A4, A5, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5])(f: (A1, A2, A3, A4, A5) => Z): F[Z] =
    apply5[A1, A2, A3, A4, A5, Z](a1, a2, a3, a4, a5)(f)

  final def apply5[A1, A2, A3, A4, A5, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5])(f: (A1, A2, A3, A4, A5) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5 } yield f(x1, x2, x3, x4, x5)

  final def tuple[A1, A2, A3, A4, A5](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5]): F[(A1, A2, A3, A4, A5)] =
    tuple5[A1, A2, A3, A4, A5](a1, a2, a3, a4, a5)

  final def tuple5[A1, A2, A3, A4, A5](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5]): F[(A1, A2, A3, A4, A5)] =
    apply5(a1, a2, a3, a4, a5)(Tuple5.apply)

  final def apply[A1, A2, A3, A4, A5, A6, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6])(f: (A1, A2, A3, A4, A5, A6) => Z): F[Z] =
    apply6[A1, A2, A3, A4, A5, A6, Z](a1, a2, a3, a4, a5, a6)(f)

  final def apply6[A1, A2, A3, A4, A5, A6, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6])(f: (A1, A2, A3, A4, A5, A6) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6 } yield f(x1, x2, x3, x4, x5, x6)

  final def tuple[A1, A2, A3, A4, A5, A6](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6]): F[(A1, A2, A3, A4, A5, A6)] =
    tuple6[A1, A2, A3, A4, A5, A6](a1, a2, a3, a4, a5, a6)

  final def tuple6[A1, A2, A3, A4, A5, A6](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6]): F[(A1, A2, A3, A4, A5, A6)] =
    apply6(a1, a2, a3, a4, a5, a6)(Tuple6.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7])(f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[Z] =
    apply7[A1, A2, A3, A4, A5, A6, A7, Z](a1, a2, a3, a4, a5, a6, a7)(f)

  final def apply7[A1, A2, A3, A4, A5, A6, A7, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7])(f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7 } yield f(x1, x2, x3, x4, x5, x6, x7)

  final def tuple[A1, A2, A3, A4, A5, A6, A7](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7]): F[(A1, A2, A3, A4, A5, A6, A7)] =
    tuple7[A1, A2, A3, A4, A5, A6, A7](a1, a2, a3, a4, a5, a6, a7)

  final def tuple7[A1, A2, A3, A4, A5, A6, A7](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7]): F[(A1, A2, A3, A4, A5, A6, A7)] =
    apply7(a1, a2, a3, a4, a5, a6, a7)(Tuple7.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8])(f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[Z] =
    apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](a1, a2, a3, a4, a5, a6, a7, a8)(f)

  final def apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8])(f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8 } yield f(x1, x2, x3, x4, x5, x6, x7, x8)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8]): F[(A1, A2, A3, A4, A5, A6, A7, A8)] =
    tuple8[A1, A2, A3, A4, A5, A6, A7, A8](a1, a2, a3, a4, a5, a6, a7, a8)

  final def tuple8[A1, A2, A3, A4, A5, A6, A7, A8](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8]): F[(A1, A2, A3, A4, A5, A6, A7, A8)] =
    apply8(a1, a2, a3, a4, a5, a6, a7, a8)(Tuple8.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[Z] =
    apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9)(f)

  final def apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9)] =
    tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9](a1, a2, a3, a4, a5, a6, a7, a8, a9)

  final def tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9)] =
    apply9(a1, a2, a3, a4, a5, a6, a7, a8, a9)(Tuple9.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[Z] =
    apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)(f)

  final def apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)] =
    tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)

  final def tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)] =
    apply10(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)(Tuple10.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[Z] =
    apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)(f)

  final def apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)] =
    tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)

  final def tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)] =
    apply11(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)(Tuple11.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[Z] =
    apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)(f)

  final def apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)] =
    tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)

  final def tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)] =
    apply12(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)(Tuple12.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[Z] =
    apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)(f)

  final def apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)] =
    tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)

  final def tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)] =
    apply13(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)(Tuple13.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[Z] =
    apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)(f)

  final def apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)] =
    tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)

  final def tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)] =
    apply14(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)(Tuple14.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[Z] =
    apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)(f)

  final def apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14; x15 <- a15 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)] =
    tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)

  final def tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)] =
    apply15(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)(Tuple15.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[Z] =
    apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)(f)

  final def apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14; x15 <- a15; x16 <- a16 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)] =
    tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)

  final def tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)] =
    apply16(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)(Tuple16.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[Z] =
    apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)(f)

  final def apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14; x15 <- a15; x16 <- a16; x17 <- a17 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)] =
    tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)

  final def tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)] =
    apply17(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)(Tuple17.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[Z] =
    apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)(f)

  final def apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14; x15 <- a15; x16 <- a16; x17 <- a17; x18 <- a18 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)] =
    tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)

  final def tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)] =
    apply18(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)(Tuple18.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[Z] =
    apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)(f)

  final def apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14; x15 <- a15; x16 <- a16; x17 <- a17; x18 <- a18; x19 <- a19 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)] =
    tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)

  final def tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)] =
    apply19(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)(Tuple19.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[Z] =
    apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)(f)

  final def apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14; x15 <- a15; x16 <- a16; x17 <- a17; x18 <- a18; x19 <- a19; x20 <- a20 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)] =
    tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)

  final def tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)] =
    apply20(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)(Tuple20.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[Z] =
    apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)(f)

  final def apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14; x15 <- a15; x16 <- a16; x17 <- a17; x18 <- a18; x19 <- a19; x20 <- a20; x21 <- a21 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)] =
    tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)

  final def tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)] =
    apply21(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)(Tuple21.apply)

  final def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21], a22: F[A22])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[Z] =
    apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)(f)

  final def apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21], a22: F[A22])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[Z] =
    for { x1 <- a1; x2 <- a2; x3 <- a3; x4 <- a4; x5 <- a5; x6 <- a6; x7 <- a7; x8 <- a8; x9 <- a9; x10 <- a10; x11 <- a11; x12 <- a12; x13 <- a13; x14 <- a14; x15 <- a15; x16 <- a16; x17 <- a17; x18 <- a18; x19 <- a19; x20 <- a20; x21 <- a21; x22 <- a22 } yield f(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21, x22)

  final def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21], a22: F[A22]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)] =
    tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)

  final def tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](a1: F[A1], a2: F[A2], a3: F[A3], a4: F[A4], a5: F[A5], a6: F[A6], a7: F[A7], a8: F[A8], a9: F[A9], a10: F[A10], a11: F[A11], a12: F[A12], a13: F[A13], a14: F[A14], a15: F[A15], a16: F[A16], a17: F[A17], a18: F[A18], a19: F[A19], a20: F[A20], a21: F[A21], a22: F[A22]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)] =
    apply22(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)(Tuple22.apply)
}
