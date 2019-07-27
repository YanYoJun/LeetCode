package main

class LeetCode135 {
    class Solution {
        fun candy(ratings: IntArray): Int {
            if (ratings.isEmpty()) {
                return 0
            } else if (ratings.size == 1) {
                return 1
            } else if (ratings.size == 2) {
                return if (ratings[0] == ratings[1]) 2 else 3
            }
            val arrCount = IntArray(ratings.size)
            for (i in 1 until ratings.size - 1) {
                if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                    arrCount[i] = 1
                }
            }
            if (ratings[0] <= ratings[1]) {
                arrCount[0] = 1
            }
            if (ratings[ratings.size - 1] <= ratings[ratings.size - 2]) {
                arrCount[ratings.size - 1] = 1
            }
            for (i in 1 until ratings.size) {
                if (arrCount[i] == 0 && arrCount[i - 1] != 0 && ratings[i] > ratings[i - 1]) {
                    arrCount[i] = arrCount[i - 1] +  1
                }
            }
            for (i in ratings.size - 2 downTo 0) {
                println("i:$i")
                if ((arrCount[i] == 0 || arrCount[i+1] + 1 > arrCount[i]) && arrCount[i + 1] != 0 && ratings[i] > ratings[i + 1]) {
                    arrCount[i] = arrCount[i + 1] +  1
                }
            }
            println(arrCount.joinToString(","))
            return arrCount.sum()
        }
    }
}

fun main(vararg str: String) {
    println(LeetCode135.Solution().candy(arrayOf(1,6,10,8,7,3,2).toIntArray()))
}
