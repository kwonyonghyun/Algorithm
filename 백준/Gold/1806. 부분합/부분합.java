import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int board[] = new int[n];
        for(int i = 0; i < n; i++) {
            board[i] = sc.nextInt();
        }

        int startIdx = 0;
        int endIdx = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while(startIdx < n) {
            while(endIdx < n && sum < k) {
                sum += board[endIdx++];
            }

            if(sum >= k) {
                result = Math.min(result, endIdx - startIdx);
                sum -= board[startIdx];
            } else {
                break;
            }

            startIdx++;
        }

        if(result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}