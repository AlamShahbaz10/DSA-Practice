package Practice.String;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("equation")); //euaio => oiaue
    }

    private static String reverseVowels(String equation) {

        char[] arr = equation.toCharArray();
        int start = 0, end = arr.length - 1;
        while(start < end){
            if(!isVowel(arr[start])){
                start++;
                continue;
            }
            if(!isVowel(arr[end])){
                end--;
                continue;
            }
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    private static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'A'
                || ch == 'e' || ch == 'E'
                || ch == 'i' || ch == 'I'
                || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U'){
            return true;
        }
        return false;
    }
}
