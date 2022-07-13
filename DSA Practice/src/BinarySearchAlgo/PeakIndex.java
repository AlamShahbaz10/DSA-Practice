package BinarySearchAlgo;

public class PeakIndex {

    public static int findPeakIndex(int[] arr){

        int first = 0;
        int last = arr.length - 1;

        while(first < last){
            int mid = (first + last) / 2;
            if(arr[mid] > arr[mid + 1]){
                last = mid;
            }
            else{
                first = mid + 1;
            }
        }

        return first;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0}; //{1, 2, 3, 5, 6, 4, 3, 2};
        System.out.println(findPeakIndex(arr));
    }
}
