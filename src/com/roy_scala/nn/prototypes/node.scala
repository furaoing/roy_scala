package com.roy_scala.nn.prototypes

/**
 * Created by rao on 15-11-22.
 */

class node(_id: Int, _weight:Array[Double], _bias:Double) {
    val id = _id
    var weight = _weight
    var output = 0
    var error = 0
    var bias = _bias
}
