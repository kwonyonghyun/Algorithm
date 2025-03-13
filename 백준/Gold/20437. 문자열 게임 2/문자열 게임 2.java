import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            String W = sc.next();
            int k = sc.nextInt();

            HashMap<Character, ArrayList<Integer>> positions = new HashMap<>();

            for (int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                positions.putIfAbsent(c, new ArrayList<>());
                positions.get(c).add(i);
            }

            int minLength = Integer.MAX_VALUE;
            int maxLength = -1;

            for (char c : positions.keySet()) {
                ArrayList<Integer> posList = positions.get(c);

                if (posList.size() >= k) {
                    for (int i = 0; i <= posList.size() - k; i++) {
                        int startPos = posList.get(i);
                        int endPos = posList.get(i + k - 1);
                        int length = endPos - startPos + 1;

                        minLength = Math.min(minLength, length);
                        maxLength = Math.max(maxLength, length);
                    }
                }
            }

            if (minLength == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(minLength + " " + maxLength);
            }
        }
    }
}