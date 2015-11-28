package com.roy_scala.nn.prototypes
import scala.collection.mutable.ListBuffer
import com.roy_scala.ml.mil.vector_util

/**
 * Created by rao on 15-11-22.
 **/

class layer(_id:Int, _width:Int, _init:() => Double) {
    val id = _id
    val width = _width
    var nodes:List[node] = List()
    var output:Array[Double] = Array()
    var deltas:Array[Double] = Array()
    val init = _init

    def cal_delta_f(a:Double, b:Double):Double = a*(1-a)*b

    def initialize(n_weight:Int):Unit = {
        nodes = List.tabulate(width)(x=>new node(x, Array.fill[Double](n_weight)(init()),init()))
    }


    def feed_forward(_input:Array[Double]):Array[Double] = {
        output = Array.tabulate(width)(i=>nodes(i).process(_input))
        output
    }

    def bp(_deltas:Array[Double], _alpha:Double, _layers:List[layer]):Array[Double] = {
        if (id == _layers.length - 1)
            {
                deltas = vector_util.vector_comp(output, _deltas, cal_delta_f)
                for (i <- nodes.indices) {
                    nodes(i).delta = deltas(i)
                }
                deltas
            }
        else
            {
                for (i <- nodes.indices) {
                    var tmp = 0d
                    for (j <- _layers(id+1).nodes.indices)
                        tmp += _layers(id+1).nodes(j).weight(i)*_layers(id+1).nodes(j).delta
                    nodes(i).delta = cal_delta_f(nodes(i).output, tmp)
                }
                deltas = nodes.map((x:node)=>x.delta).toArray
                deltas
            }
    }

    def update(_alpha:Double) = {
        for (i <- nodes.indices) {
            nodes(i).update_weight(_alpha)
        }
    }

}
