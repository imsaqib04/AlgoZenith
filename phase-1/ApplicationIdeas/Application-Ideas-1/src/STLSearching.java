import java.util.*;
public class STLSearching {

        // first index where arr[i] >= x
        static int lower_bound(int[] arr, int x) {
            int l = 0, r = arr.length;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] >= x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        // first index where arr[i] > x
        static int upper_bound(int[] arr, int x) {
            int l = 0, r = arr.length;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] > x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            while (T-- > 0) {
                int n = sc.nextInt();
                int q = sc.nextInt();

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }

                Arrays.sort(arr);
                StringBuilder out = new StringBuilder();

                while (q-- > 0) {
                    int t = sc.nextInt();
                    int x = sc.nextInt();

                    if (t == 1) {
                        int idx = lower_bound(arr, x);
                        out.append(idx < n ? arr[idx] : -1).append(" ");
                    }
                    else if (t == 2) {
                        int idx = upper_bound(arr, x);
                        out.append(idx < n ? arr[idx] : -1).append(" ");
                    }
                    else if (t == 3) {
                        out.append(upper_bound(arr, x)).append(" ");
                    }
                    else if (t == 4) {
                        out.append(lower_bound(arr, x)).append(" ");
                    }
                }

                System.out.println(out.toString());
            }
        }
    }
