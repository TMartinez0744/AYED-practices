
//Write a program that takes from standard input an expression without right parentheses
    //and prints the equivalent infix expression with the parentheses inserted

import java.util.Scanner;

public class InfixCloser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder expression = new StringBuilder();

        int openCount = 0;

        while (scanner.hasNext()) {
            String elem = scanner.next();

            if (elem.equals("(")) {
                openCount++;
            }
            expression.append(elem).append(" ");
        }

        // Agregar los paréntesis derechos faltantes
        for (int i = 0; i < openCount; i++) {
            expression.append(") ");
        }

        // Mostrar la expresión completa
        System.out.println(expression.toString().trim());
    }
}
