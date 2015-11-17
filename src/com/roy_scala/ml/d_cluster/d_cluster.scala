package com.roy_scala.ml.d_cluster
import scala.collection.mutable.ListBuffer

/**
 * Created by roy on 2015/10/26.
 */

class d_cluster(_data:Array[Map[String, String]], _threshold:Float, _kernel:(String, String) => Float) {
    // Field Definition
    // accepted data structure: json string
    // Example: [{"token": "c:\\data\\1.txt", "content": "today is a good day"}, ... ]
    // token can be a file path or text series number (sn), hash, etc
    val data = _data
    val threshold = _threshold
    val kernel = _kernel

    var clusters: ListBuffer[Array[String]] = ListBuffer()
    var excludes: ListBuffer[Int] = ListBuffer()
    val tokens = data.map((x:Map[String, String]) => x("token"))
    val contents = data.map((x:Map[String, String]) => x("content"))

    def test_integrity() = println(tokens.mkString(" "))

    def test(content_a:String, content_b:String):Boolean = {
      val test_score = kernel(content_a, content_b)
      val result = if (test_score > threshold) true else false

      result   // return result in scala style, the last statement in a method is automatically returned
    }

    def find_derivative(current_index:Int):Array[String] = {
      val cluster = ListBuffer(tokens(current_index))
      if (!excludes.contains(current_index))
        {
            for (i <- current_index to tokens.length - 2)
              {
                 if (!excludes.contains(i+1))
                   {
                       if (test(contents(current_index), contents(i+1)))
                         {
                             cluster.append(tokens(i+1))
                             excludes.append(i+1)
                         }
                   }
              }
        }
      cluster.toArray
    }

    def clustering():Array[Array[String]] = {
      for (i <- 0 to tokens.length - 2)
        {
          if(!excludes.contains(i))
            {
              clusters.append(find_derivative(i))
              println("D-Clustering Iteration: " + i.toString)
            }
        }
      recover_tail()
      clusters.toArray
    }

    def recover_tail():Unit = {
        val index_of_tail = tokens.length - 1
        val existed = excludes.contains(index_of_tail)
        if (!existed) {
          val tail_as_cluster: Array[String] = Array(tokens(index_of_tail))
          clusters.append(tail_as_cluster)
        }
    }
}
