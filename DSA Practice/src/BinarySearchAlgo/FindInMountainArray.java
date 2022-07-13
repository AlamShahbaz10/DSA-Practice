package BinarySearchAlgo;

public class FindInMountainArray {

    public static int findPeakIndex(int[] arr){
        int first = 0;
        int last = arr.length - 1;

        while(first < last){
            int mid = first + (last - first) / 2;

            if(arr[mid] > arr[mid + 1]){
                last = mid;
            }else {
                first = mid + 1;
            }
        }
        return first;
    }

    public static int findInMountainArray(int[] arr, int target, int first, int last){

        //1, 2, 3, 4, 5

        while(first <= last){
            int mid = (first + last) / 2;
            if(arr[mid] > target){
                last = mid - 1;
            }
            else if(arr[mid] < target){
                first = mid + 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        int peakIndex = findPeakIndex(arr);

        int ans = findInMountainArray(arr, target, 0, peakIndex);
        if(ans != -1){
            System.out.println(ans);
        }else{
            ans = findInMountainArray(arr, target, peakIndex + 1, arr.length - 1);
            System.out.println(ans);
        }

    }
}
