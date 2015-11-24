package com.roy_scala.nn.prototypes

import scala.collection.mutable.ListBuffer

/**
 * Created by rao on 15-11-22.
 **/

class layer(_id:Int, _width:Int, _init:() => Double) {
    val id = _id
    val width = _width
    var nodes:List[node] = List()
    var output:Array[Double] = Array()
    var error:Array[Double] = Array()
    val init = _init

    def initialize():Unit = {
        nodes = List.tabulate(width)(x=>new node(x, Array.fill[Double](width)(init()),init()))
    }

    def feed_forward(_input:Array[Double]):Array[Double] = {
        _feed_forward(_input)
        }

    def _feed_forward(_input:Array[Double]):Array[Double] = {
        output = Array.tabulate(width)(x=>nodes(x).process(_input))
        output
    }

    def _bp(_layer_id:Int, _error:Array[Double]):Array[Double] = {
        
    }
}
