package exercices.basics.loginSystem;

import java.util.Scanner;

public class LoginSystem {
    
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "2345";


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Sistema de Login");

        int count = 3;
        while (count > 0) {
            System.out.println("Usuário: ");
            String username = input.next().trim();
            System.out.println("Senha: ");
            String password = input.next().trim();

            if(!authenticate(username, password)) {
                System.out.println("Credenciais inválidas!");
                count--;
                System.out.println("Tentativas restastes: " + count);
                if (count == 0) {
                    System.out.println("Número de tentativas excedido. Encerrando o sistema...");
                }
                System.out.println("-----------------------------------");
            } else {
                System.out.println("Usuário logado com sucesso!");
                System.out.println("-----------------------------------");
                break;
            }
        }
        input.close();
    }

    public static boolean authenticate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}
