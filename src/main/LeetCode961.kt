package main

class LeetCode961 {
    class Solution {
        fun repeatedNTimes(A: IntArray): Int {
            val n = A.size/2
            return A.find { A.count { tempIt -> tempIt == it } == n }?:-1
        }
    }
}
fun main(){
    println(LeetCode961.Solution().repeatedNTimes(arrayOf(2,1,2,5,3,2).toIntArray()))
}