import java.util.Scanner;

public class Sample {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] arr = new int[n][m];
        int i, j;
        for(i = 0 ; i < n; i++){
            str = scan.nextLine().split(" ");
            for(j = 0 ; j < m; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        /*
        for(i = 0 ; i < n; i++){
            for(j = 0 ; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
        */
        for(i = 1 ; i < n; i++){
            arr[i][0] += arr[i - 1][0];
        }
        for(i = 1 ; i < m; i++){
            arr[0][i] += arr[0][i - 1];
        }
        for(i = 1 ; i < n; i++){
            for(j = 1 ; j < m; j++){
                arr[i][j] += Math.max(arr[i][j - 1], Math.max(arr[i - 1][j - 1], arr[i - 1][j]));
            }
        }
        System.out.println(arr[n - 1][m - 1]);
    }
}
/*
print : 괄호안 내용을 단순히 출력. 개행문자(=줄바꿈문자=\n) 포함안됨.
printf : C에서의 printf와 동일. %d, %s 등을 쓰기위해 사용. 개행문자 포함X
println : 괄호안 내용을 출력한 후 마지막에 개행문자가 포함되어 있어 출력후 한 줄 띄워짐.
*/
