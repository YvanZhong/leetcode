package nowcoder.JavaSelection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.lang.Math;
import java.lang.Thread;

public class Selection {

    public static void main1(String[] args) {
        try {
            Class c=Class.forName(args[0]);
            Method m[]=c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Math.cos(42);
        Math.toRadians(42);
        Math.toDegrees(42);
        Math.abs(10);
        StringBuilder sb = new StringBuilder();
        double d = 5.3e12;
        double d2 = 0;
        float f = 1.1f;
        Double oD = 3.0;
    }

}
