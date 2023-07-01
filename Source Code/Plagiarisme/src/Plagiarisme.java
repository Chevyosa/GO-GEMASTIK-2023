import java.util.Scanner;

public class Plagiarisme {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membaca input bilangan N dan M
        int N = input.nextInt();
        int M = input.nextInt();

        // Membaca nilai jawaban dari peserta
        int[][] nilaiJawaban = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nilaiJawaban[i][j] = input.nextInt();
            }
        }

        // Membaca waktu pengumpulan jawaban dari peserta
        int[][] waktuPengumpulan = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                waktuPengumpulan[i][j] = input.nextInt();
            }
        }

        // Menghitung tingkat plagiarisme tertinggi antara semua pasang peserta
        int tingkatPlagiarismeTertinggi = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int tingkatPlagiarisme = 0;

                for (int k = 0; k < M; k++) {
                    int selisihWaktu = Math.abs(waktuPengumpulan[i][k] - waktuPengumpulan[j][k]);
                    int selisihNilai = Math.abs(nilaiJawaban[i][k] - nilaiJawaban[j][k]);

                    int tingkatPlagiarismeSoal = selisihWaktu + selisihNilai;
                    tingkatPlagiarisme = Math.max(tingkatPlagiarisme, tingkatPlagiarismeSoal);
                }

                int selisihPosisi = Math.abs(i - j);
                int tingkatPlagiarismePasangan = tingkatPlagiarisme + selisihPosisi;

                tingkatPlagiarismeTertinggi = Math.max(tingkatPlagiarismeTertinggi, tingkatPlagiarismePasangan);
            }
        }

        // Menampilkan jawaban
        System.out.println(tingkatPlagiarismeTertinggi);

        input.close();
    }
}
