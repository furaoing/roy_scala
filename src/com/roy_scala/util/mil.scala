package com.roy_scala.util

/**
 * Created by roy on 2015/10/22.
 */

object mil {
  def strip_all(rm_chars:Array[String], tar_str:String):String = {
    var target = tar_str
    var arr_len = rm_chars.length;
    while (arr_len >= 1){
      target = target.replace(rm_chars(arr_len-1), "")
      arr_len -= 1
    }
    target
  }

}
