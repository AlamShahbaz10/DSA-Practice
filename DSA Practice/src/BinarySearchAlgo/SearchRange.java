package BinarySearchAlgo;

import java.util.Arrays;

public class SearchRange {

    public static int[] searchRange(int[] arr, int n){

        int[] ans = {-1, -1};

        int first = findAns(arr, n, true);
        int last = findAns(arr, n, false);

        ans[0] = first;
        ans[1] = last;

        return ans;
    }

    public static int findAns(int[] arr, int n, boolean findFirstOccurence){
        int first = 0;
        int last = arr.length - 1;
        int ans = -1;

        while(first <= last){

            int mid = first + (last - first) / 2;

            if(n > arr[mid]){
                first = mid + 1;
            }else if(n < arr[mid]){
                last = mid - 1;
            }else{
                ans = mid;
                if(findFirstOccurence){
                    last = mid - 1;
                }else{
                    first = mid + 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 7, 8, 8, 9};
        int n = 7;
        System.out.println(Arrays.toString(searchRange(arr, n)));
    }
}
