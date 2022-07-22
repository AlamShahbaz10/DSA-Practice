package Practice.Backtracking;

public class NQueen {
    public static void main(String[] args) {
        int[][] mat = new int[4][4];
        System.out.println(nQueenUtil(0, mat));
        //System.out.println(queenProblemUtil(0, mat));
    }

    static boolean nQueenUtil(int col, int[][] mat){

        if(col >= mat.length){
            printNQueen(mat);
            return true;
        }


        for (int i = 0; i < mat.length; i++) {
            if (isSafeForQueenPlacement(i, col, mat)){
                mat[i][col] = 1;

                if(nQueenUtil(col + 1, mat)){
                    return true;
                }
                mat[i][col] = 0; //Backtracking
            }

        }

        return false;
    }

    static boolean isSafeForQueenPlacement(int row, int col, int[][] mat){

        for(int i = 0; i < col; i++){
            if(mat[row][i] == 1){
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(mat[i][j] == 1){
                return false;
            }
        }

        for(int i = row, j = col; i < mat.length && j >= 0; i++, j--){
            if(mat[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    private static boolean queenProblemUtil(int col, int[][] sol) {

        if(col >= 4) {
            printNQueen(sol);
            return true;
        }

        for(int row = 0; row < 4; row++) {

            if(isSafeToPlaceQueen(row, col, sol)) {
                sol[row][col] = 1;

                if(queenProblemUtil(col + 1, sol)) {
                    return true;
                }

                sol[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isSafeToPlaceQueen(int row, int col, int[][] sol) {
        int i, j;

        for(i = 0; i < col; i++) {
            if(sol[row][i] == 1) {
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j >= 0 ; i--, j--) {
            if(sol[i][j] == 1) {
                return false;
            }
        }

        for(i = row, j = col; i < 4 && j >= 0 ; i++, j--) {
            if(sol[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printNQueen(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
