import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    private static int size;
    private static final int MAX = 1000;
    public static long[][] multiply(long[][] a, long[][] b, int M){
        long[][] ans = new long[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    ans[i][j] += a[i][k] * b[k][j];
                }
                ans[i][j] %= MAX;
            }    
        }
        return ans;
    }
    public static long[][] check(long[][] arr, long N, int M){
        if(N == 1){
            return arr;    
        }
        long[][] ans = new long[size][size]; 
        long[][] temp = new long[size][size];
        temp = check(arr, N / 2, MAX);
        if(N % 2 == 0){
            ans = multiply(temp, temp, MAX);
        } else {
            ans = multiply(multiply(temp, temp, MAX), arr, MAX);
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[][] arr = new long[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        size = arr.length;
        long[][] ans = new long[N][N];
        ans = check(arr, M, MAX);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(ans[i][j] % 1000 + " ");
            }
            sb.append("\n");    
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}