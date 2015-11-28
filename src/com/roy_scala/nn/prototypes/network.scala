package com.roy_scala.nn.prototypes
import com.roy_scala.math.mil
import com.roy_scala.ml.mil.vector_util
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
    var target_ouput:Array[Double] = Array()
    var errors:Array[Double] = Array()
    var error:Double = 0d

    def initialize():Unit = {
      val graph_hidden_part = graph.tail
      val n_input = graph.head

      layers = List.tabulate(graph_hidden_part.length)(i=>new layer(i, graph_hidden_part(i), init))

      layers.head.initialize(n_input)
      // Initialize the first hidden layer
      for (i <- 1 until layers.length) layers(i).initialize(layers(i-1).width)
      // Initialize hidden layers other than the first one
    }

    def receive(_input:Array[Double], _target_ouput:Array[Double]):Unit = {
      input = _input
      target_ouput = _target_ouput
    }

    def _feed_forward():Array[Double] = {
        var layer_output:Array[Double] = input
        for (i <- layers.indices)
          {
            layer_output = layers(i).feed_forward(layer_output)
          }
      layer_output
    }

    def feed_forward():Array[Double] = {
      output = _feed_forward()
      errors = vector_util.vector_diff(target_ouput, output)
      error = 0.5*mil.squared_error(output, target_ouput)
      output
    }

    def bp():Unit = {
        var deltas = errors
        for (i <- layers.indices.reverse)
          {
            deltas = layers(i).bp(deltas, alpha, layers)
          }
    }

    def update():Unit = {
        for (i <- layers.indices)
          {
            layers(i).update(alpha)
          }
    }

    def train(_input:Array[Double], _target_ouput:Array[Double]):Double = {
      receive(_input, _target_ouput)
      feed_forward()
      bp()
      update()
      error
    }

    def activate(_input:Array[Double]) = {
        input = _input
        val act_output = feed_forward()
        act_output
    }
}

