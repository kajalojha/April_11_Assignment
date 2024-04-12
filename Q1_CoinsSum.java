package April_11_Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_CoinsSum {
    public static int coinSumWays(int[] coins, int targetSum) {
        int mod = 1000007;
        int[] dp = new int[targetSum + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1; // Base case: One way to make sum 0

        for (int coin : coins) {
            for (int i = coin; i <= targetSum; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }

        return dp[targetSum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of coins
        System.out.print("Enter the number of coins: ");
        int numCoins = scanner.nextInt();

        // Input the coin values
        int[] coins = new int[numCoins];
        System.out.println("Enter the coin values:");
        for (int i = 0; i < numCoins; i++) {
            coins[i] = scanner.nextInt();
        }

        // Input the target sum
        System.out.print("Enter the target sum: ");
        int targetSum = scanner.nextInt();

        // Calculate and print the number of ways
        System.out.println("Number of ways to make the sum: " + coinSumWays(coins, targetSum));
    }
}
