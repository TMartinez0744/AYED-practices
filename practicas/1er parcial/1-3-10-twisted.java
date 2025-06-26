private static String postfixToInfix(String input) {
    Stack<String> stack = new Stack<>();
    String[] tokens = input.split(" ");

    for (String token : tokens) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            String operand2 = stack.pop();
            String operand1 = stack.pop();
            String subExp = "( " + operand1 + " " + token + " " + operand2 + " )";
            stack.push(subExp);
        } else {
            stack.push(token);
        }
    }

    return stack.pop();
}
