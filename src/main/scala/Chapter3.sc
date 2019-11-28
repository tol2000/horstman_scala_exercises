import scala.collection.mutable.ArrayBuffer

//1
val n = 3
val a = ArrayBuffer[Int]()
for (i <- 0 until n) a.addOne(i)
a

//2
var tmp = 0
for (i <- 0 until a.length if i % 2 != 0) {
  tmp = a(i-1)
  a(i-1) = a(i)
  a(i) = tmp
}
a

//3
val b = for (i <- 0 until a.length) yield {
  if (i % 2 == 0) {
    if (i != a.length-1) a(i+1) else a(i)
  } else {
    a(i-1)
  }
}

//4
val a4 = Array[Int](1,-3,0,5,-7,0,9,2,4,-6)
val b4i = for (i <- 0 to 2) yield new ArrayBuffer[Int]()
for (i<-a4.indices) {
  if (a4(i) > 0) b4i(0).addOne(i)
  else if (a4(i) < 0) b4i(1).addOne(i)
  else b4i(2).addOne(i)
}
val b4 = for (i <- 0 until b4i.length; j <- 0 until b4i(i).length) yield a4(b4i(i)(j))

