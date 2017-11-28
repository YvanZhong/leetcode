package stack;

import java.util.LinkedList;
import java.util.List;

public class BaseballGame {
    public int calPoints(String[] ops) {
        LinkedList<Integer> rounds = new LinkedList<>();
        int sum = 0;

        for (String op: ops) {
            switch (op) {
                case "C":
                    sum -= rounds.removeLast();
                    break;

                case "D":
                    rounds.add(rounds.peekLast() * 2);
                    sum += rounds.peekLast();
                    break;

                case "+":
                    rounds.add(rounds.peekLast() + rounds.get(rounds.size() - 2));
                    sum += rounds.peekLast();
                    break;

                default:
                    rounds.add(Integer.parseInt(op));
                    sum += rounds.peekLast();
                    break;
            }
        }

        return sum;
    }
}
