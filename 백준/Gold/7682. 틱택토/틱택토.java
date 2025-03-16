import java.util.*;

public class Main {
    public static boolean isValid(char[][] board) {
        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'O') {
                    oCount++;
                } else if (board[i][j] == 'X') {
                    xCount++;
                }
            }
        }
        if (xCount - 1 == oCount || oCount == xCount) {
            return true;
        }
        return false;
    }

    public static boolean isWin(char[][] board, char target) {
        for (int i = 0; i < 3; i++) {
            int targetCount = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == target) {
                    targetCount++;
                }
            }
            if (targetCount == 3) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            int targetCount = 0;
            for (int i = 0; i < 3; i++) {
                if (board[i][j] == target) {
                    targetCount++;
                }
            }
            if (targetCount == 3) {
                return true;
            }
        }

        int targetCount = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == target) {
                targetCount++;
            }
        }
        if (targetCount == 3) {
            return true;
        }

        targetCount = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i] == target) {
                targetCount++;
            }
        }
        if (targetCount == 3) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }
            char board[][] = new char[3][3];
            int xCount = 0;
            int oCount = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = input.charAt(3 * i + j);
                    if(board[i][j] == 'X') xCount++;
                    else if(board[i][j] == 'O') oCount++;
                }
            }

            boolean xWin = isWin(board, 'X');
            boolean oWin = isWin(board, 'O');

            if (xWin && oWin) {
                System.out.println("invalid");
                continue;
            }

            if (oCount + xCount == 9) {
                if (xCount - oCount == 1) {
                    if (oWin) {
                        System.out.println("invalid");
                    } else {
                        System.out.println("valid");
                    }
                } else {
                    System.out.println("invalid");
                }
            } else {
                if (xWin && xCount - oCount == 1) {
                    System.out.println("valid");
                } else if (oWin && xCount == oCount) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            }
        }
    }
}