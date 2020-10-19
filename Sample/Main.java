import java.util.Scanner;

public class Main {
    public static long check2(long num){
        long cnt = 0;
        if(num == 0)
            return 0;
        while(num > 0) {
            cnt += num / 2;
            num = num / 2;
        }
        return cnt;
    }
    public static long check5(long num){
        long cnt = 0;
        if(num == 0)
            return 0;
        while(num > 0) {
            cnt += num / 5;
            num = num / 5;
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        long sum_2 = 0, sum_5 = 0; 
        long N = Long.parseLong(sc.next());
        long M = Long.parseLong(sc.next());
        sc.close();
        sum_2 = check2(N) - check2(N - M) - check2(M);
        sum_5 = check5(N) - check5(N - M) - check5(M);
        if(sum_2 > sum_5){
            System.out.println(sum_5);
        } else {
            System.out.println(sum_2);
        }
    }
} 
