package aiqiyi;

import java.util.Scanner;

public class Main1 {

//    s = input()
//    length = len(s)
//    m = 0
//    i = length-1
//    j = 0
//    res = ""
//            while i>=0:
//    x = s[i]
//            if ord(x)>=m:
//    res=x+res
//            m = ord(x)
//    i-=1
//    print(res)

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s.length() == 0){
            System.out.println(s);
        }
        else{
            int max = -1;
            int maxNum = 0;
            int index = -1;
            char[] c = s.toCharArray();
            for(int i = 0;i < c.length;i++){
                int t = c[i] - 'a';
                if(t > max){
                    max = t;
                    maxNum = 1;
                    index = i;
                }else if(t == max){
                    maxNum ++;
                    index =i;
                }
                else{}
            }
            char cc = (char)('a'+max);
            StringBuilder ss = new StringBuilder();
            for(int i = 1;i<maxNum;i++){
                ss.append(cc);
            }
            ss.append(s.substring(index));
            System.out.println(ss.toString());
            System.out.println(bruce(s));
        }


    }

    private static String bruce(String str) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < str.length()) {
            char ch = str.charAt(index);
            for (int i = index; i < str.length(); i++) {
                if (str.charAt(i) > ch) {
                    ch = str.charAt(i);
                    index = i;
                }
            }
            sb.append(ch);
            index++;
        }
        return sb.toString();
    }




}
