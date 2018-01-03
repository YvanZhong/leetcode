package nowcoder.offer;

/**
 * Created by Zhong on 2018/1/3.
 */
public class TestBit {

    public static void main1(String... args) {
        long i = 0;
        char c = '9';
        int rst = 0;
        long timestamp = System.nanoTime();
        while (i < 10000000000L) {
            rst = c * 10;//c - '0';


            i++;
        }
        System.out.println(rst + " " + i + " " + (System.nanoTime() - timestamp));

        i = 0;
        timestamp = System.nanoTime();
        while (i < 10000000000L) {
            rst = (c << 1) + (c << 3);//c & 0xf;

            i++;
        }
        System.out.println(rst + " " + i + " " + (System.nanoTime() - timestamp));

    }

    public static void main(String[] args){
        int j = 10;
        long start = System.currentTimeMillis();
        /*for (int i=0;i<10000000;i++){
            if(i % 2 == 0) {
                for(int k=0;k<10;k++){
                    j = j*2;
                }
            } else {
                for(int k=0;k<10;k++){
                    j = j/2;
                }
            }
        }*/

        for (int i=0;i<10000000;i++){
            if(i % 2 == 0) {
                for(int k=0;k<10;k++){
                    j = j<<1;
                }
            } else {
                for(int k=0;k<10;k++){
                    j = j>>1;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("j="+j+"乘除运算花费时间：" + (end - start) + "ms");

        j = 10;
        start = System.currentTimeMillis();

        for (int i=0;i<10000000;i++){
            if(i % 2 == 0) {
                for(int k=0;k<10;k++){
                    j = j*2;
                }
            } else {
                for(int k=0;k<10;k++){
                    j = j/2;
                }
            }
        }

        /*for (int i=0;i<10000000;i++){
            if(i % 2 == 0) {
                for(int k=0;k<10;k++){
                    j = j<<1;
                }
            } else {
                for(int k=0;k<10;k++){
                    j = j>>1;
                }
            }
        }*/
        end = System.currentTimeMillis();
        System.out.println("j="+j+"位运算花费时间：" + (end - start) + "ms");
    }

}
