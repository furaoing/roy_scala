package com.roy_scala.math
import scala.math
import com.roy_scala.ml.mil.vector_util
/**
 * Created by roy on 2015/11/23.
 */ 
object mil {
    def sigmoid(x:Double):Double = 1/(1+math.exp(-x))

    def squared_error(x:Array[Double], y:Array[Double]):Double = {
        val z = vector_util.vector_diff(x, y)
        z.map((x:Double)=>math.pow(x, 2)).sum
    }
}
