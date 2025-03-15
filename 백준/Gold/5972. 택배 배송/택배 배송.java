import java.util.*;

class Pair{
    int to;
    int cost;

    Pair(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<Pair>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int cost=sc.nextInt();
            graph[a].add(new Pair(b,cost));
            graph[b].add(new Pair(a,cost));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                (Pair a, Pair b)->{
                    return a.cost-b.cost;
                }
        );
        dist[1]=0;
        pq.add(new Pair(1, dist[1]));

        while(!pq.isEmpty()){
            Pair cur = pq.poll();

            if(cur.cost > dist[cur.to]){
                continue;
            }

            for(Pair next: graph[cur.to]){
                int newDist = dist[cur.to] + next.cost;
                if(newDist < dist[next.to]){
                    dist[next.to] = newDist;
                    pq.add(new Pair(next.to, dist[next.to]));
                }
            }
        }
        System.out.println(dist[n]);
    }
}