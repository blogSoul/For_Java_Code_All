import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    private static Queue<Integer> queue;
    private static StringBuilder sb;
    public static void push(int num){
        queue.add(num);
    }
    public static void pop(){
        if(queue.isEmpty()){
            sb.append("-1\n");
            return;
        }
        sb.append(Integer.toString(queue.remove()) + "\n");
    }
    public static void size(){
        sb.append(Integer.toString(queue.size()) + "\n");
    }
    public static void empty(){
        if(queue.isEmpty()){
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }
    public static void front(){
        if(queue.isEmpty()){
            sb.append("-1\n");
            return;
        }
        sb.append(Integer.toString(queue.peek()) + "\n");
    }
    public static void back(){
        if(queue.isEmpty()){
            sb.append("-1\n");
            return;
        }
        int current = 0;
        for(Iterator<Integer> iterator = queue.iterator(); iterator.hasNext();){
            current = iterator.next();
        }
        sb.append(Integer.toString(current) + "\n");
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        queue = new LinkedList<Integer>();
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            if(st.countTokens() == 1){
                String order = st.nextToken();
                if(order.compareTo("front") == 0){
                    front();
                } else if(order.compareTo("back") == 0){
                    back();
                } else if(order.compareTo("empty") == 0){
                    empty();
                } else if(order.compareTo("pop") == 0){
                    pop();
                } else if(order.compareTo("size") == 0){
                    size();
                }
                //sb.append("D:" + order + " " + "\n");
            } else if (st.countTokens() == 2) { 
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(order.compareTo("push") == 0){
                    push(num);
                }
                //sb.append("D:" + order + " " + num + "\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}