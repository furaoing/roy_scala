package com.roy_scala.util
import scala.util.Random

/**
 * Created by roy on 2015/10/22.
 */

object mil {
  def strip_all(rm_chars:Array[String], tar_str:String):String = {
    var target = tar_str
    var arr_len = rm_chars.length
    while (arr_len >= 1){
      target = target.replace(rm_chars(arr_len-1), "")
      arr_len -= 1
    }
    target
  }

  def random_float(): Float= {
    val r_obj = new Random()
    val random_n = r_obj.nextFloat()
    random_n
  }

  def random_double(): Double= {
    val r_obj = new Random()
    val random_n = r_obj.nextDouble()
    random_n
  }
}
