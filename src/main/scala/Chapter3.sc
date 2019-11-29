import scala.collection.mutable.ArrayBuffer

//1
val n = 3
val a = ArrayBuffer[Int]()
for (i <- 0 until n) a.addOne(i)
a


//************************** 2
var tmp = 0
for (i <- 0 until a.length if i % 2 != 0) {
  tmp = a(i-1)
  a(i-1) = a(i)
  a(i) = tmp
}
a


//************************** 3
val b = for (i <- 0 until a.length) yield {
  if (i % 2 == 0) {
    if (i != a.length-1) a(i+1) else a(i)
  } else {
    a(i-1)
  }
}


//************************** 4
val a4 = Array[Int](1,-3,0,5,-7,0,9,2,4,-6)
val b4i = for (i <- 0 to 2) yield new ArrayBuffer[Int]()
for (i<-a4.indices) {
  if (a4(i) > 0) b4i(0).addOne(i)
  else if (a4(i) < 0) b4i(1).addOne(i)
  else b4i(2).addOne(i)
}
val b4 = for (i <- 0 until b4i.length; j <- 0 until b4i(i).length) yield a4(b4i(i)(j))


//************************** 5
val a5 = Array[Double](1,2,3,4,5,6,7,8,9)
a5.sum/a5.length


//************************** 6
// wrong: order must be descending
val a6 = Array[Int](6,1,4,7,2,9,8,5,3)
def s6fnc(s6_1:Int, s6_2:Int) = s6_1 > s6_2
val s6 = a6.sortWith(s6fnc)
for (i<-0 until a6.length) a6(i)=s6(i)
print("a6: "+a6.mkString(","))

// bubble sort fore a change :) (but may be also just sorted method)
val ab6 = ArrayBuffer[Int](6,1,4,7,2,9,8,5,3)
var changed = true
var passes = 0
if (ab6.length>1) {
  while (changed) {
    changed = false
    for (i <- 1 until ab6.length) {
      if (ab6(i) > ab6(i - 1)) {
        val tmp = ab6(i);
        ab6(i) = ab6(i - 1);
        ab6(i - 1) = tmp
        changed = true
      }
    }
    passes += 1
  }
}
print("ab6: "+ab6.mkString(","))
print("passes: "+passes)


//************************** 7
