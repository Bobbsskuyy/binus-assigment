package exam.src;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionEvaluator {
 
    private int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }
 
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
 
    // Konversi infix ke postfix menggunakan operator stack (shunting-yard)
    public String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Deque<Character> operatorStack = new ArrayDeque<>();
 
        for (char c : exp.toCharArray()) {
            if (Character.isWhitespace(c)) continue;
 
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    result.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty()) operatorStack.pop();
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && isOperator(operatorStack.peek())
                        && precedence(operatorStack.peek()) >= precedence(c)) {
                    result.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }
        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop());
        }
        return result.toString();
    }
 
    // Evaluasi ekspresi postfix menggunakan operand stack
    public double evaluatePostfix(String postfix) {
        Deque<Double> operandStack = new ArrayDeque<>();
 
        for (char c : postfix.toCharArray()) {
            if (Character.isWhitespace(c)) continue;
 
            if (Character.isDigit(c)) {
                operandStack.push((double) (c - '0'));
            } else if (isOperator(c)) {
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Ekspresi postfix tidak valid.");
                }
                double b = operandStack.pop();
                double a = operandStack.pop();
                double res;
                switch (c) {
                    case '+': res = a + b; break;
                    case '-': res = a - b; break;
                    case '*': res = a * b; break;
                    case '/':
                        if (b == 0) throw new ArithmeticException("Pembagian dengan nol.");
                        res = a / b; break;
                    case '^': res = Math.pow(a, b); break;
                    default: throw new IllegalArgumentException("Operator tidak dikenal: " + c);
                }
                operandStack.push(res);
            }
        }
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Ekspresi postfix tidak valid.");
        }
        return operandStack.pop();
    }
}
