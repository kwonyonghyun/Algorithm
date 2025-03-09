import java.util.*;
class Pair{
    public int count;
    public int number;
    public Pair(){
        this.count=0;
        this.number=0;
    }
    
    public Pair(int number, int count){
        this.count=count;
        this.number=number;
    }
    public void increase(){
        this.count++;
    }
    
    public int getCount(){
        return this.count;
    }
}
class Solution {
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s,"{},",false);
        HashMap<Integer, Pair> map = new HashMap<>();
        TreeSet<Pair> set = new TreeSet<Pair>((Pair a,Pair b)->{
           return b.count - a.count;
        });
        while(st.hasMoreTokens()){
            Integer token = Integer.parseInt(st.nextToken());
            if(map.containsKey(token)){
                map.get(token).increase();
            }else{
                map.put(token, new Pair(token,1));
            }
        }
        for(Integer key:map.keySet()){
            set.add(map.get(key));
        }
        int[] result = new int[set.size()];
        int idx=0;
        for(Pair value:set){
            result[idx++]=value.number;
        }
        return result;
    }
}