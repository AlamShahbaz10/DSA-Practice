package BinarySearchAlgo;

public class BinarySearchUsingRecursion {

    public static void main(String[] args) {
        BinarySearchUsingRecursion bs = new BinarySearchUsingRecursion();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(bs.findElement(arr, 0, arr.length-1, 3));
    }

    private int findElement(int[] arr, int first, int last, int n) {

        if(first <= last && last <= arr.length -1){
            int mid = (first + last) / 2;
            if(arr[mid] > n){
                last = mid -1;
                return findElement(arr, first, last, n);
            }else if(arr[mid] < n){
                first = mid + 1;
                return findElement(arr, first, last, n);
            }else{
                return mid;
            }
        }

        return -1;
    }
}
