import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        LinkedList<String> cache = new LinkedList<>();
        
        for (String city : cities) {
            String lowerCity = city.toLowerCase();
            
            if (cache.contains(lowerCity)) {
                cache.remove(lowerCity);
                cache.addLast(lowerCity);
                answer += 1;
            } 
            else {
                if (cache.size() >= cacheSize) {
                    cache.removeFirst();
                }
                cache.addLast(lowerCity);
                answer += 5;
            }
        }
        
        return answer;
    }
}