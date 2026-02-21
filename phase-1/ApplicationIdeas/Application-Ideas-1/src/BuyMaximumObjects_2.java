import java.util.*;

// optimized
public class BuyMaximumObjects_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );

        int N = sc.nextInt ();
        int Q = sc.nextInt ();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt ();
        }

        // Step 1: sort
        Arrays.sort ( arr );

        // Step 2: prefix sum
        long[] prefix = new long[N];
        prefix[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // Step 3: queries
        while (Q-- > 0) {
            long M = sc.nextLong ();

            int left = 0, right = N - 1;
            int ans = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] <= M) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println ( ans + 1 );
        }
    }
}

// brute force
// class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int N = sc.nextInt();
//         int Q = sc.nextInt();

//         int[] arr = new int[N];
//         for (int i = 0; i < N; i++) {
//             arr[i] = sc.nextInt();
//         }

//         while (Q-- > 0) {
//             int M = sc.nextInt();

//             // copy array (brute force)
//             int[] temp = Arrays.copyOf(arr, N);
//             Arrays.sort(temp);

//             int count = 0;
//             int sum = 0;

//             for (int i = 0; i < N; i++) {
//                 if (sum + temp[i] <= M) {
//                     sum += temp[i];
//                     count++;
//                 } else {
//                     break;
//                 }
//             }

//             System.out.println(count);
//         }
//     }
// }
