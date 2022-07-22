package SlidingWindow;

import static java.lang.Math.max;

public class Example1 {

    public static void main(String[] args) {

        //arr = {2, 5, 1, 8, 2, 9, 1} => (2,5,1) (5,1,8) (1,8,2) (8,2,9) (2,9,1)
        //k = 3
        // return max sum of sub array of size 3

        int arr[] = {2, 5, 1, 8, 2, 9, 1};
        int maxSum = 0;
        for(int i=0; i< arr.length -2; i++){
            int temp = 0;
            for(int j=i; j<i+3; j++){
                temp += arr[j];
            }
            maxSum = max(temp, maxSum);
        }
        System.out.println("Max sum of sub arr: " + maxSum);

        System.out.println("Sliding window solution: " + result(arr));
    }

    private static int result(int[] arr) {

        int i =0, j = 0, k = 3;
        int sum = 0, maxSum = 0;

        while(j < arr.length){
            sum += arr[j];

            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                maxSum = max(sum, maxSum);
                sum -= arr[i];
                i++;
                j++;
            }
        }

        return maxSum;
    }
}
