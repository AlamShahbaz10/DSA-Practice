package Practice.Leetcode;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0}; //[3,4,-1,1]
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int missing = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == missing) {
                missing++;
            }
        }
        return missing;
    }
}
