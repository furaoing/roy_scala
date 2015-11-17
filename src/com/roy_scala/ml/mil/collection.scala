package com.roy_scala.ml.mil

import scala.collection.mutable.ListBuffer

/**
 * Created by rao on 15-11-1.
 */
object collection {
  def combination(max_num:Int):Array[Set[Int]]= {
    val comb_container:ListBuffer[Set[Int]]= ListBuffer()
      for (i <- 0 to max_num - 2)
        {
          for (j <- i + 1 to max_num -1)
            {
              comb_container.append(Set(i, j))
            }
        }
    comb_container.toArray
  }
}
