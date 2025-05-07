//Write a program that takes from standard input an expression without left parentheses
    // and prints the equivalent infix expression with the parentheses inserted

import java.util.Stack;
import java.util.Scanner;

public class InfixCompleter {
    public static void main(String[] args) {
        // Stack para guardar los operadores: +, -, *, /
        Stack<String> ops = new Stack<>();

        // Stack para guardar operandos: números o expresiones parciales
        Stack<String> vals = new Stack<>();

        // Scanner para leer la entrada estándar (puede ser System.in o entrada redirigida)
        Scanner scanner = new Scanner(System.in);

        // Leemos la entrada token por token (puede ser números, operadores o ")")
        while (scanner.hasNext()) {
            String token = scanner.next();

            // Si es un operador, lo guardamos en el stack de operadores
            if (token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/")) {
                ops.push(token);
            }

            // Si es un paréntesis derecho, es hora de combinar una subexpresión
            else if (token.equals(")")) {
                // Sacamos los dos operandos del stack
                String val2 = vals.pop(); // el segundo operando (último apilado)
                String val1 = vals.pop(); // el primero

                // Sacamos el operador correspondiente
                String op = ops.pop();

                // Creamos la subexpresión con paréntesis: ( val1 op val2 )
                String expr = "( " + val1 + " " + op + " " + val2 + " )";

                // Volvemos a apilar esta subexpresión como un valor
                vals.push(expr);
            }

            // Si no es operador ni paréntesis derecho, asumimos que es un número (operando)
            else {
                vals.push(token);
            }
        }

        // Cuando termina el input, en el stack de valores queda la expresión final
        System.out.println(vals.pop());
    }
}
