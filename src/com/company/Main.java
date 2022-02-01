package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert length of the password: ");
        int length = Integer.valueOf(scanner.nextLine());
        Generator snowmaru = new Generator(length);
        int s;
        do {
            System.out.println(" ");
            System.out.println("MENU");
            System.out.println("1) Generate a password with only alphabet letters (A-Z)");
            System.out.println("2) Generate a password with special characters (A-Z + !@#$£&)");
            System.out.println("3) Generate a pin (0-9)");
            System.out.println("4) Shuffle last generated password/pin");
            System.out.println("5) Change password length");
            System.out.println("6) [EXTRA] Shuffle a password you input");
            System.out.println("0) End program");
            System.out.println("Insert your option: ");

            s = Integer.valueOf(scanner.nextLine());
            switch (s){
                case 1:
                    System.out.println("\nHERE IS YOUR RANDOM PASSWORD: ");
                    System.out.println(snowmaru.generatePasswordAlph());
                    break;
                case 2:
                    System.out.println("\nHERE IS YOUR RANDOM PASSWORD: ");
                    System.out.println(snowmaru.generateRandPasswordChar());
                    break;
                case 3:
                    System.out.println("\nHERE IS YOUR RANDOM PIN: ");
                    System.out.println(snowmaru.generateRandomPin());
                    break;
                case 4:
                    System.out.println("\nHERE IS YOUR SHUFFLED PASSWORD: ");
                    snowmaru.shufflePassword();
                    System.out.println(snowmaru.passwordInString());
                    break;
                case 5:
                    System.out.println(" ");
                    System.out.println("INSERT NEW PASSWORD LENGTH: ");
                    int newLength = Integer.valueOf(scanner.nextLine());
                    snowmaru.setLength(newLength);
                    snowmaru.setPassword(newLength);
                    System.out.println("LENGTH CHANGED SUCCESSFULLY!");
                    break;
                case 6:
                    System.out.println(" ");
                    System.out.print("INPUT YOUR CURRENT PASSWORD: ");
                    String inputPassword = scanner.nextLine();
                    System.out.println(snowmaru.shuffleInputPassword(inputPassword));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Insert a valid option!");
            }
        } while (s!= 0);
        System.out.println("Bye!!!");

    }
}
