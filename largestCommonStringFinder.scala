/** 
  * @author : Hamidkhan Jahagirdar
  * =Largest Common String Finder=
  * ==This class finds the largest common substring in two String==
  * 
  */

object largestCommonStringFinder extends App {

  val comparisonResult = comparer("abd","bcarfbcmcgcdbdcd")

  println(s"comparisonResult => $comparisonResult")

  def comparer(first:String, second:String):String = {
    val (firstVal, secondVal) = first.size > second.size match{
      case true  => (second, first)
      case false => (first, second)
    }

// Enable comments for better understanding of the logic
/*
    println(s"firstVal => $firstVal")
    println(s"secondVal => $secondVal")
    println("-"*30)
    println()
*/
    val res1: Seq[List[(String, Int)]] = firstVal.zipWithIndex.map(startChar => {
      secondVal.map(String.valueOf(_)).zipWithIndex.filter( _._1 == String.valueOf(startChar._1)).toList
    })

/*  
    println("source data => ")
    res1.zipWithIndex.foreach(println)
    println("-"*30)
    println()
*/

    val res3: Seq[(List[(String, Int)], Int)] = res1.zipWithIndex.map((x: (List[(String, Int)], Int)) => {
      println(s"firstVal.isDefinedAt{${x._2 + 1}} => ${firstVal.isDefinedAt(x._2 + 1)}")
      println()
      firstVal.isDefinedAt(x._2 + 1) match {
        case true  => val res2 = x._1.map((y: (String, Int)) => {

                                    (0  to  (firstVal.size - (x._2 + 2))).map(_+ x._2).foldLeft(y)((intern, item) => finder(intern, firstVal, secondVal, item))

                                  })
                                (res2, x._2 + 1)
        case false => x
      }
    })

/*    
    res3.foreach(println)
    println()
    println("--"*30)
*/
    res3.map(x => x._1).flatten.map(x => x._1).sortBy(x => (x.length, x.head)).reverse.head
  }

  def finder(y:(String, Int), firstVal:String, secondVal:String, sourceIndex:Int):(String, Int)={
    secondVal.isDefinedAt(y._2 + 1) match {
      case true => secondVal.charAt(y._2 + 1) == firstVal.charAt(sourceIndex + 1) match {
        case true => (y._1.concat(String.valueOf(secondVal.charAt(y._2 + 1))), y._2 + 1)
        case false => (y._1, y._2)
      }
      case false => y
    }
  }



}
