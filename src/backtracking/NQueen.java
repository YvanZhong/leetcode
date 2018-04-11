package backtracking;

import java.util.*;
public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList();

        helper(0, n, new ArrayList<>(), res);

        return res;
    }

    private void helper(int row, int n, List<Integer[]> cur, List<List<String>> res) {
        if (row == n) {
            //add
            List<String> list = new LinkedList();

            for (Integer[] p: cur) {
                char[] chs = new char[n];
                for (int i = 0; i < chs.length; i++) {
                    chs[i] = '.';
                }
                chs[p[1]] = 'Q';
                String str = new String(chs);
                list.add(str);
            }

            res.add(list);

        } else {
            for (int i = 0; i < n; i++) {
                if (canPut(cur, row, i)) {
                    Integer[] tmp = new Integer[]{row, i};
                    cur.add(tmp);
                    helper(row+1, n, cur, res);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    private boolean canPut(List<Integer[]> cur, int row, int col) {
        for (Integer[] i: cur) {
            //System.out.println(cur);
        }
        //System.out.println(row + " " + col);
        for (Integer[] other: cur) {
            if (other[1] == col) return false;
            if (Math.abs(row - other[0]) == Math.abs(other[1] - col)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueen().solveNQueens(8).size());
    }

}
