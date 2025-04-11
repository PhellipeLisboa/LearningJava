package exercices.basics.evenOrOdd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("Digite um número inteiro para verificar se ele é par ou ímpar: ");
            System.out.println("OBS: Digite 0 para encerrar o programa. ");
            int number = 0;

            try {
                number = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input inválido. Digite um número inteiro!");
                input.nextLine();
                continue;
            }

            if (number == 0) {
                System.out.println("Encerrando o programa...");
                input.close();
                break;
            }
            System.out.println(parityResponse(number));
            System.out.println("--------------------------------------------------------------");

        }
    }


    public static boolean isEven(int number) {

        return number % 2 == 0;

    }
    public static String parityResponse(int number) {
        return isEven(number) ?  "O número " + number + " é par." : "O número " + number + " é ímpar.";
    }

}

