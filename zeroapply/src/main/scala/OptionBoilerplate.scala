package zeroapply

trait OptionBoilerplate extends Common{
  import c.universe._

  def tupleN(params: List[Tree], types: List[Type]): Tree

  def impl(params: List[Tree], types: List[Type], f: Tree, result: Tree, isTuple: Boolean = false): Tree


  final def apply2[A1: W, A2: W, Z: W](a1: Tree, a2: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: Nil, w[A1] :: w[A2] :: Nil, f, TypeTree(w[Z]))

  final def tuple2[A1: W, A2: W](a1: Tree, a2: Tree): Tree =
    tupleN(a1 :: a2 :: Nil, w[A1] :: w[A2] :: Nil)

  final def apply3[A1: W, A2: W, A3: W, Z: W](a1: Tree, a2: Tree, a3: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: Nil, w[A1] :: w[A2] :: w[A3] :: Nil, f, TypeTree(w[Z]))

  final def tuple3[A1: W, A2: W, A3: W](a1: Tree, a2: Tree, a3: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: Nil, w[A1] :: w[A2] :: w[A3] :: Nil)

  final def apply4[A1: W, A2: W, A3: W, A4: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: Nil, f, TypeTree(w[Z]))

  final def tuple4[A1: W, A2: W, A3: W, A4: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: Nil)

  final def apply5[A1: W, A2: W, A3: W, A4: W, A5: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: Nil, f, TypeTree(w[Z]))

  final def tuple5[A1: W, A2: W, A3: W, A4: W, A5: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: Nil)

  final def apply6[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: Nil, f, TypeTree(w[Z]))

  final def tuple6[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: Nil)

  final def apply7[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: Nil, f, TypeTree(w[Z]))

  final def tuple7[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: Nil)

  final def apply8[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: Nil, f, TypeTree(w[Z]))

  final def tuple8[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: Nil)

  final def apply9[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: Nil, f, TypeTree(w[Z]))

  final def tuple9[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: Nil)

  final def apply10[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: Nil, f, TypeTree(w[Z]))

  final def tuple10[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: Nil)

  final def apply11[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: Nil, f, TypeTree(w[Z]))

  final def tuple11[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: Nil)

  final def apply12[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: Nil, f, TypeTree(w[Z]))

  final def tuple12[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: Nil)

  final def apply13[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: Nil, f, TypeTree(w[Z]))

  final def tuple13[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: Nil)

  final def apply14[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: Nil, f, TypeTree(w[Z]))

  final def tuple14[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: Nil)

  final def apply15[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: Nil, f, TypeTree(w[Z]))

  final def tuple15[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: Nil)

  final def apply16[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: Nil, f, TypeTree(w[Z]))

  final def tuple16[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: Nil)

  final def apply17[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: Nil, f, TypeTree(w[Z]))

  final def tuple17[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: Nil)

  final def apply18[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: Nil, f, TypeTree(w[Z]))

  final def tuple18[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: Nil)

  final def apply19[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, A19: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree, a19: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: a19 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: w[A19] :: Nil, f, TypeTree(w[Z]))

  final def tuple19[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, A19: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree, a19: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: a19 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: w[A19] :: Nil)

  final def apply20[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, A19: W, A20: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree, a19: Tree, a20: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: a19 :: a20 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: w[A19] :: w[A20] :: Nil, f, TypeTree(w[Z]))

  final def tuple20[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, A19: W, A20: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree, a19: Tree, a20: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: a19 :: a20 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: w[A19] :: w[A20] :: Nil)

  final def apply21[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, A19: W, A20: W, A21: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree, a19: Tree, a20: Tree, a21: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: a19 :: a20 :: a21 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: w[A19] :: w[A20] :: w[A21] :: Nil, f, TypeTree(w[Z]))

  final def tuple21[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, A19: W, A20: W, A21: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree, a19: Tree, a20: Tree, a21: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: a19 :: a20 :: a21 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: w[A19] :: w[A20] :: w[A21] :: Nil)

  final def apply22[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, A19: W, A20: W, A21: W, A22: W, Z: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree, a19: Tree, a20: Tree, a21: Tree, a22: Tree)(f: Tree): Tree =
    impl(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: a19 :: a20 :: a21 :: a22 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: w[A19] :: w[A20] :: w[A21] :: w[A22] :: Nil, f, TypeTree(w[Z]))

  final def tuple22[A1: W, A2: W, A3: W, A4: W, A5: W, A6: W, A7: W, A8: W, A9: W, A10: W, A11: W, A12: W, A13: W, A14: W, A15: W, A16: W, A17: W, A18: W, A19: W, A20: W, A21: W, A22: W](a1: Tree, a2: Tree, a3: Tree, a4: Tree, a5: Tree, a6: Tree, a7: Tree, a8: Tree, a9: Tree, a10: Tree, a11: Tree, a12: Tree, a13: Tree, a14: Tree, a15: Tree, a16: Tree, a17: Tree, a18: Tree, a19: Tree, a20: Tree, a21: Tree, a22: Tree): Tree =
    tupleN(a1 :: a2 :: a3 :: a4 :: a5 :: a6 :: a7 :: a8 :: a9 :: a10 :: a11 :: a12 :: a13 :: a14 :: a15 :: a16 :: a17 :: a18 :: a19 :: a20 :: a21 :: a22 :: Nil, w[A1] :: w[A2] :: w[A3] :: w[A4] :: w[A5] :: w[A6] :: w[A7] :: w[A8] :: w[A9] :: w[A10] :: w[A11] :: w[A12] :: w[A13] :: w[A14] :: w[A15] :: w[A16] :: w[A17] :: w[A18] :: w[A19] :: w[A20] :: w[A21] :: w[A22] :: Nil)
}
