// Write a filter InfixToPostfix that converts an arithmetic expression from infix to postfix

private static String infixToPostfix(String input) {
    Stack<String> operands = new Stack<>();
    Stack<String> operators = new Stack<>();

    String[] inputValues = input.split(" ");

    for (String value : inputValues) {
        if (value.equals("(")) {
            // No hacer nada
        } else if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
            operators.push(value);
        } else if (value.equals(")")) {
            String operator = operators.pop();
            String value2 = operands.pop();
            String value1 = operands.pop();

            String subExp = value1 + " " + value2 + " " + operator;
            operands.push(subExp);
        } else {
            operands.push(value);
        }
    }

    return operands.pop();
}
