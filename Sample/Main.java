import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    private static int[] arr;
    private static int arr_size;
    private static StringBuilder sb;
    private static final int MAX = 100001;
    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void Add(int num){
        arr_size += 1;
        arr[arr_size] = num;
        int index = arr_size;
        while((index / 2) >= 1 && arr[index] > arr[index / 2]){
            swap(index, index / 2);
            index /= 2;
        }
    }
    public static void deleteFirst(){
        sb.append(arr[1] + "\n");
        arr[1] = arr[arr_size];
        arr[arr_size] = 0;
        arr_size -= 1;
        int index = 1;
        while(2 * index <= arr_size){
            int max, max_index;
            if(2 * index + 1 <= arr_size && arr[2 * index] < arr[2 * index + 1]){
                max = arr[2 * index + 1];
                max_index = 2 * index + 1;   
            } else {
                max = arr[2 * index];
                max_index = 2 * index; 
            }
            if(arr[index] > max){
                break;
            } else {
                swap(index, max_index);
                index = max_index;
            }
        }
    }
    public static void Print(int index){
        System.out.print("Print: "+ index + " " + arr_size + " / ");
        for(int i = 0; i <= arr_size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[MAX];
        arr_size = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(arr_size == 0){
                    sb.append("0\n");
                } else {
                    deleteFirst();
                }
            } else {
                Add(num);
            }
            //Print(i);
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}