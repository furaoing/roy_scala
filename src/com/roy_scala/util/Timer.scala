package com.roy_scala.util

/**
 * Created by roy on 2015/11/19.
 */
class Timer {
    var start_time:Long = 0l
    var end_time:Long = 0l
    var time_c:Long = 0l

    def start():Unit = {
      start_time = System.currentTimeMillis()
    }

    private def time():Unit = {
      time_c = end_time - start_time
    }

    def end():Unit = {
      end_time = System.currentTimeMillis()
      time()
    }
  }

object Timer {
  def pause(pause_time:Int) {
    Thread sleep pause_time
  }
}

