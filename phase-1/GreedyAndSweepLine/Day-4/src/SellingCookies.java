// TC: O(NlogN)
import java.util.*;
public class SellingCookies {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            // Max Heap (acts like stack of biggest elements)
            PriorityQueue<Long> pq =
                    new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                pq.add(sc.nextLong());
            }

            // Pair cookies
            while (pq.size() >= 2) {
                long a = pq.poll(); // largest
                long b = pq.poll(); // second largest

                a--;
                b--;

                if (a > 0) pq.add(a);
                if (b > 0) pq.add(b);
            }

            long remaining = 0;
            while (!pq.isEmpty()) {
                remaining += pq.poll();
            }

            System.out.println(remaining);
        }

        sc.close();
    }
}

// optimized TC: O(n)
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();
//
//        while (T-- > 0) {
//            int n = sc.nextInt();
//
//            long total = 0;
//            long max = 0;
//
//            for (int i = 0; i < n; i++) {
//                long x = sc.nextLong();
//                total += x;
//                if (x > max) max = x;
//            }
//
//            long rest = total - max;
//            long remaining;
//
//            if (max > rest) {
//                remaining = max - rest;
//            } else {
//                remaining = total % 2;
//            }
//
//            System.out.println(remaining);
//        }
//
//        sc.close();
//    }
//}