import com.roy_scala.ml.d_cluster.d_cluster
import com.roy_scala.util.mil
import com.roy_scala.util.json
import com.roy_scala.util.IO
import com.roy_scala.ml.d_cluster
import play.api.libs.json.JsValue

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


    val a = Map("token" -> "c", "content" -> "bbb")
    val b = List(List(1,2,333),2,Map("a"->2))
    val m_str = json.json_dumps(b)
    println(m_str)

  }
}

