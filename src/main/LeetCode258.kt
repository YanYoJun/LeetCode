package main

class LeetCode258 {
    class Solution {
        fun addDigits(num: Int): Int {
            var tempNum = num
            if(tempNum < 10){
                return tempNum
            }
            var target = 0
            while(tempNum > 0){
                target += tempNum %10
                tempNum /= 10
            }
            return addDigits(target)
        }
    }
}
fun main(){
    print(LeetCode258.Solution().addDigits(38))
}