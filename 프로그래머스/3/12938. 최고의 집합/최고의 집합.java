import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int temp = s/n;
        int rest = s%n;
        int []  answer = new int[n];
        if(rest == 0){
            for(int i=0;i<n;i++){
                answer[i]=temp;
            }
        }else{
            for(int i=0;i<n;i++){
                answer[i]=temp;
            }
            int idx=answer.length-1;
            for(int i=0; i<rest; i++) {
                answer[idx--]++;
                if(idx < 0) idx = n-1;
            }
        }
        if(answer[0]==0){
            return new int[]{-1};
        }else{
            return answer;
        }
        
    }
}