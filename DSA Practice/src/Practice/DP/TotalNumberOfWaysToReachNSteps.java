package Practice.DP;

public class TotalNumberOfWaysToReachNSteps {
    public static void main(String[] args) {
        System.out.println(totalNumberOfWaysToReachNSteps(5));
    }

    private static int totalNumberOfWaysToReachNSteps(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;

        return totalNumberOfWaysToReachNSteps(n - 1) + totalNumberOfWaysToReachNSteps(n - 2)
                + totalNumberOfWaysToReachNSteps(n - 3);
    }
}
