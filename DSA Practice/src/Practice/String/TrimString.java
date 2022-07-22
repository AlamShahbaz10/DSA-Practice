package Practice.String;

public class TrimString {
    public static void main(String[] args) {
        String s = "     Hello     World     ";
        System.out.println(s.trim());

        int start = 0, end = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != ' '){
                start = i;
                break;
            }
        }

        for (int i = arr.length - 1; i > start - 1; i--) {
            end = i;
            break;
        }
        for (int i = start; i < end; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
        String result = new String(arr, start, end - start + 1);
        System.out.println(result);
    }

}
