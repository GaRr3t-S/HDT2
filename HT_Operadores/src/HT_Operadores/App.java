package HT_Operadores;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Evaluar expresiones postfix");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");
            String opcion = input.nextLine();
            switch (opcion) {
                case "1":
                    try {
                        File file = new File("datos.txt");
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String expression = scanner.nextLine();
                            int result = PostfixEvaluator.evaluatePostfix(expression);
                            System.out.println("Resultado: " + result);  
                        }
                        scanner.close();
                    } catch (FileNotFoundException e){
                        System.out.println("ERROR: Archivo no encontrado");
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        }
        input.close();
    }
}