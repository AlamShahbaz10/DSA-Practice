package Practice.DP;

public class MinimumJumps {
    public static void main(String[] args) {
        System.out.println(minJumps(7));
    }

    private static int minJumps(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n == 3) return 1;

        return 1 + Math.min(Math.min(minJumps(n - 1), minJumps(n - 2)), minJumps(n - 3));
    }
}
