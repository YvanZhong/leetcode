package bitManipulation;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;

import java.util.Arrays;

public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        System.out.println(n ^= n / 4);
        System.out.println(n-1);
        return ((n ^= n/4) & n-1) == 0;
    }

    public boolean hasAlternatingBits1(int n) {
        System.out.println(n ^= n / 2);
        System.out.println(n+1);
        return ((n ^= n/2) & n+1) == 0;
    }

    public boolean hasAlternatingBits2(int n) {
        return Integer.toBinaryString(n).matches("(10)*1?");
    }

    public static void  main(String... args) {
        System.out.println(new BinaryNumberwithAlternatingBits().hasAlternatingBits1(5));
    }
}
