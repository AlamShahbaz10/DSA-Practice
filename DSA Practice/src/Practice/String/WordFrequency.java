package Practice.String;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {

        String str = "Hello Hello Abc Abc World";
        String[] arr = str.split(" ");
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }else{
                hm.put(arr[i], 1);
            }
        }
        System.out.println(hm);

            if(hm.containsKey("Abc")){
                hm.remove("Abc");
            }
        int max = Collections.max(hm.values());

        for(Map.Entry<String, Integer> entry: hm.entrySet()){
            if(max == entry.getValue()){
                System.out.println(entry.getKey());
            }
        }

    }
}
