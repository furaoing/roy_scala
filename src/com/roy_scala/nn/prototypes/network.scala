package com.roy_scala.nn.prototypes

/**
 * Created by rao on 15-11-22.
 */


class network(_id:Int, _graph:AnyRef, _init:() => Double, _alpha:Double) {
    val id = _id
    var graph = _graph match {
      case g:List[Int @unchecked] => g
    }
    val init = _init
    var layers:List[layer] = List()
    var alpha = _alpha
    var input:Array[Double] = Array()
    var output:Array[Double] = Array()
    var _target_ouput:Array[Double] = Array()

    def initialize():Unit = {
      layers = graph.map((x:Int)=>new layer(graph.indexOf(x), x, init))
      for (x <- layers) x.initialize()
    }

    def receive(_input:Array[Double], _target_ouput:Array[Double]):Unit = {
      input = _input
      output = _target_ouput
    }

    def _feed_forward(_layer_id:Int, _input:Array[Double], _layers:List[layer]):Array[Double] = {
        var i = _layer_id
        if(i >= _layers.length-1)
          {
            val output = _input
            output
          }
        else {
              val layer_output = _layers(i).feed_forward(_input)
              i += 1
              _feed_forward(i, layer_output, _layers)
        }
    }

    def feed_forward():Array[Double] = {
      val start_layer = 0
      _feed_forward(start_layer, input, layers)
    }


}

