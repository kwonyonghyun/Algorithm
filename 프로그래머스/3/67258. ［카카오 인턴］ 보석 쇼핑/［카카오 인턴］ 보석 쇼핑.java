import java.util.*;
class Solution {
   public int[] solution(String[] gems) {
       int[] answer = new int[]{0,0};
       HashSet<String> set = new HashSet<>();
       for(int i=0;i<gems.length;i++){
           set.add(gems[i]);
       }
       int start=0;
       int end=0;
       int result=Integer.MAX_VALUE;
       HashMap<String, Integer> map = new HashMap<>();
       
       map.put(gems[0], 1);
       
       while(end < gems.length){
           if(map.keySet().size() == set.size()){
               if(result > end-start+1){
                   result = end-start+1;
                   answer[0] = start+1;
                   answer[1] = end+1;
               }
               
               if(map.get(gems[start]) == 1){
                   map.remove(gems[start]);
               } else {
                   map.put(gems[start], map.get(gems[start])-1);
               }
               start++;
           } 
           else {
               end++;
               if(end == gems.length) break;
               map.put(gems[end], map.getOrDefault(gems[end], 0)+1);
           }
       }
       
       return answer;
   }
}