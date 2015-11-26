package com.roy_scala.nn.prototypes
import com.roy_scala.math.mil
import com.roy_scala.ml.mil.vector_util
/**
 * Created by rao on 15-11-22.
 */


class network(_id:Int, _graph:AnyRef, _n_inputs:Int, _init:() => Double, _alpha:Double) {
    val id = _id
    var graph = _graph match {
      case g:List[Int @unchecked] => g
    }
    val init = _init
    var layers:List[layer] = List()
    var alpha = _alpha
    var n_inputs = _n_inputs
    var input:Array[Double] = Array()
    var output:Array[Double] = Array()
    var target_ouput:Array[Double] = Array()
    var errors:Array[Double] = Array()
    var error:Double = 0d

    def initialize():Unit = {
      layers = List.tabulate(graph.length)(i=>new layer(i, graph(i), init))
      layers.head.initialize(n_inputs)
      // Initialize the first hidden layer
      for (i <- 1 until layers.length) layers(i).initialize(layers(i-1).width)
      // Initialize hidden layers other than the first one
    }

    def receive(_input:Array[Double], _target_ouput:Array[Double]):Unit = {
      input = _input
      target_ouput = _target_ouput
    }

    def _feed_forward(_layer_id:Int, _input:Array[Double], _layers:List[layer]):Array[Double] = {
        var i = _layer_id
        if(i >= _layers.length)
          {
            _input
          }
        else {
              val layer_output = _layers(i).feed_forward(_input)
              i += 1
              _feed_forward(i, layer_output, _layers)
        }
    }

    def feed_forward():Array[Double] = {
      val start_layer = 0
      output = _feed_forward(start_layer, input, layers)
      errors = vector_util.vector_diff(target_ouput, output)
      error = mil.squared_error(output, target_ouput)
      output
    }

    def _bp(_layer_id:Int, _deltas:Array[Double], _layers:List[layer], output_layer:Int, _alpha:Double):Unit = {
        var i = _layer_id
        if(i < 0){}
        else {
              val delta = _layers(i).bp(_deltas, output_layer, _alpha, _layers)
              i -= 1
              _bp(i, delta, _layers, output_layer, _alpha)
        }
    }

    def bp():Unit = {
        val start_layer = layers.length - 1
        val output_layer = start_layer
        _bp(start_layer, errors, layers, output_layer, alpha)
    }


}

