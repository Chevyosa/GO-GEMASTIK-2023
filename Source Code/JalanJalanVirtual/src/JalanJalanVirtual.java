import java.util.Scanner;

public class JalanJalanVirtual {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // read the number of test cases
        int N = input.nextInt();
        for (int i = 0; i < N; i++) {
            // read the number of steps
            int M = input.nextInt();
            // initialize the position and direction
            int x = 0;
            int y = 0;
            char dir = 'T'; // T for east, U for north, B for west, S for south
            // loop through the steps
            for (int j = 1; j <= M; j++) {
                // move according to the direction
                switch (dir) {
                    case 'T':
                        x++;
                        break;
                    case 'U':
                        y++;
                        break;
                    case 'B':
                        x--;
                        break;
                    case 'S':
                        y--;
                        break;
                }
                // check if the direction needs to change
                if (isPerfectSquare(j)) {
                    dir = nextDirection(dir);
                }
            }
            // print the final position
            System.out.println(x + " " + y);
        }
    }

    // check if a number is a perfect square
    public static boolean isPerfectSquare(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }

    // get the next direction in clockwise order
    public static char nextDirection(char dir) {
        switch (dir) {
            case 'T':
                return 'U';
            case 'U':
                return 'B';
            case 'B':
                return 'S';
            case 'S':
                return 'T';
            default:
                return '?';
        }
    }
}