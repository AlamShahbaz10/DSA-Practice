package Practice;

import java.util.Arrays;

public class LargestProductInArray {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2};
        System.out.println(largestProduct(arr));

    }

    public static int largestProduct(int[] arr){

        int size = arr.length;

        int largestProduct = 1;
        if(size<3){
            return -1;
        }
        if(size == 3){
            for(int i: arr){
                largestProduct *= arr[i];
            }
        }

        if(size>3){
            Arrays.sort(arr);
            //1,2,3,4,5
            for(int i=size-3; i<size; i++){
                largestProduct *= arr[i];
            }
        }
        return largestProduct;
    }
}
