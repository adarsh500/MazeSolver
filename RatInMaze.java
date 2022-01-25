import java.util.*;

public class RatInMaze {
    static public int[][] sol;
    public int m, n;
    //m - rows
    //n - cols

    RatInMaze(int m, int n) {
        this.m = m;
        this.n = n;
        sol = new int[m][n];
    }

//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int m = s.nextInt();
//        int n = s.nextInt();
//
//        String[][] maze = new String[m][n];
//        int[][] v = new int[m][n];
//        int[][] sol = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            String str = s.next();
//            for (int k = 0; k < str.length(); k++) {
//                char cc = str.charAt(k);
//                if (cc == 'X') {
//                    v[i][k] = 1;
//                }
//            }
//        }
//        m--;
//        n--;
//        boolean ans = solveMaze(v, sol, 0, 0, m, n);
//        if (ans == false) {
//            System.out.println("-1");
//        }
//
//    }

    public static boolean solveMaze(int[][] v, int i, int j, int m, int n) {
//        System.out.print(i + "" + j + " ");
        //in question
        //1 - wall
        //0 - empty space
        //3 - destination


        //in solution
        //1 - path
        //0 - empty space
        if (v[i][j] == 3) {

            sol[i][j] = 1;

            ///Print the soln
            for (int x = 0; x <= m; x++) {
                for (int y = 0; y <= n; y++) {
                    System.out.print(sol[x][y] + " ");

                }
                System.out.println();
            }
            System.out.println();
            return true;
        }



        if (v[i][j] == 1)
            return false;

        v[i][j] = 1;
        ///Recursive Case
        ///Assuming path exists from i,j
        sol[i][j] = 1;


        ///1. Go Right
        if (j + 1 <= n && (v[i][j + 1] != 1)) {
            boolean pathFound;
            System.out.print("right->");

            pathFound = solveMaze(v, i, j + 1, m, n);

            if (pathFound == true) {
                return true;

            }
        }
        /// 2. Go Down
        if (i + 1 <= m && (v[i + 1][j] != 1)) {
            System.out.print("down->");

            boolean pathFound = solveMaze(v, i + 1, j, m, n);
            if (pathFound == true) {
                return true;
            }

        }
        //3. go up
        if (i - 1 >= 0 && (v[i - 1][j] != 1)) {
            System.out.print("up->");

            boolean pathFound = solveMaze(v, i - 1, j, m, n);
            if (pathFound == true) {
                return true;
            }

        }
        //4. go left
        if (j - 1 >= 0 && (v[i][j - 1] != 1)) {
            System.out.print("left->");

            boolean pathFound = solveMaze(v, i, j - 1, m, n);
            if (pathFound == true) {
                return true;
            }

        }


        ///Backtracking
        sol[i][j] = 0;
        System.out.print("<-back");
        return false;
    }
}