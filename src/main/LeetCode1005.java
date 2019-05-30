package main;

public class LeetCode1005 {
    public static void main(String... args) {
        int[] a = {3,-1,0,2};
        System.out.println(new Solution().largestSumAfterKNegations(a,3));
    }
    private static class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            for (int i = 0; i < K; i++) {
                int minLoc = min(A);
                A[minLoc] = -A[minLoc];
            }
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
            }
            return sum;
        }

        private int min(int[] A) {
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[result] > A[i]) {
                    result = i;
                }
            }
            return result;
        }
    }
}


