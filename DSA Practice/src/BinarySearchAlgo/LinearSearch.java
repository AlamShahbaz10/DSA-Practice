package BinarySearchAlgo;

public class LinearSearch {

    public static void find(int[] arr, int n){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == n){
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found!");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 6;

        find(arr, n);

    }
}
