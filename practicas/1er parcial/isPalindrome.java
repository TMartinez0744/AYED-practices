//Explicar cómo se podría implementar una función isPalindrome() utilizando un Stack y una Queue.
// Mencionar y justificar el orden de complejidad de esa implementación

import java.util.*;

public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Cargar caracteres en la pila y en la cola
        for (char c : s.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // Comparar caracteres desde la pila y la cola
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false; // No coincide → no es palíndromo
            }
        }

        return true; // Todos coinciden → es palíndromo
    }

    // Para probarlo
    public static void main(String[] args) {
        String test1 = "radar";
        String test2 = "hello";

        System.out.println(test1 + " → " + isPalindrome(test1)); // true
        System.out.println(test2 + " → " + isPalindrome(test2)); // false
    }
}
//Esto es O(n) porque el algoritmo recorre todos los elementos del arreglo una sola vez,
    //haciendo operaciones simples por cada uno.  el número total de operaciones crece linealmente
    // con la cantidad de elementos (n).
//No hay bucles ni recursión tampoco.
