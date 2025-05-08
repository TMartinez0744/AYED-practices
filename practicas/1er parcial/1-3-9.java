//Write a program that takes from standard input an expression without left parentheses
    // and prints the equivalent infix expression with the parentheses inserted

import java.util.Stack;
import java.util.Scanner;

public class InfixCompleter {
    public static void main(String[] args) {

        Stack<String> operators = new Stack<>();
        Stack<String> numbers = new Stack<>();

        // Scanner para leer la entrada
        Scanner scanner = new Scanner(System.in);

        // Leemos la entrada token por token
        while (scanner.hasNext()) {
            String element = scanner.next();

            if (element.equals("+") || element.equals("-") ||
                    element.equals("*") || element.equals("/")) {
                operators.push(element);
            }

            else if (element.equals(")")) {
                // Sacamos los dos operandos del stack
                String val2 = numbers.pop(); // el segundo operando (último apilado)
                String val1 = numbers.pop(); // el primero

                String op = operators.pop();
                String expr = "( " + val1 + " " + op + " " + val2 + " )";
                numbers.push(expr);
            }

            // Si no es operador ni paréntesis derecho, asumimos que es un número (operando)
            else {
                numbers.push(element);
            }
        }

        System.out.println(numbers.pop());
    }
}
