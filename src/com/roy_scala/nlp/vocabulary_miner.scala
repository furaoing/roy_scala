package com.roy_scala.nlp

import scala.collection.mutable.ListBuffer
import scala.collection.mutable

object vocabulary_miner {
  def tokenize(content:String):Array[String] = {
    val token_candidate:ListBuffer[String] = ListBuffer()
    val len = content.length
    var i = 0
    while (i < len - 1)
    {
        token_candidate.append(content.substring(i, i + 2))
        i += 1
    }
    token_candidate.toArray
  }

  def construct_tf(token_candidate:Array[String]):mutable.Map[String, Int] = {
    val len = token_candidate.length
    var key:String = ""
    val tf:mutable.Map[String, Int] = mutable.Map()
    var i = 0
    while (i < len) {
      key = token_candidate(i)
      if (tf.contains(key)) tf(key) += 1
       else tf(key) = 1
      i += 1
    }
    tf
  }

  def get_tf(content:String):Array[(String, Int)] = {
    val token_candidate:Array[String] = tokenize(content)
    val tf:mutable.Map[String, Int] = construct_tf(token_candidate)
    tf.toArray.sortBy(_._2)
  }

}
