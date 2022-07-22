package Practice.Matrix;

public class FindElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{2, 7, 15},
                         {4, 9, 19},
                         {6, 10, 24}};

        findElement(matrix, 24);
    }

    private static void findElement(int[][] matrix, int n) {
        int row = 0;
        int column = matrix.length - 1;

        while(row < matrix.length && column >=0){
            if(matrix[row][column] == n){
                System.out.println("Row and column index: " + row + ", " +column);
                return;
            }

            if(n > matrix[row][column]) {
                row++;
            }else {
                column--;
            }
        }
        System.out.println("Value is not present");
    }
}
