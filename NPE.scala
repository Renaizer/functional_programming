//Handle Null Pointer Exception in scala

import scala.util.Try

val value = null 

Try(value.toString).toOption.getOrElse("")
