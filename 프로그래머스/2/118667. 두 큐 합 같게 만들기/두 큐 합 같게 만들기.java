import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        
        for (int num : queue1) {
            list1.add(num);
            sum1 += num;
        }
        
        for (int num : queue2) {
            list2.add(num);
            sum2 += num;
        }
        
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        
        long targetSum = (sum1 + sum2) / 2;
        
        int maxOperations = queue1.length * 3 + queue2.length * 3;
        int operations = 0;
        
        while (sum1 != targetSum && operations <= maxOperations) {
            if (sum1 > targetSum) {
                int value = list1.poll();
                list2.add(value);
                sum1 -= value;
                sum2 += value;
            } else {
                int value = list2.poll();
                list1.add(value);
                sum1 += value;
                sum2 -= value;
            }
            operations++;
        }
        
        return (operations <= maxOperations) ? operations : -1;
    }
}