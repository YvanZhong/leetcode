package dynamicProgramming;
import java.util.*;
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size() - 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                }
            }
        }

        int min = triangle.get(row).get(0);
        for (int j = 1; j < triangle.get(row).size(); j++) {
            min = Math.min(min, triangle.get(row).get(j));
        }
        return min;
    }



}
