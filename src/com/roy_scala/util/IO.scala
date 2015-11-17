package com.roy_scala.util

/**
 * Created by Roy on 22/10/2015.
 */

import java.io._
import scala.io.Source
import com.roy_scala.util.mil.strip_all

object IO {
  object FileIO {
    def read(file_path: String): String = {
      val file = Source.fromFile(file_path)
      val content = file.mkString
      file.close()
      content
    }

    def write(file_path: String, content: String): Unit = {
      val writer = new PrintWriter(new File(file_path))
      writer.write(content)
      writer.close()
    }

    def listFiles(dir_path: String): Array[File] = {
      val files = new File(dir_path).listFiles
      files
    }

    def listFilesAbsPth(dir_path: String): Array[String] = {
      val files = listFiles(dir_path)
      val files_absPth = files.map(file => file.getAbsolutePath)
      files_absPth
    }

    def read_list(file_path: String): Array[String] = {
      val file = Source.fromFile(file_path)
      val content = file.mkString
      val content_list = content.split("\n")
      var list_len = content_list.length
      val rm_chars = Array("\n", "\t", " ", "\t")
      while (list_len >= 1)
        {
          content_list(list_len-1) = strip_all(rm_chars, content_list(list_len-1))
          list_len -= 1
        }
      file.close()
      content_list
    }
  }
}


