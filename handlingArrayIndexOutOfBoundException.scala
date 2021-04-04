//This code snippet demonstrate how to handle ArrayindexOutOfBound Exception in Scala way


val mySeq = Seq(1,2,3)

mySeq(0)
// return 1

mySeq(10)
//Throws ArrayIndexOutOfBound Exception

//To handle this excpetion use lift function as 

val mySeqOtion = mySeq.lift

// mySeqOption is a function with datatype as Int => Option[Int]
// Hence invoking a index on mySequence would give Some(<Some Value>) OR None

mySeqOption(0) 
// Return Some(1)

mySeqOption(10)
//Return None


//To extract the actual values


mySeqOption(0).getOrElse(0)
//Returns 1

mySeqOption(10).getOrElse(0)
//Returns 0

