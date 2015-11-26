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
    var delta = 0d
    var bias = _bias
    var input:Array[Double] = Array()

    def receive_addup(_input:Array[Double]):Double =
        {
            input = _input
            vector_util.dot_product(_input, weight) + bias
        }

    def activate(_input:Double):Double = {
        output = mil.sigmoid(_input)
        output
    }

    def process(_input:Array[Double]):Double= {
        val weighted_sum = receive_addup(_input)
        activate(weighted_sum)
    }

    def update_weight(_alpha:Double):Unit = {
        for (i <- weight.indices)
            weight(i) += _alpha*delta*input(i)
        bias += _alpha*delta
    }

}
