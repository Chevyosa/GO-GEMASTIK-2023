import java.util.Scanner;

public class KertasGambar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah kertas: ");
        int jumlahKertas = input.nextInt();
        int[][] n = new int[jumlahKertas][3];
        for (int i = 0; i < jumlahKertas; i++) {
            System.out.print("Masukkan panjang, lebar, dan banyaknya lipatan kertas ke-" + (i+1) + ": ");
            n[i][0] = input.nextInt();
            n[i][1] = input.nextInt();
            n[i][2] = input.nextInt();
        }
        System.out.println("Hasil lipatan kertas gambar:");
        lkg(n, jumlahKertas);
    }

    public static void lkg(int[][] N, int jumlahKertas) {
        for (int i = 0; i < jumlahKertas; i++) {
            int[] n = N[i];
            int m = n[2];
            for (int j = 1; j <= m; j++) {
                if (n[0] > n[1]) {
                    int p = n[0] / 2;
                    int q = n[1];
                    n[0] = p;
                    n[1] = q;
                } else {
                    int p = n[1] / 2;
                    int q = n[0];
                    n[0] = p;
                    n[1] = q;
                }
            }
            if (n[0] > n[1]) {
                System.out.println(n[0] + " " + n[1]);
            } else {
                System.out.println(n[1] + " " + n[0]);
            }
        }
    }
}