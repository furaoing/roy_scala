import com.roy_scala.ml.d_cluster.d_cluster
import com.roy_scala.util.mil
import com.roy_scala.util.json
import com.roy_scala.util.IO
import com.roy_scala.util
import com.roy_scala.nlp.vocabulary_miner.get_tf
import com.roy_scala.ml.d_cluster
import com.roy_scala.nn.prototypes._

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

   val graph = List(3,3,3)
   val a = new network(1, graph, mil.random_double, 0.2)
  }
}

