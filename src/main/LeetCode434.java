package main;

public class LeetCode434 {
    public static void main(String... args) {
        System.out.println(new Solution().countSegments("Hello, my name is John"));
    }
    private static class Solution {
        public int countSegments(String s) {
            if (s == null) {
                return 0;
            }
            s = s.trim();
            if(s.length() == 0){
                return 0;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ' && s.charAt(i-1) != ' ') {
                    count++;
                }
            }
            return count + 1;
        }
    }
}

