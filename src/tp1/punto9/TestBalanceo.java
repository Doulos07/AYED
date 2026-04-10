package tp1.punto9;
import java.util.Stack;

public class TestBalanceo {

    public boolean estaBalanceado(String expresion) {
        if (expresion == null) return true;

        Stack<Character> stack = new Stack<>();

        for (char c : expresion.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);

            } else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) return false;

                char apertura = stack.pop();

                if (c == ')' && apertura != '(') return false;
                if (c == ']' && apertura != '[') return false;
                if (c == '}' && apertura != '{') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        TestBalanceo t = new TestBalanceo();

        System.out.println(t.estaBalanceado("{()[()]}")); // true
        System.out.println(t.estaBalanceado("{()[)]}"));  // false
        System.out.println(t.estaBalanceado("((("));      // false
    }
}