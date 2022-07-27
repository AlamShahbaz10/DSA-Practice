package Practice.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, 4};
        System.out.println("Brute force solution: " + bruteForceSolution(arr));
        System.out.println(threeSum(arr));
    }

    private static List<List<Integer>> bruteForceSolution(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = i + 2; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        threeSum.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return threeSum;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> threeSum = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if(nums[i] == 0 && nums[j] == 0 && nums[k] == 0) {
                threeSum.add(Arrays.asList(nums[i], nums[j], nums[k]));
                return threeSum;
            }

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    threeSum.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                } else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        threeSum = new ArrayList <>(new LinkedHashSet <>(threeSum));

        return threeSum;
    }
}
