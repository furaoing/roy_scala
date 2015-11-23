package com.roy_scala.util

import com.roy_scala.util.IO.FileIO._
import scala.util.parsing.json.JSON

/**
 * Created by roy on 2015/10/22.
 */

object json {

  def json_loads(json_str: String): Any =
    {
      val json_parsed = JSON.parseFull(json_str)
      val return_val = json_parsed match {
        // Matches if jsonStr is valid JSON and represents a Map of Strings to Any
        case Some(map: Map[Any @unchecked, Any @unchecked]) => map
        case Some(list: List[Any @unchecked]) => list
        case None => println("Parsing failed"); None
        case other => println("Unknown data structure: " + other); None
      }
      return_val
    }

  def map_dumps(_map:Map[String, Any]):String = {
      val keys = _map.keySet
      var my_str = "{"
      var pair:String = ""
      for (key <- keys) {
          pair = _map(key) match {
          case s:String => "\"" + key + "\":\"" +  s + "\""
          case i:Int => "\"" + key + "\":" +  i.toString
          case l:List[Any @unchecked] => list_dumps(l)
          case m:Map[String @unchecked, Any @unchecked] => map_dumps(m)
          //case None => println("None Value Found");throw Exception
          //case other => println("Unknown data structure: " + other);throw Exception
        }
        my_str += pair + ","
      }
      my_str = my_str.stripSuffix(",")
      my_str += "}"
      my_str
    }


    def list_dumps(_list:List[Any]):String = {
      var my_str = "["
      var ele_str:String = ""
      for (ele <- _list) {
          ele_str = ele match {
          case s:String => "\"" + s + "\""
          case i:Int => i.toString
          case l:List[Any @unchecked] => list_dumps(l)
          case m:Map[String @unchecked, Any @unchecked] => map_dumps(m)
          //case None => println("None Value Found");throw Exception
          //case other => println("Unknown data structure: " + other);throw Exception
        }
        my_str += ele_str + ","
      }
      my_str = my_str.stripSuffix(",")
      my_str += "]"
      my_str
    }


    def json_dumps(json_obj:AnyRef):String = json_obj match {
          case m:Map[String @unchecked,Any @unchecked] => map_dumps(m)
          case l:List[Any @unchecked] => list_dumps(l)
    }


  def dump_json_to_file(json_obj: AnyRef, pth: String): Unit =
    {
      val json_str:String = json_dumps(json_obj)
      write(json_str, pth)
    }

  def load_json_from_file(pth: String): Any =
    {
      val json_str = read(pth)
      val json_parsed = json_loads(json_str)
      json_parsed
    }
}
