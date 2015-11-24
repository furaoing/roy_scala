package com.roy_scala.ml.mil

/**
 * Created by roy on 2015/10/28.
 */

object vector_util {
  def dot_product(x:Array[Double], y:Array[Double]):Double = {
    var array_len = x.length
    var result:Double = 0d
    var buffer:Double = 0d
    while (array_len >= 1)
      {
        buffer = x(array_len-1) * y(array_len-1)
        result += buffer
        array_len -= 1
      }
    result
  }

  def vector_norm(x:Array[Double]):Double = {
    var array_len = x.length
    var result:Double = 0f
    var buffer:Double = 0f
    while (array_len >= 1)
      {
        buffer = x(array_len-1) * x(array_len-1)
        result += buffer
        array_len -= 1
      }
    math.sqrt(result).toDouble
  }

  def cosine(x:Array[Double], y:Array[Double]) = {
    val dot_prod = dot_product(x, y)
    val result = dot_prod/(vector_norm(x) * vector_norm(y))
    result
  }

}
