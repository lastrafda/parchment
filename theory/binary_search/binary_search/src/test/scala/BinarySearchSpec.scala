import org.scalatest.flatspec.AnyFlatSpec
class BinarySearchSpec extends AnyFlatSpec {
  it should "return Some(index) if the target is found" in {
    assert(binarySearch(Array(1, 2, 3), 3) == Some(2))
  }

  it should "return None if the target is not found" in {
    assert(binarySearch(Array(1, 2, 3), 4) == None)
  }
}
