import java.util.Scanner;

public class BitcoinPakGemas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] prices = new int[N];

        for (int i = 0; i < N; i++) {
            prices[i] = input.nextInt();
        }

        int maxProfit = calculateMaxProfit(prices);
        System.out.println(maxProfit);
    }

    private static int calculateMaxProfit(int[] prices) {
        int maxProfit = 0;
        int buyDay = 0;
        int sellDay = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[sellDay]) {
                sellDay = i;
            } else {
                maxProfit += prices[sellDay] - prices[buyDay];
                buyDay = i;
                sellDay = i;
            }
        }

        maxProfit += prices[sellDay] - prices[buyDay];
        return maxProfit;
    }
}