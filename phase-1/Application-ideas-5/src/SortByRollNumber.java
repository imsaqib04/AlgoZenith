import java.util.*;

class SortByRollNumber {

    static class Student {

        String name;
        int roll;

        Student(String name, int roll) {
            this.name = name;
            this.roll = roll;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Student[] arr = new Student[n];

            for (int i = 0; i < n; i++) {
                String s = sc.next();
                int r = sc.nextInt();
                arr[i] = new Student(s, r);  // ✅ fixed
            }

            Arrays.sort(arr, (a, b) -> a.roll - b.roll);

            for (int i = 0; i < n; i++) {
                System.out.println(arr[i].name + " " + arr[i].roll);
            }
        }
    }
}
