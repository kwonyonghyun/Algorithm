import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int left=1;
        int right=200_000_000;// 최대 건널  수 있는 사람들
        int answer=0;
        while(left<=right){
            int mid = (left+right)/2;
            if(canCross(stones, k, mid)){
                left=mid+1;
                answer=Math.max(answer, mid);
            }else{
                right=mid-1;
            }
        }
        return answer;
    }
    
    public boolean canCross(int[] stones, int k, int mid){
        int cnt=0;
        boolean flag=false;
        for(int i=0;i<stones.length;i++){
            if(stones[i]< mid){
                cnt++;
            }else{
                cnt=0;
            }
            if(cnt>=k){
                flag=true;
                break;
            }
            
        }
        return !flag;
    }
}