package BinarySearchAlgo;

public class SmallestLetter {

    public static char findSmallestLetter(char[] arr, char c){

        int first = 0;
        int last = arr.length - 1;


        while(first <= last){
            int mid = (first + last)/2;

            //1. WRONG
//            if(arr[mid] < c){
//                first = mid + 1;
//            }else{
//                last = mid - 1;
//            }


            //2. RIGHT
//            if(c < arr[mid]){
//                last = mid - 1;
//            }else{
//                first = mid + 1;
//            }

            //3. RIGHT
            if(arr[mid] > c){
                last = mid - 1;
            }
            else{
                first = mid + 1;
            }
        }

        return arr[first % arr.length];
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while(start <= end) {
//            int mid = start + (end - start) / 2;

            int mid = (start + end)/2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }

    public static void main(String[] args) {

        char[] arr = {'c', 'f', 'j'};
        char c = 'k';
        System.out.println(findSmallestLetter(arr, c));

        System.out.println(nextGreatestLetter(arr, c));
    }
}
