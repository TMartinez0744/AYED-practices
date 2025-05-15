//Implementar una función que dado un input de array de caracteres determine si el input es palíndromo.
//Por ejemplo, debe retornar true para ['n','e','u','q','u','e','n'] y false para ['p','e','p','e']

public static boolean isPalindrome(char[] input) {
    Stack<Character> stack = new Stack<>();
    Queue<Character> queue = new Queue<>();

    for (int i = 0; i < input.length / 2; i++) {
        stack.push(input[i]);
        queue.enqueue(input[input.length - 1 - i]);
    }

    while(!stack.isEmpty()) {
        if (stack.pop() != queue.dequeue()) {
            return false; // No coincide → no es palíndromo
        }
        return true; // Todos coinciden → es palíndromo
    }
}