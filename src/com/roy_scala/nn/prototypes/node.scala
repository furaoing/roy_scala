package com.roy_scala.nn.prototypes
import com.roy_scala.ml.mil.vector_util
import com.roy_scala.math.mil
/**
 * Created by rao on 15-11-22.
 */

class node(_id: Int, _weight:Array[Double], _bias:Double) {
    val id = _id
    var weight = _weight
    var output = 0d
    var error = 0d
    var bias = _bias

    def receive_addup(_input:Array[Double]):Double = vector_util.dot_product(_input, weight) + bias

    def activate(_input:Double):Double = {
        output = mil.sigmoid(_input)
        output
    }

    def process(_input:Array[Double]):Double= {
        activate(receive_addup(_input))
    }

    def update_weight(_alpha:Double):Unit = {
        weight.foreach((x:Double)=>x+_alpha*error*output)
        bias = _alpha*error
    }
}