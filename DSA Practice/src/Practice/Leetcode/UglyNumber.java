package Practice.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(8));

    }

    public static boolean isUgly(int num)
    {
        if(num<=0) return false;

        while(num%2==0) num/=2;
        while(num%3==0) num/=3;
        while(num%5==0) num/=5;

        if(num==1) return true;
        else return false;

    }

    public static boolean isUgly2(int n) {
        if(n == 1) return true;
        List<Integer> list = Arrays.asList(2, 3, 5);

        List<Integer> primeFactorList = new ArrayList<>();
        if(n == 2) {
            primeFactorList.add(2);
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                primeFactorList.add(i);
            }
        }

        if(primeFactorList.size() == 0) return false;

        for (int i = 0; i < primeFactorList.size(); i++) {

            if(isUgly(primeFactorList.get(i))){
                if(!list.contains(primeFactorList.get(i))){
                    return false;
                }
            }else{
                return false;
            }

        }
        return true;
    }

    public static boolean isUgly1(int n) {

        List<Integer> list = Arrays.asList(2, 3, 5);

        List<Integer> primeFactorList = primeFactors(n);

        if(primeFactorList.size() == 0) return false;

        List<Integer> checkPrimeFactor = new ArrayList<>();

        for (int i = 0; i < primeFactorList.size(); i++) {
            List<Integer> tempList = primeFactors(primeFactorList.get(i));
            checkPrimeFactor.addAll(tempList);
        }

        for (int i = 0; i < checkPrimeFactor.size(); i++) {
            if(!list.contains(checkPrimeFactor.get(i))){
                return false;
            }
        }
        return true;
    }

    private static List<Integer> primeFactors(int n) {

        List<Integer> primeFactorList = new ArrayList<>();
        for (int i = 2; i == 2 ? i <= n: i < n; i++) {
            if (n % i == 0) {
                primeFactorList.add(i);
            }
        }
        return primeFactorList;
    }
}
