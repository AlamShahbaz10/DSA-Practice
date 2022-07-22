package Practice.Matrix;

import java.util.ArrayList;
import java.util.List;

public class FindElementsLesserOrEqualToANumber {
    public static void main(String[] args) {
        int[][] matrix = {{2, 7, 15},
                         {4, 9, 19},
                         {6, 10, 24}};

        findElement(matrix, 9); // 2,4,6,7,9
    }

    private static void findElement(int[][] matrix, int n) {
        int row = 0;
        int column = matrix.length - 1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] <= n){
                    list.add(matrix[i][j]);
                }
            }
        }
        System.out.println(list);
    }
}
