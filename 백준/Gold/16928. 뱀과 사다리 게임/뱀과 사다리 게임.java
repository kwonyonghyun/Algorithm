import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean vis[] = new boolean[101];
        int dist[] = new int[101];

        HashMap<Integer, Integer> ladders = new HashMap<>();
        HashMap<Integer, Integer> snakes = new HashMap<>();

        for(int i=0;i<n;i++){
            ladders.put(sc.nextInt(), sc.nextInt());
        }
        for(int i=0;i<m;i++){
            snakes.put(sc.nextInt(), sc.nextInt());
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);

        for(int i=1;i<=100;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        vis[1]=true;
        dist[1]=0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=1;i<=6;i++){
                int next=cur+i;
                if(cur+i>100||vis[next]){
                    continue;
                }
                if(ladders.containsKey(next)){
                    next = ladders.get(next);
                }else if(snakes.containsKey(next)){
                    next = snakes.get(next);
                }

                if(!vis[next]){
                    vis[next]=true;
                    dist[next]=dist[cur]+1;
                    queue.add(next);
                }
            }
        }
        System.out.println(dist[100]);
    }
}