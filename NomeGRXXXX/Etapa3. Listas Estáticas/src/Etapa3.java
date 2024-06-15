import java.util.Stack;

public class Etapa3 {

    public boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> stack = new Stack<>();

        for (Character character : s1)
            if (character == '(')
                stack.push(character);
            else if (character == ')')
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
        return stack.isEmpty();
    }
}
