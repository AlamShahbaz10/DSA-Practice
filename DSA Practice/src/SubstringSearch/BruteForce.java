package SubstringSearch;

public class BruteForce {

    public static int altMethod(String text, String pattern){

        int textLength = text.length();
        int patternLength = pattern.length();

//        String text = "wdsabcfg";
//        String pattern = "abx";

        for(int i=0; i<=textLength-patternLength; i++){
            int j;
            for(j=0; j<patternLength; j++){
                if(text.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
            }
            if(j == patternLength){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(BruteForce.altMethod("wdsabcfg", "abc"));

        System.out.println("*****************");
        String text = "wdsabcfg";
        String pattern = "cfg";

        for(int i=0; i<=text.length()-pattern.length(); i++){
            for(int j=0; j<pattern.length(); j++){
                if(pattern.charAt(j) == text.charAt(i+j)){
                    if(j == pattern.length()-1) {
                        System.out.println("Substring found at index: " + i);
                    }
                }
                else{
                  break;
                }
            }
        }
    }
}
