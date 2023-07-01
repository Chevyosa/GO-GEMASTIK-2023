import java.util.*;

class Sarang {
    int monsters;
    boolean visited;

    public Sarang(int monsters) {
        this.monsters = monsters;
        this.visited = false;
    }
}

public class MonsterDanPortal {
    static int[] powerRequired;

    public static int findMinPower(List<Sarang>[] graph, int n) {
        int totalPower = 0;
        Queue<Sarang> queue = new LinkedList<>();

        queue.add(new Sarang(0));
        graph[0].get(0).visited = true;

        while (!queue.isEmpty()) {
            Sarang currentSarang = queue.poll();
            totalPower += powerRequired[currentSarang.monsters];

            for (Sarang neighbor : graph[currentSarang.monsters]) {
                if (!neighbor.visited) {
                    neighbor.visited = true;
                    queue.add(neighbor);
                }
            }
        }

        return totalPower;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Banyaknya sarang monster
        int k = sc.nextInt(); // Banyaknya terowongan penghubung

        powerRequired = new int[101];
        for (int i = 0; i <= 100; i++) {
            powerRequired[i] = i;
        }

        List<Sarang>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            int monsters = sc.nextInt();
            graph[i] = new ArrayList<>();
            graph[i].add(new Sarang(monsters));
        }

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a - 1].add(graph[b - 1].get(0));
            graph[b - 1].add(graph[a - 1].get(0));
        }

        int result = findMinPower(graph, n);
        System.out.println(result);
    }
}