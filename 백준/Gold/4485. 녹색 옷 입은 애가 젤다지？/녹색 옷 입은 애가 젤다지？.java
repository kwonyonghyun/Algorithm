import java.util.*;

class Pair{
    int x;
    int y;
    int cost;
    Pair(int x,int y, int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
}

public class Main{
    static int[] dx=new int[]{-1,0,1,0};
    static int[] dy=new int[]{0,-1,0,1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int idx=1;
        while(true){
            int n=sc.nextInt();
            if(n==0){
                break;
            }
            int board[][] = new int[n+1][n+1];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    board[i][j]=sc.nextInt();
                }
            }
            int dist[][] = new int[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0]=board[0][0];
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                    (Pair a, Pair b)->{
                        return a.cost-b.cost;
                    }
            );
            pq.add(new Pair(0,0,board[0][0]));

            while(!pq.isEmpty()){
                Pair curPair=pq.poll();
                int curX=curPair.x;
                int curY=curPair.y;
                int curCost=curPair.cost;

                if(dist[curX][curY]<curCost){
                    continue;
                }

                for(int i=0;i<4;i++){
                    int nx=curX+dx[i];
                    int ny=curY+dy[i];
                    if(nx<0||nx>=n||ny<0||ny>=n){
                        continue;
                    }

                    if(curCost+board[nx][ny]<dist[nx][ny]){
                        dist[nx][ny]=curCost+board[nx][ny];
                        pq.add(new Pair(nx, ny, dist[nx][ny]));
                    }
                }
            }
            System.out.println("Problem "+idx++ +": "+dist[n-1][n-1]);
        }
    }
}