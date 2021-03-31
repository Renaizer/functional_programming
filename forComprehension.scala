import scala.util.{Try,Success,Failure}

object testObject extends App {
    def aFunction(s: Int) : Try[Int] = Try {
        s/(s % 2)
    }

    val result = for {
        a <- aFunction(1)
        b <- aFunction(3)
        c <- aFunction(5)
    } yield a + b + c


    result match {
        case Success(i) => println(s"Successfull Results : ${i}")
        case Failure(e) => println(s"Exception Occured : ${e.getMessage}")
    }

}
