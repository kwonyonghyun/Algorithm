
import java.util.*;

public class Main{
    public static int first(int[][] board){
        int result=Integer.MIN_VALUE;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length-3;j++){
                result=Math.max(board[i][j]+board[i][j+1]+board[i][j+2]+board[i][j+3], result);
            }
        }
        for(int i=0;i<board.length-3;i++){
            for(int j=0;j<board[i].length;j++){
                result=Math.max(board[i][j]+board[i+1][j]+board[i+2][j]+board[i+3][j], result);
            }
        }
        return result;
    }

    public static int second(int[][] board){
        int result=Integer.MIN_VALUE;
        for(int i=0;i<board.length-1;i++){
            for(int j=0;j<board[i].length-1;j++){
                result=Math.max(result, board[i][j]+board[i][j+1]+board[i+1][j]+board[i+1][j+1]);
            }
        }
        return result;
    }

    public static int third(int[][] board){
        int result=Integer.MIN_VALUE;
        for(int i=0;i<board.length-2;i++){
            for(int j=0;j<board[i].length-1;j++){
                result=Math.max(board[i][j]+board[i+1][j]+board[i+2][j]+board[i+2][j+1], result);
                result=Math.max(board[i][j]+board[i+1][j]+board[i+2][j]+board[i][j+1], result);
                result=Math.max(board[i][j+1]+board[i+1][j+1]+board[i+2][j+1]+board[i+2][j], result);
                result=Math.max(board[i][j+1]+board[i+1][j+1]+board[i+2][j+1]+board[i][j], result);
            }
        }
        for(int i=0;i<board.length-1;i++){
            for(int j=0;j<board[i].length-2;j++){
                result=Math.max(result, board[i][j]+board[i][j+1]+board[i][j+2]+board[i+1][j+2]);
                result=Math.max(result, board[i][j]+board[i][j+1]+board[i][j+2]+board[i+1][j]);
                result=Math.max(result, board[i+1][j]+board[i+1][j+1]+board[i+1][j+2]+board[i][j+2]);
                result=Math.max(result, board[i+1][j]+board[i+1][j+1]+board[i+1][j+2]+board[i][j]);
            }
        }
        return result;
    }

    public static int fourth(int[][] board){
        int result=Integer.MIN_VALUE;
        for(int i=0;i<board.length-2;i++){
            for(int j=0;j<board[i].length-1;j++){
                result=Math.max(result, board[i][j]+board[i+1][j]+board[i+1][j+1]+board[i+2][j+1]);
                result=Math.max(result, board[i][j+1]+board[i+1][j+1]+board[i+1][j]+board[i+2][j]);
            }
        }
        for(int i=0;i<board.length-1;i++){
            for(int j=0;j<board[i].length-2;j++){
                result=Math.max(result, board[i][j]+board[i][j+1]+board[i+1][j+1]+board[i+1][j+2]);
                result=Math.max(result, board[i+1][j]+board[i+1][j+1]+board[i][j+1]+board[i][j+2]);
            }
        }
        return result;
    }

    public static int fifth(int[][] board){
        int result=Integer.MIN_VALUE;
        for(int i=0;i<board.length-2;i++){
            for(int j=0;j<board[i].length-1;j++){
                result=Math.max(result, board[i][j]+board[i+1][j]+board[i+2][j]+board[i+1][j+1]);
                result=Math.max(result, board[i][j+1]+board[i+1][j+1]+board[i+2][j+1]+board[i+1][j]);
            }
        }

        for(int i=0;i<board.length-1;i++){
            for(int j=0;j<board[i].length-2;j++){
                result=Math.max(result, board[i][j]+board[i][j+1]+board[i][j+2]+board[i+1][j+1]);
                result=Math.max(result, board[i+1][j]+board[i+1][j+1]+board[i+1][j+2]+board[i][j+1]);
            }
        }
        return result;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] board = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=sc.nextInt();
            }
        }
        int result=Integer.MIN_VALUE;
        result=Math.max(result, first(board));

        result=Math.max(result, second(board));

        result=Math.max(result, third(board));

        result=Math.max(result, fourth(board));

        result=Math.max(result, fifth(board));
        System.out.println(result);
    }
}