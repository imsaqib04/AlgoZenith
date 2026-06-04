package BinarySearch;

import  java.util.*;
public class FamousPainterPartitionProblem {

        static boolean canPaint(long[] boards, int k, long maxTime) {
            int painters = 1;
            long curr = 0;

            for (long board : boards) {
                if (curr + board <= maxTime) {
                    curr += board;
                } else {
                    painters++;
                    curr = board;

                    if (painters > k) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int T = sc.nextInt();

            while (T-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();

                long[] boards = new long[n];

                long low = 0;
                long high = 0;

                for (int i = 0; i < n; i++) {
                    boards[i] = sc.nextLong();
                    low = Math.max(low, boards[i]);
                    high += boards[i];
                }

                long ans = high;

                while (low <= high) {
                    long mid = low + (high - low) / 2;

                    if (canPaint(boards, k, mid)) {
                        ans = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }

                System.out.println(ans);
            }

            sc.close();
        }

}