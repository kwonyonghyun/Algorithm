import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[10_001][3];
        dp[1][0]=1;

        dp[2][0]=1;
        dp[2][1]=1;

        dp[3][0]=1;
        dp[3][1]=1;
        dp[3][2]=1;

        dp[4][0]=1;
        dp[4][1]=2;
        dp[4][2]=1;

        for(int j=5;j<=10_000;j++){
            dp[j][0]=dp[j-1][0];
            dp[j][1]=dp[j-2][0]+dp[j-2][1];
            dp[j][2]=dp[j-3][0]+dp[j-3][1]+dp[j-3][2];
        }
        for(int i=0;i<n;i++){
            int input=sc.nextInt();
            System.out.println(dp[input][0]+dp[input][1]+dp[input][2]);
        }
    }
}