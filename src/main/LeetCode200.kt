package main

fun main(vararg str: String) {
    val row1 = charArrayOf('1', '1', '1', '1', '0')
    val row2 = charArrayOf('1', '1', '0', '1', '0')
    val row3 = charArrayOf('1', '1', '0', '0', '0')
    val row4 = charArrayOf('0', '0', '0', '0', '0')
    print(Solution().numIslands(arrayOf(row1, row2, row3, row4)))
}

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.size == 0) {
            return 0
        }
        val rowCount = grid.size
        val colCount = grid[0].size
        var result = 0
        for (i in 0..rowCount - 1) {
            for (j in 0..colCount - 1) {
                if (grid[i][j] != '1') {
                    continue
                }
                println("begin $i $j\n")
                result++
                //通过广度优先将所有的数字都反转成0
                var queue = mutableListOf<Pair<Int, Int>>()
                queue.add(Pair(i, j))
                while (!queue.isEmpty()) {
                    val tmp = queue.removeAt(0)
                    println("cur value :${tmp.first} ${tmp.second} ${grid[tmp.first][tmp.second]}")
                    if (grid[tmp.first][tmp.second] == '1') {
                        print("pop ${tmp.first} ${tmp.second}\n")
                        grid[tmp.first][tmp.second] = '0'
                        if (tmp.first > 0 && grid[tmp.first - 1][tmp.second] == '1') {
                            print("time 1\n")
                            queue.add(Pair(tmp.first - 1, tmp.second))
                        }
                        if (tmp.second > 0 && grid[tmp.first][tmp.second - 1] == '1') {
                            print("time 2\n")
                            queue.add(Pair(tmp.first, tmp.second - 1))
                        }
                        if (tmp.first < rowCount - 1 && grid[tmp.first + 1][tmp.second] == '1') {
                            print("time 3\n")
                            queue.add(Pair(tmp.first + 1, tmp.second))
                        }
                        if (tmp.second < colCount - 1 && grid[tmp.first][tmp.second + 1] == '1') {
                            print("time 4\n")
                            queue.add(Pair(tmp.first, tmp.second + 1))
                        }
                    }
                }
            }
        }
        return result
    }
}