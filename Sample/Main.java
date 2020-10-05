import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static int[] arr1;
    public static int Max = Integer.MIN_VALUE;
    public static void dp(int N){
        if(N >= 1) {
            arr1[1] = arr[1];
        }
        if(N >= 2) {
            arr1[2] = Math.max(arr1[1] + arr[2], arr[2]);
        }
        if(N >= 3) {
            arr1[3] = Math.max(arr1[2], Math.max(arr[1], arr[2]) + arr[3]);
        }
        if(N >= 4) {
            for(int i = 4; i <= N; i++){
                arr1[i] = Math.max(arr1[i - 1], Math.max(arr1[i - 2], arr[i - 1] + arr1[i - 3]) + arr[i]);
            }
        }
        for(int i = 1; i <= N; i++){
            Max = Math.max(arr1[i], Max);
        }
        System.out.println(Max);
    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N + 1];
        arr1 = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        dp(N);
    }
}
