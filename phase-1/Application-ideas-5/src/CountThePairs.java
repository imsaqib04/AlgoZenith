//import java.util.*;
//
//class CountThePairs {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//
//        while(T-- > 0){
//            int n = sc.nextInt();
//            int x = sc.nextInt();
//
//            int[] arr = new int[n];
//            for(int i = 0; i < n; i++){
//                arr[i] = sc.nextInt();
//            }
//
//            long count = 0;
//
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    if(i != j && arr[i] + arr[j] <= x){
//                        count++;
//                    }
//                }
//            }
//
//            System.out.println(count);
//        }
//    }
//}
import java.util.*;

class CountThePairs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;
            long count = 0;

            while(left < right){
                if(arr[left] + arr[right] <= x){
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }
            }

            System.out.println(2L * count);
        }
    }
}
