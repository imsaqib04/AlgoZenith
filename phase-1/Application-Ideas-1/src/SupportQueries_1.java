import java.util.*;
public class SupportQueries_1 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int Q = sc.nextInt();

            TreeMap<Long,Long> tm = new TreeMap<>();
            long sum = 0;

            while(Q-->0){

                int type = sc.nextInt();

                if(type==1){
                    long x = sc.nextLong();
                    tm.put(x,tm.getOrDefault(x , 0L) +1);
                    sum = sum + x;
                }
                else if(type == 2){
                    long x = sc.nextLong();

                    if(tm.containsKey(x)){
                        if(tm.get(x)==1){
                            tm.remove(x);
                        }
                        else{
                            tm.put(x,tm.get(x)-1);
                        }
                        sum = sum -x;
                    }
                }
                else if(type==3){
                    sc.next();
                    System.out.println(tm.isEmpty() ? -1 : tm.firstKey());
                }

                else if(type==4){
                    sc.next();
                    System.out.println(tm.isEmpty() ? -1 : tm.lastKey());
                }

                else if(type==5){
                    sc.next();
                    System.out.println(sum);
                }
            }
        }
    }