package Practice.Backtracking;

public class RatMaze {
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 1, 1},
                        {1, 0, 0, 1}};

        int[][] path = new int[4][4];

        System.out.println(findPath(mat, 0, 0, path));

    }

    static boolean findPath(int[][] mat, int row, int col, int[][] path){

        if(row == mat.length - 1 && col == mat.length - 1 && mat[row][col] == 1){
            path[row][col] = 1;
            printPath(path);
            return true;
        }

        if(isSafe(mat, row, col)){
            path[row][col] = 1;

            if(findPath(mat, row + 1, col, path)){
                return true;
            }

            if(findPath(mat, row, col + 1, path)){
                return true;
            }

            path[row][col] = 0;
        }

        return false;
    }

    private static boolean isSafe(int[][] mat, int row, int col) {
        if(row >= 0 && row < mat.length && col >= 0 && col < mat.length && mat[row][col] == 1){
            return true;
        }
        return false;
    }

    private static void printPath(int[][] path) {

        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}
