package HT_Operadores;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {
    public static void main(String[] args){
        try {
            File file = new File("datos.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String expression = scanner.nextLine();
                int result = evaluatePostfix(expression);
                System.out.println("Resultado: " + result);  

            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("ERROR: Archivo no encontrado");
            e.printStackTrace();
        }
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] elements = expression.split(" ");
        for (String element : elements){
            if (isOperator(element)){
                int operandB = stack.pop();
                int operandA = stack.pop();
                int result = performOperation(operandA, operandB, element);
                stack.push(result);
            } else{
                stack.push(Integer.parseInt(element));
            }
        }
        return stack.pop();
    }

    public static boolean isOperator(String element){
        return element.equals("+") || element.equals("*") || element.equals("/");
    }

    public static int performOperation(int operandA, int operandB, String operator){
        switch (operator) {
            case "+":
                return operandA + operandB;
            case "-":
                return operandA - operandB;
            case "*":
                return operandA * operandB;
            case "/":
                if(operandB !=0){
                    return operandA / operandB;
                } else {
                    throw new IllegalArgumentException("ERROR: la división por cero no está permitida");
                }
            default:
                throw new IllegalArgumentException("ERROR: operador desconocido" + operator);
        }
    } 
}