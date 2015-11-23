package com.roy_scala.nn.prototypes

import scala.collection.mutable.ListBuffer

/**
 * Created by rao on 15-11-22.
 */

class layer(_id:Int, _width:Int, _init:(Unit) => Double) {
    val id = _id
    val width = _width
    var nodes:List[node] = List()
    val init = _init

    def initialize():Unit = {
        nodes = (0 until width).toList.map((x:Int)=>new node(x, Array.fill[Double](width)(init()),init()))
    }
}
