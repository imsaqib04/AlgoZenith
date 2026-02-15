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

            long count = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i != j && arr[i] + arr[j] <= x){
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
