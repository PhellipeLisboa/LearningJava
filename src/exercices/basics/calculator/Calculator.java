package exercices.basics.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("Digite o primeiro número: ");
            int firstNumber = input.nextInt();
            System.out.println("Digite o segundo número: ");
            int secondNumber = input.nextInt();
            System.out.println("Escolha uma operação: (+, -, *, /)");
            String operation = input.next();

            switch (operation) {
                case "+":
                    System.out.println("Resultado: " + firstNumber + " " + operation + " " + secondNumber + " = " + add(firstNumber, secondNumber));
                    break;
                case "-":
                    System.out.println("Resultado: " + firstNumber + " " + operation + " " + secondNumber + " = " + subtract(firstNumber, secondNumber));
                    break;
                case "*":
                    System.out.println("Resultado: " + firstNumber + " " + operation + " " + secondNumber + " = " + multiply(firstNumber, secondNumber));
                    break;
                case "/":
                    try {
                        System.out.println("Resultado: " + firstNumber + " " + operation + " " + secondNumber + " = " + divide(firstNumber, secondNumber));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Operação inválida!");
            }

            System.out.println("Deseja continuar? s/n");
            String response = input.next();

            if (!response.equalsIgnoreCase("s")){
                input.close();
                break;
            }
        }


    }

    public static int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static float divide(int firstNumber, int secondNumber) throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("Erro: Divisão por zero.");
        } else {
            return (float) firstNumber / secondNumber;
        }
    }

}
