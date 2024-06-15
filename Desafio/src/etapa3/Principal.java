package etapa3;
import java.util.Stack;

public class Principal {

    public static void main(String[] args) {

        StaticList<Integer> lista = new StaticList<>(20);
        int x = 0;
        int y = 1;
        lista.insert(x, 0);
        lista.insert(y, 1);
        lista.insert(x, 2);
        lista.insert(y, 3);
        lista.insert(x, 4);

        int result1 = lista.contaElementos(x);
        int result2 = lista.contaElementos(y);
        System.out.println("Número de ocorrências do número " + x + " na lista: " + result1);
        System.out.println("Número de ocorrências do número " + y + " na lista: " + result2);

        Etapa3 etapa3 = new Etapa3();
        Stack<Character> expression1 = new Stack<>();
        Stack<Character> expression2 = new Stack<>();

        System.out.println("\nVerificar se as expressões estão com os parênteses agrupados corretamente:");
        expression1.push('A');
        expression1.push('+');
        expression1.push('B');
        expression1.push('(');

        expression2.push('(');
        expression2.push('A');
        expression2.push('+');
        expression2.push('B');
        expression2.push(')');

        System.out.println("Expressão 1: " + etapa3.checkBrackets(expression1));
        System.out.println("Expressão 2: " + etapa3.checkBrackets(expression2));
    }
}