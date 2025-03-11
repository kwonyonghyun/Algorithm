import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        boolean result = canMakeT(T, S);
        if (result) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    private static boolean canMakeT(String T, String S) {
        if (T.equals(S)) {
            return true;
        }

        if (T.length() <= 1) {
            return false;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            String prev = T.substring(0, T.length() - 1);
            if (canMakeT(prev, S)) {
                return true;
            }
        }

        if (T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(T.substring(1));
            String prev = sb.reverse().toString();
            if (canMakeT(prev, S)) {
                return true;
            }
        }

        return false;
    }
}