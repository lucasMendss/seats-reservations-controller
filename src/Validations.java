import java.util.Scanner;

public class Validations {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean inputIsValid;

    public static int validateRowsQuantityInput() {
        inputIsValid = false;
        int output = 0;
        while (!inputIsValid) {
            String input = scanner.next();

            try {
                output = Integer.parseInt(input);
                if (output > 1 && output <= 26) {
                    inputIsValid = true;
                    return output;
                } else {
                    System.out.println("Valor inválido (1 a 26).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
        return output;
    }

    public static int validateSeatsPerRowInput() {
        inputIsValid = false;
        int output = 0;
        while (!inputIsValid) {
            String input = scanner.next();

            try {
                output = Integer.parseInt(input);
                if (output > 1) {
                    inputIsValid = true;
                    return output;
                } else {
                    System.out.println("Valor inválido. Digite um número maior que 1).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
        return output;
    }

    public static int validateMenuOptionInput() {
        inputIsValid = false;
        int output = 0;
        while (!inputIsValid) {

            String input = scanner.next();

            try {
                output = Integer.parseInt(input);
                if (output > 0 && output < 5) {
                    inputIsValid = true;
                    return output;
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
        return output;
    }

    public static String validateChosenRowInput(String maxPossibleLetterIndex){
        inputIsValid = false;
        String output = "";
        char charMaxPossibleLetterIndex = maxPossibleLetterIndex.charAt(0);

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (!inputIsValid) {
            String input = scanner.nextLine().toUpperCase();

            if (input.length() == 1) { // only one character
                char charInput = input.charAt(0);

                if (charInput >= 'A' && charInput <= charMaxPossibleLetterIndex) { // verify from 'A' to 'last-row-letter'
                    output = String.valueOf(charInput);
                    inputIsValid = true;
                    return output;
                }
            }
            System.out.printf("Não é uma letra de A a %s. Digite novamente.\n", charMaxPossibleLetterIndex);
        }
        return output;
    }

    public static int validateChosenSeatInput(int rowsQuantity) {
        inputIsValid = false;
        int output = 0;
        while (!inputIsValid) {
            String input = scanner.next();

            try {
                output = Integer.parseInt(input);
                if (output > 0 && output <= rowsQuantity) {
                    inputIsValid = true;
                    return output;
                } else {
                    System.out.printf("Digite um valor entre 1 e %s.\n", rowsQuantity);
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
        return output;
    }

    public static char validateChosenSessionInput() {
        inputIsValid = false;
        char output = '-';

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while(!inputIsValid){
            String input = scanner.nextLine().toUpperCase();

            if (input.length() == 1) { // checks if the input has only one character
                output = input.charAt(0);

                if (output == 'M' || output == 'T' || output == 'N'){
                    inputIsValid = true;
                    return output;
                }
            }
            System.out.println("Não é uma letra válida. Digite novamente.\n");
        }
        return output;
    }
}
