//Scenario : find the Mamimum salary per department using plain scala collection 

case class employee(name:String, Dept:String, Salary:Int)


val empSeq:Seq[employee] = Seq(employee("H","A",1000), employee("J","A",2000),employee("S","B",3000), employee("T","B",4000))


val distinctDept = empSeq.map(_.Dept).distinct.par

val listOfEmpWithHighestSlaryDeptWise:List[(String, employee)] = distinctDept.map(dept => (dept,empSeq.filter(_.Dept == dept).sortWith((s, t) => s.Salary > t.Salary).head)).toList

//Now, what will you do to improve the performance system if 
//1. The data is coming from the very large file from the placed on storage (We cannot read an entire file in memory)
//2. We are limited with single node system ( No cluster computing )
//3. Only the system is upscaled ( RAM / CORE increased )


// There are couple of the solution provided
// refer : https://www.jayconrod.com/posts/27/processing-large-files-in-scala
// way 1 : Increase the maximum heap size. 
// way 2 : Use memory mapped I/O
// way 3 : Use streams instead of lists or arrays
// way 4 : Double-check your code for slow areas ( prefer the performance over simplicity and readability )
