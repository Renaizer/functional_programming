def mapReduce(f: Int => Int, combiner:(Int, Int)=>Int, base:Int)(a:Int, b:Int):Int={
  def recur(a:Int):Int={
    if(a>b) base
    else combiner(f(a), recur(a+1))
  }
  recur(a)
}

def sum(f:Int => Int): (Int, Int) => Int = mapReduce(f, (x, y) => x+y, 0) _
def product(f:Int => Int): (Int, Int) => Int = mapReduce(f, (x, y) => x*y, 1) _


def id: Int => Int = (x: Int) => x
def square: Int => Int = (x: Int) => x * x

def sumInt: (Int, Int) => Int =sum(id)
def sumSquare: (Int, Int) => Int =sum(square)

def productInt: (Int, Int) => Int =product(id)
def productSquare: (Int, Int) => Int =product(square)


println(sumInt(1,5))
println(sumSquare(1,5))
println(productInt(1,5))
println(productSquare(1,5))   
