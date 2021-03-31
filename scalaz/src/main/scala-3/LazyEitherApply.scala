package zeroapply

object LazyEitherApply {

  import scalaz.{LazyEither => F}


  inline def apply[A1, A2, L, Z](a1: F[L, A1], inline a2: F[L, A2])(f: (A1, A2) => Z): F[L, Z] =
    apply2[A1, A2, L, Z](a1, a2)(f)

  inline def apply2[A1, A2, L, Z](a1: F[L, A1], inline a2: F[L, A2])(f: (A1, A2) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get))
      }
    }
  }

  inline def tuple[A1, A2, L](a1: F[L, A1], inline a2: F[L, A2]): F[L, (A1, A2)]=
    tuple2(a1, a2)

  inline def tuple2[A1, A2, L](a1: F[L, A1], inline a2: F[L, A2]): F[L, (A1, A2)]=
    apply2(a1, a2)(Tuple2.apply)

  inline def apply[A1, A2, A3, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3])(f: (A1, A2, A3) => Z): F[L, Z] =
    apply3[A1, A2, A3, L, Z](a1, a2, a3)(f)

  inline def apply3[A1, A2, A3, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3])(f: (A1, A2, A3) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get))
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3]): F[L, (A1, A2, A3)]=
    tuple3(a1, a2, a3)

  inline def tuple3[A1, A2, A3, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3]): F[L, (A1, A2, A3)]=
    apply3(a1, a2, a3)(Tuple3.apply)

  inline def apply[A1, A2, A3, A4, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4])(f: (A1, A2, A3, A4) => Z): F[L, Z] =
    apply4[A1, A2, A3, A4, L, Z](a1, a2, a3, a4)(f)

  inline def apply4[A1, A2, A3, A4, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4])(f: (A1, A2, A3, A4) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get))
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4]): F[L, (A1, A2, A3, A4)]=
    tuple4(a1, a2, a3, a4)

  inline def tuple4[A1, A2, A3, A4, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4]): F[L, (A1, A2, A3, A4)]=
    apply4(a1, a2, a3, a4)(Tuple4.apply)

  inline def apply[A1, A2, A3, A4, A5, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5])(f: (A1, A2, A3, A4, A5) => Z): F[L, Z] =
    apply5[A1, A2, A3, A4, A5, L, Z](a1, a2, a3, a4, a5)(f)

  inline def apply5[A1, A2, A3, A4, A5, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5])(f: (A1, A2, A3, A4, A5) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get))
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5]): F[L, (A1, A2, A3, A4, A5)]=
    tuple5(a1, a2, a3, a4, a5)

  inline def tuple5[A1, A2, A3, A4, A5, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5]): F[L, (A1, A2, A3, A4, A5)]=
    apply5(a1, a2, a3, a4, a5)(Tuple5.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6])(f: (A1, A2, A3, A4, A5, A6) => Z): F[L, Z] =
    apply6[A1, A2, A3, A4, A5, A6, L, Z](a1, a2, a3, a4, a5, a6)(f)

  inline def apply6[A1, A2, A3, A4, A5, A6, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6])(f: (A1, A2, A3, A4, A5, A6) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get))
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6]): F[L, (A1, A2, A3, A4, A5, A6)]=
    tuple6(a1, a2, a3, a4, a5, a6)

  inline def tuple6[A1, A2, A3, A4, A5, A6, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6]): F[L, (A1, A2, A3, A4, A5, A6)]=
    apply6(a1, a2, a3, a4, a5, a6)(Tuple6.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7])(f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[L, Z] =
    apply7[A1, A2, A3, A4, A5, A6, A7, L, Z](a1, a2, a3, a4, a5, a6, a7)(f)

  inline def apply7[A1, A2, A3, A4, A5, A6, A7, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7])(f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get))
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7]): F[L, (A1, A2, A3, A4, A5, A6, A7)]=
    tuple7(a1, a2, a3, a4, a5, a6, a7)

  inline def tuple7[A1, A2, A3, A4, A5, A6, A7, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7]): F[L, (A1, A2, A3, A4, A5, A6, A7)]=
    apply7(a1, a2, a3, a4, a5, a6, a7)(Tuple7.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8])(f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[L, Z] =
    apply8[A1, A2, A3, A4, A5, A6, A7, A8, L, Z](a1, a2, a3, a4, a5, a6, a7, a8)(f)

  inline def apply8[A1, A2, A3, A4, A5, A6, A7, A8, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8])(f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get))
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8)]=
    tuple8(a1, a2, a3, a4, a5, a6, a7, a8)

  inline def tuple8[A1, A2, A3, A4, A5, A6, A7, A8, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8)]=
    apply8(a1, a2, a3, a4, a5, a6, a7, a8)(Tuple8.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[L, Z] =
    apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9)(f)

  inline def apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get))
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9)]=
    tuple9(a1, a2, a3, a4, a5, a6, a7, a8, a9)

  inline def tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9)]=
    apply9(a1, a2, a3, a4, a5, a6, a7, a8, a9)(Tuple9.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[L, Z] =
    apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)(f)

  inline def apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get))
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)]=
    tuple10(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)

  inline def tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)]=
    apply10(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)(Tuple10.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[L, Z] =
    apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)(f)

  inline def apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get))
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)]=
    tuple11(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)

  inline def tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)]=
    apply11(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)(Tuple11.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[L, Z] =
    apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)(f)

  inline def apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get))
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)]=
    tuple12(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)

  inline def tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)]=
    apply12(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)(Tuple12.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[L, Z] =
    apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)(f)

  inline def apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get))
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)]=
    tuple13(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)

  inline def tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)]=
    apply13(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)(Tuple13.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[L, Z] =
    apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)(f)

  inline def apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get))
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)]=
    tuple14(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)

  inline def tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)]=
    apply14(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)(Tuple14.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[L, Z] =
    apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)(f)

  inline def apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                val x15 = a15
                                if (x15.isLeft) {
                                  x15.asInstanceOf[F[L, Z]]
                                } else {
                                  scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get, x15.toOption.get))
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)]=
    tuple15(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)

  inline def tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)]=
    apply15(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)(Tuple15.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[L, Z] =
    apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)(f)

  inline def apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                val x15 = a15
                                if (x15.isLeft) {
                                  x15.asInstanceOf[F[L, Z]]
                                } else {
                                  val x16 = a16
                                  if (x16.isLeft) {
                                    x16.asInstanceOf[F[L, Z]]
                                  } else {
                                    scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get, x15.toOption.get, x16.toOption.get))
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)]=
    tuple16(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)

  inline def tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)]=
    apply16(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)(Tuple16.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[L, Z] =
    apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)(f)

  inline def apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                val x15 = a15
                                if (x15.isLeft) {
                                  x15.asInstanceOf[F[L, Z]]
                                } else {
                                  val x16 = a16
                                  if (x16.isLeft) {
                                    x16.asInstanceOf[F[L, Z]]
                                  } else {
                                    val x17 = a17
                                    if (x17.isLeft) {
                                      x17.asInstanceOf[F[L, Z]]
                                    } else {
                                      scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get, x15.toOption.get, x16.toOption.get, x17.toOption.get))
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)]=
    tuple17(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)

  inline def tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)]=
    apply17(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)(Tuple17.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[L, Z] =
    apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)(f)

  inline def apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                val x15 = a15
                                if (x15.isLeft) {
                                  x15.asInstanceOf[F[L, Z]]
                                } else {
                                  val x16 = a16
                                  if (x16.isLeft) {
                                    x16.asInstanceOf[F[L, Z]]
                                  } else {
                                    val x17 = a17
                                    if (x17.isLeft) {
                                      x17.asInstanceOf[F[L, Z]]
                                    } else {
                                      val x18 = a18
                                      if (x18.isLeft) {
                                        x18.asInstanceOf[F[L, Z]]
                                      } else {
                                        scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get, x15.toOption.get, x16.toOption.get, x17.toOption.get, x18.toOption.get))
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)]=
    tuple18(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)

  inline def tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)]=
    apply18(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)(Tuple18.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[L, Z] =
    apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)(f)

  inline def apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                val x15 = a15
                                if (x15.isLeft) {
                                  x15.asInstanceOf[F[L, Z]]
                                } else {
                                  val x16 = a16
                                  if (x16.isLeft) {
                                    x16.asInstanceOf[F[L, Z]]
                                  } else {
                                    val x17 = a17
                                    if (x17.isLeft) {
                                      x17.asInstanceOf[F[L, Z]]
                                    } else {
                                      val x18 = a18
                                      if (x18.isLeft) {
                                        x18.asInstanceOf[F[L, Z]]
                                      } else {
                                        val x19 = a19
                                        if (x19.isLeft) {
                                          x19.asInstanceOf[F[L, Z]]
                                        } else {
                                          scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get, x15.toOption.get, x16.toOption.get, x17.toOption.get, x18.toOption.get, x19.toOption.get))
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)]=
    tuple19(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)

  inline def tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)]=
    apply19(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)(Tuple19.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[L, Z] =
    apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)(f)

  inline def apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                val x15 = a15
                                if (x15.isLeft) {
                                  x15.asInstanceOf[F[L, Z]]
                                } else {
                                  val x16 = a16
                                  if (x16.isLeft) {
                                    x16.asInstanceOf[F[L, Z]]
                                  } else {
                                    val x17 = a17
                                    if (x17.isLeft) {
                                      x17.asInstanceOf[F[L, Z]]
                                    } else {
                                      val x18 = a18
                                      if (x18.isLeft) {
                                        x18.asInstanceOf[F[L, Z]]
                                      } else {
                                        val x19 = a19
                                        if (x19.isLeft) {
                                          x19.asInstanceOf[F[L, Z]]
                                        } else {
                                          val x20 = a20
                                          if (x20.isLeft) {
                                            x20.asInstanceOf[F[L, Z]]
                                          } else {
                                            scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get, x15.toOption.get, x16.toOption.get, x17.toOption.get, x18.toOption.get, x19.toOption.get, x20.toOption.get))
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)]=
    tuple20(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)

  inline def tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)]=
    apply20(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)(Tuple20.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20], inline a21: F[L, A21])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[L, Z] =
    apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)(f)

  inline def apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20], inline a21: F[L, A21])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                val x15 = a15
                                if (x15.isLeft) {
                                  x15.asInstanceOf[F[L, Z]]
                                } else {
                                  val x16 = a16
                                  if (x16.isLeft) {
                                    x16.asInstanceOf[F[L, Z]]
                                  } else {
                                    val x17 = a17
                                    if (x17.isLeft) {
                                      x17.asInstanceOf[F[L, Z]]
                                    } else {
                                      val x18 = a18
                                      if (x18.isLeft) {
                                        x18.asInstanceOf[F[L, Z]]
                                      } else {
                                        val x19 = a19
                                        if (x19.isLeft) {
                                          x19.asInstanceOf[F[L, Z]]
                                        } else {
                                          val x20 = a20
                                          if (x20.isLeft) {
                                            x20.asInstanceOf[F[L, Z]]
                                          } else {
                                            val x21 = a21
                                            if (x21.isLeft) {
                                              x21.asInstanceOf[F[L, Z]]
                                            } else {
                                              scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get, x15.toOption.get, x16.toOption.get, x17.toOption.get, x18.toOption.get, x19.toOption.get, x20.toOption.get, x21.toOption.get))
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20], inline a21: F[L, A21]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)]=
    tuple21(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)

  inline def tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20], inline a21: F[L, A21]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)]=
    apply21(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)(Tuple21.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20], inline a21: F[L, A21], inline a22: F[L, A22])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[L, Z] =
    apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)(f)

  inline def apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L, Z](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20], inline a21: F[L, A21], inline a22: F[L, A22])(f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[L, Z] = {
    val x1 = a1
    if (x1.isLeft) {
      x1.asInstanceOf[F[L, Z]]
    } else {
      val x2 = a2
      if (x2.isLeft) {
        x2.asInstanceOf[F[L, Z]]
      } else {
        val x3 = a3
        if (x3.isLeft) {
          x3.asInstanceOf[F[L, Z]]
        } else {
          val x4 = a4
          if (x4.isLeft) {
            x4.asInstanceOf[F[L, Z]]
          } else {
            val x5 = a5
            if (x5.isLeft) {
              x5.asInstanceOf[F[L, Z]]
            } else {
              val x6 = a6
              if (x6.isLeft) {
                x6.asInstanceOf[F[L, Z]]
              } else {
                val x7 = a7
                if (x7.isLeft) {
                  x7.asInstanceOf[F[L, Z]]
                } else {
                  val x8 = a8
                  if (x8.isLeft) {
                    x8.asInstanceOf[F[L, Z]]
                  } else {
                    val x9 = a9
                    if (x9.isLeft) {
                      x9.asInstanceOf[F[L, Z]]
                    } else {
                      val x10 = a10
                      if (x10.isLeft) {
                        x10.asInstanceOf[F[L, Z]]
                      } else {
                        val x11 = a11
                        if (x11.isLeft) {
                          x11.asInstanceOf[F[L, Z]]
                        } else {
                          val x12 = a12
                          if (x12.isLeft) {
                            x12.asInstanceOf[F[L, Z]]
                          } else {
                            val x13 = a13
                            if (x13.isLeft) {
                              x13.asInstanceOf[F[L, Z]]
                            } else {
                              val x14 = a14
                              if (x14.isLeft) {
                                x14.asInstanceOf[F[L, Z]]
                              } else {
                                val x15 = a15
                                if (x15.isLeft) {
                                  x15.asInstanceOf[F[L, Z]]
                                } else {
                                  val x16 = a16
                                  if (x16.isLeft) {
                                    x16.asInstanceOf[F[L, Z]]
                                  } else {
                                    val x17 = a17
                                    if (x17.isLeft) {
                                      x17.asInstanceOf[F[L, Z]]
                                    } else {
                                      val x18 = a18
                                      if (x18.isLeft) {
                                        x18.asInstanceOf[F[L, Z]]
                                      } else {
                                        val x19 = a19
                                        if (x19.isLeft) {
                                          x19.asInstanceOf[F[L, Z]]
                                        } else {
                                          val x20 = a20
                                          if (x20.isLeft) {
                                            x20.asInstanceOf[F[L, Z]]
                                          } else {
                                            val x21 = a21
                                            if (x21.isLeft) {
                                              x21.asInstanceOf[F[L, Z]]
                                            } else {
                                              val x22 = a22
                                              if (x22.isLeft) {
                                                x22.asInstanceOf[F[L, Z]]
                                              } else {
                                                scalaz.LazyEither.lazyRight(f(x1.toOption.get, x2.toOption.get, x3.toOption.get, x4.toOption.get, x5.toOption.get, x6.toOption.get, x7.toOption.get, x8.toOption.get, x9.toOption.get, x10.toOption.get, x11.toOption.get, x12.toOption.get, x13.toOption.get, x14.toOption.get, x15.toOption.get, x16.toOption.get, x17.toOption.get, x18.toOption.get, x19.toOption.get, x20.toOption.get, x21.toOption.get, x22.toOption.get))
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20], inline a21: F[L, A21], inline a22: F[L, A22]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)]=
    tuple22(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)

  inline def tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, L](a1: F[L, A1], inline a2: F[L, A2], inline a3: F[L, A3], inline a4: F[L, A4], inline a5: F[L, A5], inline a6: F[L, A6], inline a7: F[L, A7], inline a8: F[L, A8], inline a9: F[L, A9], inline a10: F[L, A10], inline a11: F[L, A11], inline a12: F[L, A12], inline a13: F[L, A13], inline a14: F[L, A14], inline a15: F[L, A15], inline a16: F[L, A16], inline a17: F[L, A17], inline a18: F[L, A18], inline a19: F[L, A19], inline a20: F[L, A20], inline a21: F[L, A21], inline a22: F[L, A22]): F[L, (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)]=
    apply22(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)(Tuple22.apply)
}
