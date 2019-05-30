package main;

import java.util.*;

public class LeetCode429 {
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

    private static class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            Queue<Node> curLevel = new LinkedList<>();
            Queue<Node> nextLevel = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            curLevel.offer(root);
            while(!curLevel.isEmpty()){
                List<Integer> curLevelList = new ArrayList<>();
                while(!curLevel.isEmpty()) {
                    Node temp = curLevel.poll();
                    curLevelList.add(temp.val);
                    if(temp.children != null && temp.children.size() != 0){
                        for(Node tmp:temp.children){
                            nextLevel.offer(tmp);
                        }
                    }
                }
                result.add(curLevelList);
                curLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
            return result;
        }
    }
}


