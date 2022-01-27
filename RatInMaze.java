
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


    public static boolean solveMaze(int[][] v, int i, int j, int m, int n) {
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
            System.out.println();
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