import java.util.*;
class Solution {
    public boolean isValid(String value){
        for(int i=0;i<value.length();i++){
            if(!Character.isLetter(value.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public int solution(String str1, String str2) {
        int answer = 0;
        TreeMap<String, Integer> union = new TreeMap<>();
        TreeMap<String, Integer> inter = new TreeMap<>();
        TreeMap<String, Integer> AMap = new TreeMap<>();
        TreeMap<String, Integer> BMap = new TreeMap<>();
        HashSet<String> set = new HashSet<>();
        
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        for(int i=0;i<str1.length()-1;i++){
            String temp = str1.substring(i, i+2);
            if(isValid(temp)){
                AMap.put(temp, AMap.getOrDefault(temp, 0)+1);
                set.add(temp);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            String temp = str2.substring(i, i+2);
            if(isValid(temp)){
                BMap.put(temp, BMap.getOrDefault(temp, 0)+1);
                set.add(temp);
            }
        }
        for(String value:set){
            if(AMap.containsKey(value) && BMap.containsKey(value)){
                union.put(value, Math.max(AMap.get(value),BMap.get(value)));
                inter.put(value, Math.min(AMap.get(value), BMap.get(value)));
            }else if(AMap.containsKey(value)){
                union.put(value, AMap.get(value));
            }else if(BMap.containsKey(value)){
                union.put(value, BMap.get(value));
            }
        }
        
        int unionResult=0;
        int interResult=0;
        for(String key:union.keySet()){
            unionResult+=union.get(key);
        }
        for(String key:inter.keySet()){
            interResult+=inter.get(key);
        }
        System.out.println(interResult+" "+unionResult);
        if(unionResult==0){
            return 65536;
        }
        
        return (int)Math.floor(65536*(double)interResult/unionResult);
    }
}

// str1, str2 두 문자열이 들어온다
//입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 상만 유효하고, 기타 공백이나 특수 문자가 들어있는 경우에는 그 글자 쌍을 버린다.
//같은 원소가 포함될 수도 있다.