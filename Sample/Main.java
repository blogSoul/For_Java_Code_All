import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    private static ArrayList<Integer> queue;
    private static StringBuilder sb;
    public static int check(ArrayList<Integer> queue, int num){
        int count = 0, tmp;
        if(queue.indexOf(num) <= queue.size() / 2){
            tmp = queue.indexOf(num);
            for(int i = 0; i < tmp; i++){
                queue.add(queue.size() - 1, queue.remove(0));
                count++;
            }
        } else {
            tmp = queue.size() - queue.indexOf(num);
            for(int i = 0; i < tmp; i++){
                queue.add(0, queue.remove(queue.size() - 1));
                count++;
            }
            
        }
        if(queue.get(0) == num){
            queue.remove(0);
        }
        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        queue = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        int i = 0, count = 0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        for(i = 1; i <= N; i++){
            queue.add(i);
        }
        for(i = 0; i < arr.length; i++){
            if(queue.get(0) == arr[i]){
                queue.remove(0);
            } else if(queue.indexOf(arr[i]) >= 0){
                count += check(queue, arr[i]);
            } else {
                //error
                return;
            }
        }
        bw.write(Integer.toString(count));
        br.close();
        bw.close();
    }
}