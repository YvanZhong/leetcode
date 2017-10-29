object IntersectionofTwoArraysScala {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val set1 = nums1.toSet
    nums2.filter(set1.contains(_)).distinct
  }
}