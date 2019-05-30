package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode590 {
    public static void main(String... args) {
        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 2;

        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 4;
        Node node5 = new Node();
        node5.val = 5;
        Node node6 = new Node();
        node6.val = 6;

        node1.children = new ArrayList<>();
        node1.children.add(node2);
        node1.children.add(node4);
        node1.children.add(node3);

        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);

        System.out.println(new Solution().postorder(node1));

    }

    // Definition for a Node.
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //    {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
    private static class Solution {
        public List<Integer> postorder(Node root) {
            Stack<Node> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            if (root != null) {
                stack.push(root);
            }
            while (!stack.isEmpty()) {
                Node top = stack.peek();
                if (top.children != null && top.children.size() != 0) {
                    for (int i = top.children.size() - 1; i >= 0; i--) {
                        System.out.println("push" + top.children.get(i).val);
                        stack.push(top.children.get(i));
                    }
                    top.children = null;
                } else {
                    Node temp = stack.pop();
                    System.out.println("pop" + temp.val);
                    result.add(temp.val);
                }
            }
            return result;
        }
    }
}


