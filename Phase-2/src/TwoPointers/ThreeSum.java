package TwoPointers;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            long target = sc.nextLong();

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            Arrays.sort(arr);

            long ans = Long.MAX_VALUE;

            for (int i = 0; i < n - 2; i++) {
                int l = i + 1;
                int r = n - 1;

                while (l < r) {
                    long sum = arr[i] + arr[l] + arr[r];
                    long diff = Math.abs(sum - target);

                    ans = Math.min(ans, diff);

                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        ans = 0;
                        break;
                    }
                }

                if (ans == 0) break;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}