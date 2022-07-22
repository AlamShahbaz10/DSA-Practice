package Practice.Leetcode;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4}; //{2, 7, 11, 15};
        int target = 8;
        int[] ans = findPair(arr, target);
        System.out.println(ans[0] + " " + ans[1]);

        int[] altAns = findPairAltSolution(arr, target);
        System.out.println(altAns[0] + " " + altAns[1]);
    }

    private static int[] findPairAltSolution(int[] arr, int target) {
        int[] ans = {-1, -1};

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int requiredNum = target - arr[i];
            if(hm.containsKey(requiredNum)) {
                ans[0] = hm.get(requiredNum);
                ans[1] = i;
                return ans;
            }
            hm.put(arr[i], i);
        }
        return ans;
    }

    private static int[] findPair(int[] arr, int target) {
        int[] ans = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }
}
