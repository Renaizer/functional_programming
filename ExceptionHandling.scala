import scala.util.{Try, Success, Failure}
 
def converttoIntegerDefault(value:String) : Int = {
 
  val resultls = value.toInt
  
  resultls
}
 
 
 
//APPROACH 1
 
def converttoInteger(value:String) : Int = {
 
  val resultls = Try(value.toInt).toOption.getOrElse(0)
  
  resultls
}
 
 
//APPROACH 2
def converttoInteger2(value:String) : Try[Int] = {
  import scala.util.Try
  
  val resultls = Try(value.toInt)
  
  resultls
}
 
 
//APPROACH 3
def converttoInteger3(value:String) : Option[Int] = {
  import scala.util.Try
  
  val resultls = Try(value.toInt).toOption
  
  resultls
}
 
 
 
val result3 = converttoInteger2("1234") match {
  case Success(s) => s
  case Failure(f) => 
}
 
val result3 = converttoInteger3("1234") match {
  case Some(t) => t
  case None    => 
}
 
 
 
 
println(s"result3 => ${result3}")
// println(s"result4 => ${result4}")
 
 
// result3 => 1234
// import scala.util.{Try, Success, Failure}
// converttoInteger: (value: String)Int
// converttoInteger2: (value: String)scala.util.Try[Int]
// converttoInteger3: (value: String)Option[Int]
// result3: AnyVal = 1234
