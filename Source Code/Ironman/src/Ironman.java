import java.util.*;

public class Ironman {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        Point p1, p2;

        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membaca posisi Iron Man
        int x = input.nextInt();
        int y = input.nextInt();
        Point ironManPos = new Point(x, y);

        // Membaca jumlah robot Ultron
        int N = input.nextInt();
        Point[] ultronPos = new Point[N];

        // Membaca posisi robot Ultron
        for (int i = 0; i < N; i++) {
            x = input.nextInt();
            y = input.nextInt();
            ultronPos[i] = new Point(x, y);
        }

        // Membaca jumlah sisi bangunan
        int K = input.nextInt();
        Line[] buildingSides = new Line[K];

        // Membaca sisi bangunan
        for (int i = 0; i < K; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int d = input.nextInt();
            Point p1 = new Point(a, b);
            Point p2 = new Point(c, d);
            buildingSides[i] = new Line(p1, p2);
        }

        // Menghitung jumlah robot Ultron yang dapat dihancurkan
        int destroyedRobots = countDestroyedRobots(ironManPos, ultronPos, buildingSides);

        // Menampilkan hasil
        System.out.println(destroyedRobots);
    }

    public static int countDestroyedRobots(Point ironManPos, Point[] ultronPos, Line[] buildingSides) {
        int count = 0;

        // Mengecek setiap robot Ultron
        for (Point ultron : ultronPos) {
            // Mengecek apakah garis tembakan laser melintasi bangunan
            boolean intersectsBuilding = false;
            for (Line side : buildingSides) {
                if (doIntersect(ironManPos, ultron, side.p1, side.p2)) {
                    intersectsBuilding = true;
                    break;
                }
            }

            // Jika garis tembakan tidak melintasi bangunan, robot dapat dihancurkan
            if (!intersectsBuilding) {
                count++;
            }
        }

        return count;
    }

    public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // Kasus umum
        if (o1 != o2 && o3 != o4) {
            return true;
        }

        // Kasus khusus ketika garis segmen saling berpotongan pada ujungnya
        if (o1 == 0 && onSegment(p1, p2, q1)) {
            return true;
        }
        if (o2 == 0 && onSegment(p1, q2, q1)) {
            return true;
        }
        if (o3 == 0 && onSegment(p2, p1, q2)) {
            return true;
        }
        if (o4 == 0 && onSegment(p2, q1, q2)) {
            return true;
        }

        return false;
    }

    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0) {
            return 0;  // Kolinear
        }

        return (val > 0) ? 1 : 2;  // Atas atau bawah
    }

    public static boolean onSegment(Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
            return true;
        }

        return false;
    }
}
