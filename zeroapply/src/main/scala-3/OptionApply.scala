package zeroapply

object OptionApply {

  import scala.{Option => F}


  inline def apply[A1, A2, Z](a1: F[A1], inline a2: F[A2])(inline f: (A1, A2) => Z): F[Z] =
    apply2[A1, A2, Z](a1, a2)(f)

  inline def apply2[A1, A2, Z](a1: F[A1], inline a2: F[A2])(inline f: (A1, A2) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        Some(f(x1.get, x2.get))
      }
    }
  }

  inline def tuple[A1, A2](a1: F[A1], inline a2: F[A2]): F[(A1, A2)] =
    tuple2[A1, A2](a1, a2)

  inline def tuple2[A1, A2](a1: F[A1], inline a2: F[A2]): F[(A1, A2)] =
    apply2(a1, a2)(Tuple2.apply)

  inline def apply[A1, A2, A3, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3])(inline f: (A1, A2, A3) => Z): F[Z] =
    apply3[A1, A2, A3, Z](a1, a2, a3)(f)

  inline def apply3[A1, A2, A3, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3])(inline f: (A1, A2, A3) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          Some(f(x1.get, x2.get, x3.get))
        }
      }
    }
  }

  inline def tuple[A1, A2, A3](a1: F[A1], inline a2: F[A2], inline a3: F[A3]): F[(A1, A2, A3)] =
    tuple3[A1, A2, A3](a1, a2, a3)

  inline def tuple3[A1, A2, A3](a1: F[A1], inline a2: F[A2], inline a3: F[A3]): F[(A1, A2, A3)] =
    apply3(a1, a2, a3)(Tuple3.apply)

  inline def apply[A1, A2, A3, A4, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4])(inline f: (A1, A2, A3, A4) => Z): F[Z] =
    apply4[A1, A2, A3, A4, Z](a1, a2, a3, a4)(f)

  inline def apply4[A1, A2, A3, A4, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4])(inline f: (A1, A2, A3, A4) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            Some(f(x1.get, x2.get, x3.get, x4.get))
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4]): F[(A1, A2, A3, A4)] =
    tuple4[A1, A2, A3, A4](a1, a2, a3, a4)

  inline def tuple4[A1, A2, A3, A4](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4]): F[(A1, A2, A3, A4)] =
    apply4(a1, a2, a3, a4)(Tuple4.apply)

  inline def apply[A1, A2, A3, A4, A5, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5])(inline f: (A1, A2, A3, A4, A5) => Z): F[Z] =
    apply5[A1, A2, A3, A4, A5, Z](a1, a2, a3, a4, a5)(f)

  inline def apply5[A1, A2, A3, A4, A5, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5])(inline f: (A1, A2, A3, A4, A5) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              Some(f(x1.get, x2.get, x3.get, x4.get, x5.get))
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5]): F[(A1, A2, A3, A4, A5)] =
    tuple5[A1, A2, A3, A4, A5](a1, a2, a3, a4, a5)

  inline def tuple5[A1, A2, A3, A4, A5](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5]): F[(A1, A2, A3, A4, A5)] =
    apply5(a1, a2, a3, a4, a5)(Tuple5.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6])(inline f: (A1, A2, A3, A4, A5, A6) => Z): F[Z] =
    apply6[A1, A2, A3, A4, A5, A6, Z](a1, a2, a3, a4, a5, a6)(f)

  inline def apply6[A1, A2, A3, A4, A5, A6, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6])(inline f: (A1, A2, A3, A4, A5, A6) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get))
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6]): F[(A1, A2, A3, A4, A5, A6)] =
    tuple6[A1, A2, A3, A4, A5, A6](a1, a2, a3, a4, a5, a6)

  inline def tuple6[A1, A2, A3, A4, A5, A6](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6]): F[(A1, A2, A3, A4, A5, A6)] =
    apply6(a1, a2, a3, a4, a5, a6)(Tuple6.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7])(inline f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[Z] =
    apply7[A1, A2, A3, A4, A5, A6, A7, Z](a1, a2, a3, a4, a5, a6, a7)(f)

  inline def apply7[A1, A2, A3, A4, A5, A6, A7, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7])(inline f: (A1, A2, A3, A4, A5, A6, A7) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get))
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7]): F[(A1, A2, A3, A4, A5, A6, A7)] =
    tuple7[A1, A2, A3, A4, A5, A6, A7](a1, a2, a3, a4, a5, a6, a7)

  inline def tuple7[A1, A2, A3, A4, A5, A6, A7](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7]): F[(A1, A2, A3, A4, A5, A6, A7)] =
    apply7(a1, a2, a3, a4, a5, a6, a7)(Tuple7.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[Z] =
    apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](a1, a2, a3, a4, a5, a6, a7, a8)(f)

  inline def apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get))
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8]): F[(A1, A2, A3, A4, A5, A6, A7, A8)] =
    tuple8[A1, A2, A3, A4, A5, A6, A7, A8](a1, a2, a3, a4, a5, a6, a7, a8)

  inline def tuple8[A1, A2, A3, A4, A5, A6, A7, A8](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8]): F[(A1, A2, A3, A4, A5, A6, A7, A8)] =
    apply8(a1, a2, a3, a4, a5, a6, a7, a8)(Tuple8.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[Z] =
    apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9)(f)

  inline def apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9)] =
    tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9](a1, a2, a3, a4, a5, a6, a7, a8, a9)

  inline def tuple9[A1, A2, A3, A4, A5, A6, A7, A8, A9](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9)] =
    apply9(a1, a2, a3, a4, a5, a6, a7, a8, a9)(Tuple9.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[Z] =
    apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)(f)

  inline def apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)] =
    tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)

  inline def tuple10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)] =
    apply10(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)(Tuple10.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[Z] =
    apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)(f)

  inline def apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)] =
    tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)

  inline def tuple11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)] =
    apply11(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)(Tuple11.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[Z] =
    apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)(f)

  inline def apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)] =
    tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)

  inline def tuple12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)] =
    apply12(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)(Tuple12.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[Z] =
    apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)(f)

  inline def apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)] =
    tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)

  inline def tuple13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)] =
    apply13(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)(Tuple13.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[Z] =
    apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)(f)

  inline def apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)] =
    tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)

  inline def tuple14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)] =
    apply14(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)(Tuple14.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[Z] =
    apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)(f)

  inline def apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                val x15 = a15
                                if (x15.isEmpty) {
                                  None
                                } else {
                                  Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get, x15.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)] =
    tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)

  inline def tuple15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)] =
    apply15(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)(Tuple15.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[Z] =
    apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)(f)

  inline def apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                val x15 = a15
                                if (x15.isEmpty) {
                                  None
                                } else {
                                  val x16 = a16
                                  if (x16.isEmpty) {
                                    None
                                  } else {
                                    Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get, x15.get, x16.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)] =
    tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)

  inline def tuple16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)] =
    apply16(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)(Tuple16.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[Z] =
    apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)(f)

  inline def apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                val x15 = a15
                                if (x15.isEmpty) {
                                  None
                                } else {
                                  val x16 = a16
                                  if (x16.isEmpty) {
                                    None
                                  } else {
                                    val x17 = a17
                                    if (x17.isEmpty) {
                                      None
                                    } else {
                                      Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get, x15.get, x16.get, x17.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)] =
    tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)

  inline def tuple17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)] =
    apply17(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)(Tuple17.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[Z] =
    apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)(f)

  inline def apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                val x15 = a15
                                if (x15.isEmpty) {
                                  None
                                } else {
                                  val x16 = a16
                                  if (x16.isEmpty) {
                                    None
                                  } else {
                                    val x17 = a17
                                    if (x17.isEmpty) {
                                      None
                                    } else {
                                      val x18 = a18
                                      if (x18.isEmpty) {
                                        None
                                      } else {
                                        Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get, x15.get, x16.get, x17.get, x18.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)] =
    tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)

  inline def tuple18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)] =
    apply18(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)(Tuple18.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[Z] =
    apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)(f)

  inline def apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                val x15 = a15
                                if (x15.isEmpty) {
                                  None
                                } else {
                                  val x16 = a16
                                  if (x16.isEmpty) {
                                    None
                                  } else {
                                    val x17 = a17
                                    if (x17.isEmpty) {
                                      None
                                    } else {
                                      val x18 = a18
                                      if (x18.isEmpty) {
                                        None
                                      } else {
                                        val x19 = a19
                                        if (x19.isEmpty) {
                                          None
                                        } else {
                                          Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get, x15.get, x16.get, x17.get, x18.get, x19.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)] =
    tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)

  inline def tuple19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)] =
    apply19(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)(Tuple19.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[Z] =
    apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)(f)

  inline def apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                val x15 = a15
                                if (x15.isEmpty) {
                                  None
                                } else {
                                  val x16 = a16
                                  if (x16.isEmpty) {
                                    None
                                  } else {
                                    val x17 = a17
                                    if (x17.isEmpty) {
                                      None
                                    } else {
                                      val x18 = a18
                                      if (x18.isEmpty) {
                                        None
                                      } else {
                                        val x19 = a19
                                        if (x19.isEmpty) {
                                          None
                                        } else {
                                          val x20 = a20
                                          if (x20.isEmpty) {
                                            None
                                          } else {
                                            Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get, x15.get, x16.get, x17.get, x18.get, x19.get, x20.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)] =
    tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)

  inline def tuple20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)] =
    apply20(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)(Tuple20.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20], inline a21: F[A21])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[Z] =
    apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)(f)

  inline def apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20], inline a21: F[A21])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                val x15 = a15
                                if (x15.isEmpty) {
                                  None
                                } else {
                                  val x16 = a16
                                  if (x16.isEmpty) {
                                    None
                                  } else {
                                    val x17 = a17
                                    if (x17.isEmpty) {
                                      None
                                    } else {
                                      val x18 = a18
                                      if (x18.isEmpty) {
                                        None
                                      } else {
                                        val x19 = a19
                                        if (x19.isEmpty) {
                                          None
                                        } else {
                                          val x20 = a20
                                          if (x20.isEmpty) {
                                            None
                                          } else {
                                            val x21 = a21
                                            if (x21.isEmpty) {
                                              None
                                            } else {
                                              Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get, x15.get, x16.get, x17.get, x18.get, x19.get, x20.get, x21.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20], inline a21: F[A21]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)] =
    tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)

  inline def tuple21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20], inline a21: F[A21]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)] =
    apply21(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)(Tuple21.apply)

  inline def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20], inline a21: F[A21], inline a22: F[A22])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[Z] =
    apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)(f)

  inline def apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20], inline a21: F[A21], inline a22: F[A22])(inline f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z): F[Z] = {
    val x1 = a1
    if (x1.isEmpty) {
      None
    } else {
      val x2 = a2
      if (x2.isEmpty) {
        None
      } else {
        val x3 = a3
        if (x3.isEmpty) {
          None
        } else {
          val x4 = a4
          if (x4.isEmpty) {
            None
          } else {
            val x5 = a5
            if (x5.isEmpty) {
              None
            } else {
              val x6 = a6
              if (x6.isEmpty) {
                None
              } else {
                val x7 = a7
                if (x7.isEmpty) {
                  None
                } else {
                  val x8 = a8
                  if (x8.isEmpty) {
                    None
                  } else {
                    val x9 = a9
                    if (x9.isEmpty) {
                      None
                    } else {
                      val x10 = a10
                      if (x10.isEmpty) {
                        None
                      } else {
                        val x11 = a11
                        if (x11.isEmpty) {
                          None
                        } else {
                          val x12 = a12
                          if (x12.isEmpty) {
                            None
                          } else {
                            val x13 = a13
                            if (x13.isEmpty) {
                              None
                            } else {
                              val x14 = a14
                              if (x14.isEmpty) {
                                None
                              } else {
                                val x15 = a15
                                if (x15.isEmpty) {
                                  None
                                } else {
                                  val x16 = a16
                                  if (x16.isEmpty) {
                                    None
                                  } else {
                                    val x17 = a17
                                    if (x17.isEmpty) {
                                      None
                                    } else {
                                      val x18 = a18
                                      if (x18.isEmpty) {
                                        None
                                      } else {
                                        val x19 = a19
                                        if (x19.isEmpty) {
                                          None
                                        } else {
                                          val x20 = a20
                                          if (x20.isEmpty) {
                                            None
                                          } else {
                                            val x21 = a21
                                            if (x21.isEmpty) {
                                              None
                                            } else {
                                              val x22 = a22
                                              if (x22.isEmpty) {
                                                None
                                              } else {
                                                Some(f(x1.get, x2.get, x3.get, x4.get, x5.get, x6.get, x7.get, x8.get, x9.get, x10.get, x11.get, x12.get, x13.get, x14.get, x15.get, x16.get, x17.get, x18.get, x19.get, x20.get, x21.get, x22.get))
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

  inline def tuple[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20], inline a21: F[A21], inline a22: F[A22]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)] =
    tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)

  inline def tuple22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](a1: F[A1], inline a2: F[A2], inline a3: F[A3], inline a4: F[A4], inline a5: F[A5], inline a6: F[A6], inline a7: F[A7], inline a8: F[A8], inline a9: F[A9], inline a10: F[A10], inline a11: F[A11], inline a12: F[A12], inline a13: F[A13], inline a14: F[A14], inline a15: F[A15], inline a16: F[A16], inline a17: F[A17], inline a18: F[A18], inline a19: F[A19], inline a20: F[A20], inline a21: F[A21], inline a22: F[A22]): F[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)] =
    apply22(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)(Tuple22.apply)
}
