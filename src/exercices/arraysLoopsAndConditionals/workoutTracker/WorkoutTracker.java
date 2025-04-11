package exercices.arraysLoopsAndConditionals.workoutTracker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkoutTracker {

    public static void main(String[] args) {

        int[] workouts = receiveUserData();
        displayReport(workouts);

    }

    public static int[] receiveUserData() {
        Scanner input = new Scanner(System.in);
        System.out.println("----- Workout Tracker -----");

        int weeklyTrainingDays = readIntInRange(input, "Informe quantos dias na semana você treinou: ", 1, 7);

        int[] workoutsDuration = new int[weeklyTrainingDays];

        for (int i = 0; i < weeklyTrainingDays; i++) {
            workoutsDuration[i] = readPositiveInt(input, "Duração em minutos do " + (i + 1) + "° dia de treino: ");
        }

        return workoutsDuration;
    }

    public static int readPositiveInt(Scanner input, String prompt) {
        int value;
        while (true) {
            System.out.println(prompt);
            try {
                value = input.nextInt();
                if (value > 0) return value;
                showInvalidInputMessage();
            } catch (InputMismatchException e) {
                showInvalidInputMessage();
                input.nextLine();
            }
        }
    }

    public static int readIntInRange(Scanner input, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.println(prompt);
            try {
                value = input.nextInt();
                if (value >= min && value <= max) return value;
                System.out.println("Digite um número entre " + min + " e " + max + ".");
            } catch (InputMismatchException e) {
                showInvalidInputMessage();
                input.nextLine();
            }
        }
    }

    public static void displayReport(int[] workoutsDuration) {

        if (workoutsDuration == null || workoutsDuration.length == 0) {
            System.out.println("Nenhum dado de treino disponível para gerar o relatório.");
            return;
        }

        System.out.println("--------------------- Relatório Semanal ---------------------");
        printSummary(workoutsDuration);
        System.out.println("-------------------------------------------------------------");
    }

    public static void printSummary(int[] workoutsDuration) {
        System.out.println("-> Você treinou " + workoutsDuration.length + " vezes essa semana.");
        System.out.println("-> Tempo total de treino na semana: " + totalDuration(workoutsDuration) + " minutos");
        System.out.println("-> Média da duração dos treinos: " + averageDuration(workoutsDuration) + " minutos");
        System.out.println("-> Seu treino mais longo durou: " + largestDuration(workoutsDuration) + " minutos");
        System.out.println("-> Seu treino mais curto durou: " + smallestDuration(workoutsDuration) + " minutos");
        System.out.println("-> Você teve " + durationAboveAverage(workoutsDuration) + " treino(s) com duração acima da média");
    }

    public static int totalDuration(int[] workoutsDuration) {

        int totalDuration = 0;
        for (int duration: workoutsDuration) {
            totalDuration += duration;
        }
        return totalDuration;
    }

    public static float averageDuration(int[] workoutsDuration) {
        if (workoutsDuration.length == 0) {
            return 0;
        }
        return (float) totalDuration(workoutsDuration) / workoutsDuration.length;
    }

    public static int largestDuration(int[] workoutsDuration) {

        if (workoutsDuration.length == 0) {
            return 0;
        }

        int largestDuration = workoutsDuration[0];
        for (int duration: workoutsDuration) {
            if (duration > largestDuration) {
                largestDuration = duration;
            }
        }
        return largestDuration;
    }

    public static int smallestDuration(int[] workoutsDuration) {

        if (workoutsDuration.length == 0) {
            return 0;
        }

        int smallestDuration = workoutsDuration[0];
        for (int duration: workoutsDuration) {
            if (duration < smallestDuration) {
                smallestDuration = duration;
            }
        }
        return smallestDuration;
    }

    public static int durationAboveAverage(int[] workoutsDuration) {

        float average = averageDuration(workoutsDuration);
        int count = 0;
        for (int duration: workoutsDuration) {
            if (duration > average) {
                count++;
            }
        }
        return count;

    }

    public static void showInvalidInputMessage() {
        System.out.println("Entrada inválida: Digite um número inteiro positivo.");
    }

}
