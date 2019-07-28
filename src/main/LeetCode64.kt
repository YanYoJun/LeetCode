package main

class LeetCode64 {
    class Solution {
        lateinit var value: Array<IntArray>
        fun minPathSum(grid: Array<IntArray>): Int {
            value = Array<IntArray>(grid.size) {
                IntArray(grid[it].size) {
                    -1
                }
            }
            return min(0, 0, grid)
        }

        private fun min(x: Int, y: Int, grid: Array<IntArray>): Int {
            println("min:$x $y")
            if (x < grid.size - 1 && value[x + 1][y] == -1) {
                value[x + 1][y] = min(x + 1, y, grid)
            }
            if (y < grid[0].size - 1 && value[x][y + 1] == -1) {
                value[x][y + 1] = min(x, y + 1, grid)
            }
            if (x == grid.size - 1 && y == grid[0].size - 1) {
                value[x][y] = grid[x][y]
            }
            if (x < grid.size - 1 && y < grid[0].size - 1) {
                println("yanyojun $x $y ${value[x+1][y]} ${value[x][y+1]}")
                value[x][y] = kotlin.math.min(value[x + 1][y], value[x][y + 1]) + grid[x][y]
            } else if (x < grid.size - 1) {
                value[x][y] = value[x + 1][y] + grid[x][y]
            } else if (y < grid[0].size - 1) {
                value[x][y] = value[x][y + 1] + grid[x][y]
            } else {
                value[x][y] = grid[x][y]
            }
            println("return x:$x y:$y ${value[x][y]}")
            return value[x][y]
        }
    }
}

fun main() {
    println(LeetCode64.Solution().minPathSum(
            arrayOf(arrayOf(1, 3, 1).toIntArray(),
                    arrayOf(1, 5, 1).toIntArray(),
                    arrayOf(4, 2, 1).toIntArray()))
    )
}