package BinarySearchAlgo;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 8, 10};
        int m = 2;
        System.out.println(minimizeLargestSum(arr, m));
    }

    private static int minimizeLargestSum(int[] arr, int m) {
        int minSumFromLargestSum = 0;
        int maxSum = 0;

        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }

        int subArr1 = 0;
        int subArr2;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            subArr1 += arr[i];
            subArr2 = arrSum - subArr1;
            maxSum = Math.max(subArr1, subArr2);
            minSumFromLargestSum = Math.min(temp, maxSum);
            if(i == arr.length - 2){
                maxSum = Math.max(subArr1, arr[i+1]);
                minSumFromLargestSum = Math.min(temp, maxSum);
            }
            temp = maxSum;
        }

        return minSumFromLargestSum;
    }
}
