import java.util.NoSuchElementException;

//Implementar una función que dado un input de array de caracteres determine si los paréntesis se
//encuentran correctamente balanceados. Por ejemplo, debe  devolver true para “()()” y false para “(()”

//no solo debo chequer que las cantidades sean iguales, sino q sea coherente, osea )( no es correcto


public static boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c == '(') {
            stack.push(c);
        } else if (c == ')') {
            if (stack.isEmpty()){
                return false;
            }
            stack.pop();
        }
    }

    return stack.isEmpty();
}

public static boolean isBalanced(char[] input) {    //casteo array de chars a string
    return isBalanced(new String(input));
}



"""public static boolean isBalanced(char[] input){
    Stack<E> stack = new Stack<>();

    for(int i = 0; i < input.length; i++){
        if(input[i] == "("){
            stack.push("(");
        }

        else if (input[i] == ")") {
            String last;
            try{
                last = stack.pop();
            }
            catch(NoSuchElementException e){
                return false;
            }
        }
    }
    if(stack.isEmpty()){
        return true;
    }
    return false;

}"""