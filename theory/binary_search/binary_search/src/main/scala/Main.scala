import scala.annotation.tailrec
@main def main: Unit = {
  val numbers: Array[Int]        = Array(1, 14, 20, 32, 33, 45, 76, 77, 85, 97)
  val indexOfTwenty: Option[Int] = binarySearch(numbers, 20)
  println(s"the index of twenty is: ${indexOfTwenty.getOrElse("Not found")}")
  // 2
  val indexOfSix: Option[Int] = binarySearch(numbers, 6)
  println(s"the index of six is: ${indexOfSix.getOrElse("Not found")}")
  // "Not found"
}

// courtesy: https://www.24tutorials.com/scala/binary-search-in-scala-iterative-tail-recursion/
def binarySearch(numbers: Array[Int], num: Int): Option[Int] = {
  @tailrec
  def loop(numbers: Array[Int], target: Int, low: Int, high: Int): Option[Int] = {
    if high < low then return None
    val mid = (low + high) / 2
    numbers(mid) match {
      case n if n == target => Some(mid)
      case n if n > target =>
        loop(numbers, target, low, mid - 1)
      case _ => loop(numbers, target, mid + 1, high)
    }
  }
  loop(numbers, num, 0, numbers.length - 1)
}
