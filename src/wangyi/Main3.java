import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count =0;

        int[] num = new int[2];

        for(int i = 0; i < 2; i++){
            num[i] = sc.nextInt();
        }

        for(int i=num[1];i<=num[0];i++){
            count+=num[0]-i;
            for(int j=i-1;j>=2;j--){
                if(i % j >=num[1] && i > j){
                    System.out.println(i+"%"+j+"="+i%j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}