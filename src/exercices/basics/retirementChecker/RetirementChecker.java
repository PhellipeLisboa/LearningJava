package exercices.basics.retirementChecker;

import exercices.basics.retirementChecker.exceptions.InvalidAgeException;
import exercices.basics.retirementChecker.exceptions.InvalidSexException;

import java.util.Scanner;

public class RetirementChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = input.next();
        System.out.println("Digite sua idade: ");
        int idade = input.nextInt();
        System.out.println("Digite seu sexo (M/F): ");
        String sexo = input.next().trim().toUpperCase();

        System.out.println("Analisando......");
        System.out.println(retirementResponse(nome, idade, sexo));

        input.close();

    }

    public static boolean canRetire(int idade, String sexo) throws InvalidAgeException, InvalidSexException {

        if(!(sexo.equals("M") || sexo.equals("F"))) {
            throw new InvalidSexException("Sexo inválido. Insira \"M\" ou \"F\".");
        }

        if(idade <= 0) {
            throw new InvalidAgeException("Idade inválida. Insira um valor maior que zero.");
        }

        switch (sexo) {
            case "M":
                return idade >= 65;
            case "F":
                return idade >=60;
            default:
                return false;
        }
    }

    public static String retirementResponse(String nome, int idade, String sexo) {
        try {
            if (canRetire(idade, sexo)) {
                return nome + " já pode se aposentar.";
            } else {
                int yearsUntilRetirement = sexo.equals("M") ? 65 - idade : 60 - idade;
                return nome + " ainda não pode se aposentar, faltam " + yearsUntilRetirement + " anos.";
            }
        } catch (InvalidSexException | InvalidAgeException e) {
            return e.getMessage();
        }
    }

}
