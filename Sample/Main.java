import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int[] arr; 
    public static int N;
    public static long[] arr1;
    public static void dp(int num){
        if(num >= 1){
            arr1[1] = arr[1];
        }
        if(num >= 2){
            arr1[2] = arr[1] + arr[2];
        }
        if(num >= 3){
            arr1[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);arr1[2] = arr[1] + arr[2];
        }
        if(num >= 4){
            for(int i = 4 ; i <= N; i++){
                arr1[i] = Math.max(arr1[i - 3] + arr[i - 1] + arr[i], arr1[i - 2] + arr[i]);
            }    
        }
        System.out.println(arr1[N]);
    } 
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        arr1 = new long[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        dp(N);
    }
}
