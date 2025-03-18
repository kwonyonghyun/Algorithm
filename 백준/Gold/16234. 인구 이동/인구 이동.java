import java.util.*;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int board[][] = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int days = 0;

        while(true) {
            boolean[][] vis = new boolean[n][n];
            boolean moved = false;
            Map<Integer, List<Node>> allUnions = new HashMap<>();
            List<Integer> populations = new ArrayList<>();
            int unionCount = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!vis[i][j]) {
                        List<Node> union = new ArrayList<>();
                        Queue<Node> queue = new LinkedList<>();

                        queue.add(new Node(i, j));
                        union.add(new Node(i, j));
                        vis[i][j] = true;

                        int totalPopulation = board[i][j];

                        while(!queue.isEmpty()) {
                            Node cur = queue.poll();

                            for(int k = 0; k < 4; k++) {
                                int nx = cur.x + dx[k];
                                int ny = cur.y + dy[k];

                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny]) {
                                    int diff = Math.abs(board[cur.x][cur.y] - board[nx][ny]);
                                    if(diff >= l && diff <= r) {
                                        vis[nx][ny] = true;
                                        queue.add(new Node(nx, ny));
                                        union.add(new Node(nx, ny));
                                        totalPopulation += board[nx][ny];
                                    }
                                }
                            }
                        }

                        if(union.size() > 1) {
                            moved = true;
                            allUnions.put(unionCount, union);
                            populations.add(totalPopulation);
                            unionCount++;
                        }
                    }
                }
            }

            if(!moved) break;

            for(int i = 0; i < unionCount; i++) {
                List<Node> union = allUnions.get(i);
                int avgPopulation = populations.get(i) / union.size();

                for(Node country : union) {
                    board[country.x][country.y] = avgPopulation;
                }
            }

            days++;
        }

        System.out.println(days);
    }
}