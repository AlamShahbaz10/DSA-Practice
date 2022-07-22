package Practice;

public class Main {
    private static int sum;

    public static void main(String[] args) {
//        print(5);
        System.out.println(fact(5));
        System.out.println(sumOfDigits(1342));
        System.out.println(productOfDigits(1342));
        //System.out.println(reverseNum(1342));
        System.out.println(isPalindrome(12321));
        System.out.println(countZeroes(3020, 0));
        System.out.println(reduceToZero(41));
        printStarPattern(4);
        printStarPatternUsingRec(4, 0);
    }


    private static void printStarPatternUsingRec(int row, int col) {

        if(row == 0){
            return;
        }

        if(col < row){
            System.out.print("*");
            printStarPatternUsingRec(row, col + 1);
        }else{
            System.out.println();
            printStarPatternUsingRec(row - 1, 0);
        }

    }

    private static void printStarPattern(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }



    private static int reduceToZero(int i) {
        return helper(i, 0);
    }

    private static int helper(int i, int steps) {
        if(i == 0) {
            return steps;
        }
        if(i % 2 == 0){
            return helper(i / 2, steps + 1);
        }
        return helper(i - 1, steps + 1);
    }

    private static int countZeroes(int i, int count) {
        if(i == 0){
            return count;
        }
        int rem = i % 10;
        if(rem == 0) count++;
        int n = i / 10;
        return countZeroes(n, count);
    }

    private static boolean isPalindrome(int i) {
       return i == reverseNum(i);
    }

    private static int reverseNum(int i) {
        if(i == 0){
            return 0;
        }
        int rem = i % 10;
        int n = i / 10;
//        String s1 = String.valueOf(rem);
//        String s2 = String.valueOf(reverseNum(n));
//        return Integer.valueOf(s1 + s2);

        sum = (sum * 10) + rem;
        reverseNum(n);
        return sum;
    }

    private static int sumOfDigits(int i) {
        if(i % 10 == i){
            return i;
        }
        int rem = i % 10;
        int n = i / 10;
        return rem + sumOfDigits(n);
    }

    private static int productOfDigits(int i) {
        if(i <= 1){
            return i;
        }
        int rem = i % 10;
        int n = i / 10;
        return rem * productOfDigits(n);
    }

    private static int fact(int i) {
        if(i <= 1){
            return i;
        }
        return i * fact(i - 1);
    }

    private static void print(int i) {

        if(i == 0){
            return;
        }

        print(i-1);
        System.out.print(i + " ");
    }
}