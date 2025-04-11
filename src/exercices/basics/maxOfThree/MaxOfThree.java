package exercices.basics.maxOfThree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MaxOfThree {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Insira três números inteiros: ");
            System.out.println("Primeiro número: ");

            try {
                int firstNumber = input.nextInt();
                System.out.println("Segundo número: ");
                int secondNumber = input.nextInt();
                System.out.println("Terceiro número: ");
                int thirdNumber = input.nextInt();
                int[] inputNumbers = {firstNumber, secondNumber, thirdNumber};
                System.out.println("O maior número entre " + inputNumbers[0] + ", " + inputNumbers[1] + ", " + inputNumbers[2] + " é: " + findLargest(inputNumbers));
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
            }
            System.out.println("--------------------------------------------------------");

            System.out.println("Deseja continuar? s/n");
            String response = input.next().trim().toLowerCase();
            if (!response.equals("s")) {
                System.out.println("Encerrando o programa...");
                input.close();
                break;
            }
        }

    }

    public static int findLargest(int[] numbers) {

        int largest = numbers[0];
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }
        }

        return largest;
    }

}
