package Practice.String;

public class PrintFirstCharacterOfEveryWord {
    public static void main(String[] args) {

        String str = "   Hello   There  World ";
        String[] arr = str.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if("".equals(arr[i])){
                continue;
            }else{
                System.out.println(arr[i].charAt(0));
            }
        }
    }
}
