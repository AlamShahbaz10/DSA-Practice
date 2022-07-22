package Practice.Leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeat("tmmzuxt"));
    }
    static int longestSubstringWithoutRepeat(String s) {

        Map<Character, Integer> hm = new HashMap<>();
        int start = 0, end = 0, max = 0;
        while(end < s.length()) {
            if(!hm.containsKey(s.charAt(end))){
                hm.put(s.charAt(end), end);
            } else {
                start = Math.max(start, hm.get(s.charAt(end)) + 1);
                hm.put(s.charAt(end), end);
            }
            if((end - start + 1) > max){
                max = end - start + 1;
            }
            end++;
        }
        return max;
    }
}
