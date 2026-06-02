package BinarySearch;

import java.util.*;

public class BitonicArray {

    static int[] arr;
    static int x;

    // Binary search on increasing array
    static int searchIncreasing(int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) return mid;

            if (arr[mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // Binary search on decreasing array
    static int searchDecreasing(int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) return mid;

            if (arr[mid] < x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    // Find peak element
    static int findPeak(int n) {
        int lo = 0, hi = n - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < arr[mid + 1])
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int q = sc.nextInt();

            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int peak = findPeak(n);

            while (q-- > 0) {

                x = sc.nextInt();

                int left = searchIncreasing(0, peak);
                int right = searchDecreasing(peak + 1, n - 1);

                if (left != -1 && right != -1) {
                    System.out.println((left + 1) + " " + (right + 1));
                } else if (left != -1) {
                    System.out.println(left + 1);
                } else {
                    System.out.println(right + 1);
                }
            }
        }

        sc.close();
    }
}