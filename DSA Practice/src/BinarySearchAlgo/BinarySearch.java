package BinarySearchAlgo;

import java.util.Arrays;

public class BinarySearch {

    public int findElement(int[] arr, int n){


        int first = 0;
        int last = arr.length-1;


        while(first <= last){
            int mid = (first + last) / 2;
            if(arr[mid] > n){
                last = mid - 1;
            }
            else if(arr[mid] < n){
                first = mid + 1;
            }
            else{
                return mid;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9};
        System.out.println(bs.findElement(arr, 2));

        int[] arr1 = {11, 14, 19, 24, 32, 44};
        System.out.println("Ceiling number: " + bs.findCeiling(arr1, 45));
        System.out.println("Floor number: " + bs.findFloor(arr1, 45));
    }

    //Smallest element >= target
    public int findCeiling(int[] arr, int n){

        int first = 0;
        int last = arr.length - 1;

        if(n > arr[arr.length-1]) return -1;

        while(first <= last){
            int mid = (first + last) / 2;
            if(arr[mid] > n){
                last = mid - 1;
            }
            else if(arr[mid] < n){
                first = mid + 1;
            }
            else{
                return mid;
            }
        }

        return first;
    }

    //Greatest element <= target
    public int findFloor(int[] arr, int n){

        int first = 0;
        int last = arr.length - 1;


        if(n < arr[0]) return -1;

        while(first <= last){
            int mid = (first + last) / 2;
            if(arr[mid] > n){
                last = mid - 1;
            }
            else if(arr[mid] < n){
                first = mid + 1;
            }
            else{
                return mid;
            }
        }

        return last;
    }
}
