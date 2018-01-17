import java.util.*;

public class SurroundedRegions {

    //stackoverflow
    public static void solve1(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length, total = row * col;
        int index = 0;
        int[] flag = new int[total];
        while (index < total) {
            if (board[index / col][index % col] =='O' && flag[index] == 0){
                List<Integer> ls = new ArrayList<>();
                if (helper1(board, index, flag, ls)) {
                    for (int i : ls) {
                        board[i / col][i % col] ='X';
                    }
                }
            }
            index++;
        }
    }

    private static boolean helper1(char[][] board, int index, int[] flag, List<Integer> ls) {
//        System.out.println(index);
        int r = index / board[0].length, c = index % board[0].length;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length ||board[r][c] =='X')return true;

        if (r > 0 && c > 0 && r < board.length - 1 && c< board[0].length - 1 && flag[index] == 0) {
            flag[index] = 1;
            ls.add(index);
            boolean f = true;
            /* wrong  不应该是 index + 1
            return helper(board, index + 1, flag, ls) &&
                    helper(board, index - 1, flag, ls) &&
                    helper(board, index + board[0].length, flag, ls) &&
                    helper(board, index - board[0].length, flag, ls);*/

            /*if (r > 1 && board[r - 1][c] == 'O')
                f &= helper(board, (r-1) * board[0].length + c, flag, ls);
            if (r < board.length - 2 && board[r + 1][c] == 'O')
                f &= helper(board, (r+1) * board[0].length + c, flag, ls);
            if (c > 1 && board[r][c-1] == 'O')
                f &= helper(board, r * board[0].length + c - 1, flag, ls);
            if (c < board.length - 2 && board[r][c+1] == 'O')
                f &= helper(board, r * board[0].length + c + 1, flag, ls);*/

            if (board[r - 1][c] == 'O')
                if (r > 1 && flag[index - board[0].length] == 0)
                    f &= helper1(board, index - board[0].length, flag, ls);
                else if (r == 1) return false;
            if (board[r + 1][c] == 'O')
                if (r < board.length - 2 && flag[index + board[0].length] == 0)
                    f &= helper1(board, index + board[0].length, flag, ls);
                else if (r == board.length - 2) return false;
            if (board[r][c-1] == 'O')
                if (c > 1 && flag[index - 1] == 0)
                    f &= helper1(board, index - 1, flag, ls);
                else if (c == 1) return false;
            if (board[r][c+1] == 'O')
                if (c < board[0].length - 2&& flag[index + 1] == 0)
                    f &= helper1(board, index + 1, flag, ls);
                else if (c == board[0].length - 2) return false;
            return f;
        } else if (flag[index] == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n-1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j);
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';

    private static int count = 1;

    private static void boundaryDFS(char[][] board, int i, int j) {
        count++;
        System.out.println(count); //使用该函数  stackoverflow更早
        if (count == 6064)
        {
            int a = 0;
        }
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            boundaryDFS(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            boundaryDFS(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            boundaryDFS(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            boundaryDFS(board, i, j+1);

//        System.out.print(count++);

    }

    private static void testDfs() {
        dfs(100000);
    }

    private static void dfs(int n) {
        if (n == 0) return;
        System.out.println(n);
        dfs(n-1);
    }

    public static void main(String[] args) {
        int l = 1000;
        char[][] ch = new char[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                ch[i][j] = 'O';
            }
        }

        try {
            solve(ch);
        } catch (Throwable e) {
            System.out.println("exception: "+ count);
        }

//        testDfs();


        int count = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (ch[i][j] == 'X') {
                    count++;
                }
            }
        }

        System.out.println("count: "+count);

    }
}
