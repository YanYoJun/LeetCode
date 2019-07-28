package main

class LeetCode2 {
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    class Solution {
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var tempL1 = l1
            var tempL2 = l2
            var temp = 0
            var root: ListNode? = ListNode(0)
            var curNode = root
            do {
                curNode?.next = ListNode(0)
                curNode = curNode?.next
                var num = (tempL1?.`val` ?: 0) + (tempL2?.`val` ?: 0) + temp
                curNode?.`val` = num % 10
                temp = num / 10
                tempL1 = tempL1?.next
                tempL2 = tempL2?.next
            } while (temp > 0 || tempL1 != null || tempL2 != null)
            return root?.next
        }
    }
}