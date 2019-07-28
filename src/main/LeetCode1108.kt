package main

class LeetCode1108 {
    class Solution {
        fun defangIPaddr(address: String): String {
            return address.replace(".","[.]")
        }
    }
}
fun main(){
    println(LeetCode1108.Solution().defangIPaddr("1.1.1.1"))
}