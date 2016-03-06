package com.roy_scala.util

/**
 * Created by rao on 16-3-6.
 */
object PwExhaust {
    def loop(x:Range, y:List[Int]):List[List[Int]] = {
    var code:List[List[Int]] = List()
    for (i <- x){
      code = code :+ (y :+ i)
    }
  code
  }

  def expand_group(x:Range, y:List[List[Int]]):List[List[Int]] = {
    var code:List[List[Int]] = List()
    for (a_list <- y){
      code = code ::: loop(x, a_list)
    }
    code
  }

  def loop_recursive(depth:Int, bank:Range):List[List[Int]] = {
    if (depth==0){
      val a = List.tabulate(bank.length)(x=>List(x))
      a
    }
    else{
      expand_group(bank, loop_recursive(depth-1, bank))
    }
  }

  def loop_helper(depth:Int, bank:List[Int]) = {
    //val depth = 2
    //val bank = 1 to 3
    val result = loop_recursive(depth, bank)
    println(result.length)
  }
}
