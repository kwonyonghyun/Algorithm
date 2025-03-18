import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        ArrayList<Integer> list  = new ArrayList<>();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            list.add(b);
        }
        Stack<Integer> st = new Stack<>();
        int cnt=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==0){
                st.clear();
            }else if(st.isEmpty() || list.get(i)>st.peek()){
                st.push(list.get(i));
                cnt++;
            }else if(!st.isEmpty() && list.get(i)<st.peek()){
                st.pop();
                i--;
            }
        }
        System.out.println(cnt);
    }
}