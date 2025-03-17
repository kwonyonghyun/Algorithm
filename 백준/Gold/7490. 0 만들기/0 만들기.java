import java.util.*;

public class Main{

    public static int getResult(String input){
        StringTokenizer st = new StringTokenizer(input, "+-", true);
        int num = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            if(st.nextToken().equals("+")){
                num+=Integer.parseInt(st.nextToken());
            }else{
                num-=Integer.parseInt(st.nextToken());
            }
        }
        return num;
    }

    public static void dfs(int n,int depth, TreeSet<String> result, StringBuilder builder){
        if(n==depth){
            String temp = builder.toString().replaceAll(" ","");
            if(getResult(temp)==0){
                result.add(builder.toString());
            }
            return;
        }

        builder.append('+');
        builder.append(depth+1);
        dfs(n, depth+1, result, builder);
        builder.deleteCharAt(builder.length()-1);
        builder.deleteCharAt(builder.length()-1);

        builder.append('-');
        builder.append(depth+1);
        dfs(n, depth+1, result, builder);
        builder.deleteCharAt(builder.length()-1);
        builder.deleteCharAt(builder.length()-1);

        builder.append(' ');
        builder.append(depth+1);
        dfs(n, depth+1, result, builder);
         builder.deleteCharAt(builder.length()-1);
        builder.deleteCharAt(builder.length()-1);


    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            TreeSet<String> result=new TreeSet<>();
            StringBuilder builder = new StringBuilder("1");
            dfs(n,1, result, builder);
            for(String s:result){
                System.out.println(s);
            }
            System.out.println();
        }


    }
}