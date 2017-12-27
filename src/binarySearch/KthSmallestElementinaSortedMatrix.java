package binarySearch;

public class KthSmallestElementinaSortedMatrix {
    //wrong answer
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];
        if (k == matrix.length * matrix.length) return matrix[matrix.length - 1][matrix.length - 1];

        int x1 = 0, y1 = 1, x2 = 1, y2 = 0;

        int i = 1;

        while (i < k - 1) {
            System.out.println("i: "+ i + " x1: " + x1 + " y1: " + y1 + " x2: " + x2 + " y2: " + y2);
            if (matrix[x1][y1] < matrix[x2][y2]) {
                if (y1 < matrix.length - 1) {
                    y1++;
                } else {
                    if (y2 < matrix.length - 1){
                        x1++;
                        y1 = y2+1;
                    } else {
                        return matrix[x2 + k - i - 2][y2];
                    }
                }
            } else {
                if (x2 < matrix.length - 1) {
                    x2++;
                } else {
                    if (x1 < matrix.length - 1){
                        x2 = x1 + 1;
                        y2++;
                    } else {
                        return matrix[x1][y1 + k - i - 2];
                    }

                }

            }
            i++;
        }

        return matrix[x1][y1] < matrix[x2][y2]? matrix[x1][y1] : matrix[x2][y2];


    }

    public static void main(String... args) {
        int[][] param = {
                {1,3,5,7,9},
                {2,4,6,8,10},
                {11,13,15,17,19},
                {12,14,16,18,20},
                {21,22,23,24,25}};
        new KthSmallestElementinaSortedMatrix().kthSmallest(param, 24);
    }
}
