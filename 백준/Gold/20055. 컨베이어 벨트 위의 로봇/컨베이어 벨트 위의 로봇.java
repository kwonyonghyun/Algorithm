import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static int board[];
    public static boolean vis[];
    static int cnt = 0;
    static int startIdx = 0;
    static int endIdx = 0;
    static boolean flag = false;

    public static void first() {
        int tmp = board[2*n-1];
        for (int i = 2*n-1; i > 0; i--) {
            board[i] = board[i-1];
        }
        board[0] = tmp;

        for (int i = n-1; i > 0; i--) {
            vis[i] = vis[i-1];
        }

        vis[0] = false;
        vis[n-1] = false;
    }

    public static void second() {
        for (int i = n-1; i > 0; i--) {
            if(vis[i-1] && !vis[i] && board[i] > 0) {
                vis[i-1] = false;
                vis[i] = true;
                board[i]--;
                vis[n-1] = false;
            }
        }
    }

    public static void third() {
        if(board[0] > 0) {
            vis[0] = true;
            board[0]--;
        }
    }

    public static boolean fourth() {
        int result = 0;
        for (int i = 0; i < 2*n; i++) {
            if(board[i] == 0) result++;
        }
        return result >= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        board = new int[2*n];
        vis = new boolean[n];

        for (int i = 0; i < 2*n; i++) {
            board[i] = sc.nextInt();
        }

        while (!flag) {
            cnt++;
            first();
            second();
            third();
            flag = fourth();
        }

        System.out.println(cnt);
    }
}