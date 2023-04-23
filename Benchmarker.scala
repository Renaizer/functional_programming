// This file is meant for comparing the time a code logic takes to complete its execution

object runner extends App {


  def calculateByTailRecursionUpward(n: Int): BigInt = {
    require(n > 0, "n must be positive")

    @tailrec
    def fac(i: Int, acc: BigInt): BigInt = n match {
      case _ if i == n => n * acc
      case _ => fac(i + 1, i * acc)
    }

    fac(1, 1)
  }


  def calculateByRecursion(n: Int): BigInt = {
    require(n > 0, "n must be positive")

    n match {
      case _ if n == 1 => 1
      case _ => n * calculateByRecursion(n - 1)
    }
  }

  def calculateByWhileLoop(n: Int): BigInt = {
    require(n > 0, "n must be positive")

    var accumulator: BigInt = 1
    var i = 1
    while (i <= n) {
      accumulator = i * accumulator
      i += 1
    }
    accumulator
  }

def comparePerformance(n: Int) {
    def showOutput[A](msg: String, data: (Long, A)) = printf("%s in %d ms\n", msg, data._1)


    def measure[A](f: () => A): (Long, A) = {
      val start = System.currentTimeMillis
      val o = f()
      (System.currentTimeMillis - start, o)
    }

    showOutput("tail recursion performances : ", measure(() => calculateByTailRecursionUpward(n)))
    showOutput("recursion performances : ", measure(() => calculateByWhileLoop(n)))
}


  comparePerformance(100000)


}


