package BinarySearchAlgo;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Target element is at index: " + searchElement(arr, target));
    }

    static int searchElement(int[] arr, int target){
        int pivot = findPivot(arr);
        System.out.println("Pivot is at index: " + pivot);

        if(pivot == -1){
            // normal BS
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        if(arr[pivot] == target){
            return pivot;
        }
        if(arr[0] < target){
            return binarySearch(arr, target, 0, pivot);
        }

        return binarySearch(arr, target, pivot + 1, arr.length - 1);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] > target){
                end = mid - 1;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        //{4, 5, 6, 7, 0, 1, 2};

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
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
