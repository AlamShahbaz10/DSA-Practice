package BinarySearchAlgo;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1}; //{4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3}; //{4, 5, 6, 7, 0, 1, 2};
        System.out.println(rotationCount(arr));
    }
    static int rotationCount(int[] arr){

        return findPivot(arr) + 1;
    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            //{4, 5, 6, 7, 0, 1, 2};
            if(arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
