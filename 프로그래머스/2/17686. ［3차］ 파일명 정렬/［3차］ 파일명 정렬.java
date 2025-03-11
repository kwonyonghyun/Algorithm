import java.util.*;
class Node{
    public String head;
    public int number;
    public String tail;
    public int idx;
    
    public Node(String head, int number, String tail, int idx){
        this.head=head;
        this.number=number;
        this.tail=tail;
        this.idx=idx;
    }
}
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        TreeSet<Node> set = new TreeSet<Node>((Node a, Node b)->{
            if((a.head).equalsIgnoreCase(b.head) && a.number == b.number){
                return a.idx - b.idx;
            }
            if((a.head).equalsIgnoreCase(b.head)){
                return a.number-b.number;
            }
            return (a.head).compareTo(b.head);
        });
        
        for(int i=0;i<files.length;i++){
            boolean startFlag=false;
            int startIdx=0;
            int endIdx=files[i].length(); 
            boolean endFlag=false;
            
            for(int j=0;j<files[i].length();j++){
                if(!startFlag && Character.isDigit(files[i].charAt(j))){
                    startFlag=true;
                    startIdx=j;
                }else if(startFlag && !endFlag && !Character.isDigit(files[i].charAt(j))){
                    endFlag=true;
                    endIdx=j;
                    break;
                }
            }
            
            String head=files[i].substring(0, startIdx).toLowerCase();
            int number =Integer.parseInt(files[i].substring(startIdx, endIdx));
            String tail = files[i].substring(endIdx);
            
            set.add(new Node(head, number, tail, i));
        }
        
        int idx = 0;
        for(Node node : set) {
            answer[idx++] = files[node.idx];
        }
        
        return answer;
    }
}