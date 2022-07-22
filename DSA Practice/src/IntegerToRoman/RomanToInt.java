package IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {

        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);


        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp1 = hm.get(s.charAt(i));
            if(i + 1 < s.length()){
                int temp2 = hm.get(s.charAt(i + 1));

                if(temp1 < temp2) {
                    result -= temp1;
                }else {
                    result += temp1;
                }
            }else{
                result += temp1;
            }
        }

        return result;
    }
}
