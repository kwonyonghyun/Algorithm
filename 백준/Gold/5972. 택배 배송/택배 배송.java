import java.util.*;

class Pair{
    int to;
    int cost;

    Pair(int to, int cost){
        this.to=to;
        this.cost =cost;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<Pair>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            graph[a].add(new Pair(b,c));
            graph[b].add(new Pair(a,c));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                (Pair a, Pair b)-> {
                    return a.cost - b.cost;
                }
        );

        pq.add(new Pair(1,0));
        dist[1]=0;

        while(!pq.isEmpty()){
            Pair cur = pq.poll();

            if(dist[cur.to] < cur.cost){
                continue;
            }

            for(Pair next: graph[cur.to]){
                if(dist[next.to]> dist[cur.to]+next.cost){
                    dist[next.to]=dist[cur.to]+next.cost;
                    pq.add(new Pair(next.to, dist[next.to]));
                }
            }
        }
        System.out.print(dist[n]);
    }
}