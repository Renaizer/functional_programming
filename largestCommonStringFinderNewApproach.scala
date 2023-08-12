
object largestCommonStringFinderNewApproach extends App {


  val comparisonResult = comparer("abcde","bcdearfbcmcgcdbadcd")

  println(comparisonResult)


    def comparer(first: String, second: String): String = {
      val (firstVal, secondVal) = first.size > second.size match {
        case true => (second, first)
        case false => (first, second)
      }

      findAllPossibleStrings(firstVal)
        .map(x => {
            secondVal.contains(x) match {
              case true  => (x, true)
              case false => (x, false)
            }
          })
        .filter(x => x._2 == true)
        .map(_._1)
        .sortBy(x => (x.length, x.head))
        .reverse
        .head
    }

    def findAllPossibleStrings(source:String):List[String]={
      (1 to source.size).reverse.map(x => {
        (0 to (source.size - x)).map(y => source.substring(y, x + y))
      }).flatMap(x => x).toList
    }

  }





