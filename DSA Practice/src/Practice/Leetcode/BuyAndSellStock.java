package Practice.Leetcode;

public class BuyAndSellStock {
    public static void main(String[] args) {

        int[] arr = {7,6,4,3,1};//{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for(int i: prices) {
            min = Math.min(min, i);
            profit = Math.max(profit, i - min);
        }
        return profit;
    }
}
