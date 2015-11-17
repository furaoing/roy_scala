package com.roy_scala.ml.mil

/**
 * Created by roy on 2015/10/28.
 */

object vector_util {
  def dot_product(x:Array[Float], y:Array[Float]):Float = {
    var array_len = x.length
    var result:Float = 0f
    var buffer:Float = 0f
    while (array_len >= 1)
      {
        buffer = x(array_len-1) * y(array_len-1)
        result += buffer
        array_len -= 1
      }
    result
  }

  def vector_norm(x:Array[Float]):Float = {
    var array_len = x.length
    var result:Float = 0f
    var buffer:Float = 0f
    while (array_len >= 1)
      {
        buffer = x(array_len-1) * x(array_len-1)
        result += buffer
        array_len -= 1
      }
    math.sqrt(result).toFloat
  }

  def cosine(x:Array[Float], y:Array[Float]) = {
    val dot_prod = dot_product(x, y)
    val result = dot_prod/(vector_norm(x) * vector_norm(y))
    result
  }

}
