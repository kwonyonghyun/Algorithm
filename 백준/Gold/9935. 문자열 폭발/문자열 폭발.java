import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String target = sc.next();

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
            if (list.size() >= target.length()) {
                boolean match = true;
                for (int j = 0; j < target.length(); j++) {
                    if (list.get(list.size() - target.length() + j) != target.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    for (int j = 0; j < target.length(); j++) {
                        list.removeLast();
                    }
                }
            }
        }

        if (list.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : list) {
                result.append(c);
            }
            System.out.println(result.toString());
        }

        sc.close();
    }
}