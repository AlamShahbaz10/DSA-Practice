package SortingAlgorithms;

import java.util.Arrays;
import java.util.Stack;

public class MergeSort {

    public static int[] sort(int[] arr){

        //64, 25, 12, 22, 11

        if(arr.length == 1) return arr;

        int mid = arr.length/2;

        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {

        int[] sortedArr = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                sortedArr[k] = left[i];
                i++;
            }
            else{
                sortedArr[k] = right[j];
                j++;
            }
            k++;
        }

        //if any of the 2 arrays, left or right, has some elements left
        while(i < left.length){
            sortedArr[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length){
            sortedArr[k] = right[j];
            j++;
            k++;
        }

        return sortedArr;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{64, 25, 12, 22, 11};
        arr = sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
