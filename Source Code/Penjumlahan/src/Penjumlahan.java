import java.util.Scanner;

public class Penjumlahan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        int Q = input.nextInt();

        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        for (int q = 0; q < Q; q++) {
            int X1 = input.nextInt();
            int Y1 = input.nextInt();
            int X2 = input.nextInt();
            int Y2 = input.nextInt();

            int subSum = calculateSubMatrixSum(matrix, X1, Y1, X2, Y2);
            System.out.println(subSum);
        }
    }

    private static int calculateSubMatrixSum(int[][] matrix, int X1, int Y1, int X2, int Y2) {
        int sum = 0;

        for (int i = X1 - 1; i < X2; i++) {
            for (int j = Y1 - 1; j < Y2; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}