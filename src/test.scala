import com.roy_scala.ml.d_cluster.d_cluster
import com.roy_scala.util.mil
import com.roy_scala.util.json
import com.roy_scala.util.IO
import com.roy_scala.util
import com.roy_scala.nlp.vocabulary_miner.get_tf
import com.roy_scala.ml.d_cluster
import com.roy_scala.nn.prototypes._
import com.roy_scala.util.Timer

// import com.roy_scala.util.json
import com.roy_scala.ml.mil.collection
import com.roy_scala.ml.mil.vector_util


/**
 * Created by roy on 2015/10/26.
 */

object test {
  def main(args: Array[String]):Unit = {

    /*
    val json_path = "C:\\Users\\roy\\Desktop\\test_scala_fileio.txt"

    val json_obj = json.parse_json_from_file(json_path)
    println(json_obj.toString)

    //[{"token": "c:\\data\\1.txt", "content": "today is a good day"}, ... ]
    // val data = Array(Map("token" -> "aaa", "content" -> "bbb"), Map("token" -> "ccc", "content" -> "ddd"), Map("token" -> "cdcc", "content" -> "ddxxd"))
    val data = json_obj.asInstanceOf[Array[Map[String, String]]]

    val threshold:Float = 0.4f
    val kernel= (x:String, y:String) => 0.5f

    val d_cluster = new d_cluster(data, threshold, kernel)
    d_cluster.test_integrity()
    val clu = d_cluster.clustering()
    */

    /*
    val a = Map("token" -> "c", "content" -> "bbb")
    val b = List(List(1,2,333),2,Map("a"->2))
    val m_str = json.json_dumps(b)
    println(m_str)
     */

    /*
    val pth = "D:\\workspace\\Taikor_NLP_service\\fundamental_service\\CN_PoS_Segmentation_Horizontal_Test\\SIGHan\\icwb2-data\\testing\\pku_test.utf8"
    val test_str = IO.FileIO.read(pth)
    println(test_str.length())
    val timer = new util.Timer()
    timer.start()
    val result = get_tf(test_str)
    timer.end()
    println(timer.time_c)
    println(result.mkString(" "))
    */


    val tmr = new Timer()
   val graph = List(3,3,3,1)

    val my_input = Array(Array(1d,0d),
                         Array(0d,1d),
                         Array(1d,1d),
                         Array(0d,0d)
    )
    val target_output = Array(Array(0d),
                         Array(0d),
                         Array(1d),
                         Array(1d)
    )
   val a = new network(1, graph, 2, mil.random_double, 0.05)
    a.initialize()
    tmr.start()
    for (j <- 0 until 10000) {
      for (i <- 0 until 4) {
        a.alpha *= 0.9
        val e_input = my_input(i)
        val e_target = target_output(i)
        a.receive(e_input, e_target)
        a.feed_forward()
        a.bp()
        // println(a.layers(0).nodes(0).weight(0))
        println(a.error)
      }
    }
    tmr.end()
    println(tmr.time_c)

    for (i <- 0 until 4) {
        val e_input = my_input(i)
        val e_target = target_output(i)
        a.receive(e_input, e_target)
        a.feed_forward()
        println(e_input.mkString(" "))
        println(a.output.mkString(" "))
      }

    /*
    def give_one() = 1.0d
    val graph = List(1, 1)
    val a = new network(1, graph, 1, give_one, 0.01)
    val input = Array(1.0d)
    a.initialize()
    a.receive(input, Array(1.0d))
    a.feed_forward()
    a.bp()
    println(a.layers(0).nodes(0).delta)
    */
  }
}

