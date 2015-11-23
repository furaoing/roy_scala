package com.roy_scala.nn.prototypes

/**
 * Created by rao on 15-11-22.
 */
+

class network(_id:Int, _graph:AnyRef, _init:(Unit) => Double) {
    val id = _id
    var graph = _graph match {
      case g:List[Int] => g
    }
    val init = _init
    var layers:List[layer] = List()

    def initialize():Unit = {
      layers = graph.map((x:Int)=>new layer(graph.indexOf(x), x, init))
    }
}

