package Atividade_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculadora {
    public static void main(String[] args) throws Exception {
        Cabeçalho.imprimir();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        double r = evaluateRPN(expr);
        System.out.println(r);
    }

    public static double evaluateRPN(String expr) {
        if (expr == null || expr.trim().isEmpty()) throw new IllegalArgumentException("Expressão vazia");
        Deque<Double> st = new ArrayDeque<>();
        String[] toks = expr.trim().split("\\s+");
        for (String t : toks) {
            if (isNumber(t)) {
                st.push(Double.parseDouble(t));
            } else if (isOp(t)) {
                if (st.size() < 2) throw new IllegalArgumentException("Operandos insuficientes para '" + t + "'");
                double b = st.pop();
                double a = st.pop();
                double r;
                switch (t) {
                    case "+": r = a + b; break;
                    case "-": r = a - b; break;
                    case "*": r = a * b; break;
                    case "/":
                        if (b == 0.0) throw new ArithmeticException("Divisão por zero");
                        r = a / b;
                        break;
                    default: throw new IllegalArgumentException("Operador inválido: " + t);
                }
                st.push(r);
            } else {
                throw new IllegalArgumentException("Token inválido: " + t);
            }
        }
        if (st.size() != 1) throw new IllegalArgumentException("Expressão malformada");
        return st.pop();
    }

    private static boolean isOp(String t) {
        return t.length() == 1 && (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/"));
    }

    private static boolean isNumber(String t) {
        try {
            Double.parseDouble(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
