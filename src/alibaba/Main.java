package alibaba;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static char[] units = new char[]{'零','一','二','三','四','五','六','七','八','九'};


/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String tansform(long number) {
        if (number == 0) return "零";
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while(number > 0) {
            long tmp = number % 10000;
            String str = helper((int)tmp, index++);
            System.out.println(str);
            sb.insert(0, str);
            if(String.valueOf(tmp).length() < 4 && number/10000 > 0){
                sb.insert(0, "零");
            }
            if (str.length() != 0) sb.insert(0,',');
            number /= 10000;

        }

        sb.deleteCharAt(0);
        return sb.toString();
    }

    static String getUnit(int i) {
        if (i == 1) {
            return "";
        } else if (i == 2) {
            return "十";
        } else if (i == 3) {
            return "百";
        } else {
            return "千";
        }
    }

    static String helper(int number, int index) {
        StringBuilder sb = new StringBuilder();

        int i = 1;
        while (number > 0) {
            int tmp = (int)(number % 10);
            if (sb.length() == 0 && tmp == 0) {
                number /= 10;
                i++;
                continue;
            }
            sb.append(getUnit(i));
            if (!(tmp == 1 && i == 2)) sb.append(units[tmp]);
            number /= 10;
            i++;
        }

        switch (index) {
            case 1:
                break;
            case 2:
                sb.insert(0,"万");
                break;
            case 3:
                sb.insert(0, "亿");
                break;
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        long _number;
        _number = Long.parseLong(in.nextLine().trim());

        res = tansform(_number);
//        int count = 0;
//        for(int i = 0 ; i < res.length() ;i++){
//            if(count == 8){
//                if(res.charAt(i) )
//            }
//            if(res.charAt(i) != ','){
//                count++;
//            }
//            if(count)
//        }
        System.out.println(res);
    }
}
