import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeatMap seatMap = new SeatMap();
        //------------------------------------xx
        int chosenRowIntIndex = 0, chosenSeatIntIndex = 0;
        char chosenSessionChar = '-';
        String chosenSessionText = "", chosenRowStringIndex, clientName;
        //------------------------------------xx

        //Receiving quantity of rows
        System.out.println("Digite quantas FILEIRAS terá a sala do teatro (máx: 26):");
        seatMap.setRowsQuantity(Validations.validateRowsQuantityInput());
        System.out.println(seatMap.getRowsQuantity());

        //Creating an array of alphabetical indices of rows whose length is rowsQuantity
        String[] rowsStringIndices = new String[seatMap.getRowsQuantity()];
        for (int ii = 0; ii < seatMap.getRowsQuantity(); ii++) {
            rowsStringIndices[ii] = String.valueOf((char) ('A' + ii));
        }

        //Receiving quantity of seats per row
        System.out.println("Digite quantas CADEIRAS terá cada fileira:");
        seatMap.setSeatsPerRow(Validations.validateSeatsPerRowInput());
        System.out.printf("Fileiras: %s \n Cadeiras por fileira: %s \n", seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());

        String morningSession[][] = new String[seatMap.getRowsQuantity()][seatMap.getSeatsPerRow()];
        String afternoonSession[][] = new String[seatMap.getRowsQuantity()][seatMap.getSeatsPerRow()];
        String nightSession[][] = new String[seatMap.getRowsQuantity()][seatMap.getSeatsPerRow()];


        int option;
        do {
            OptionsMenu.printMenu();
            option = Validations.validateMenuOptionInput();
            switch (option){
                case 1:
                    if(seatMap.getRowsQuantity() > 1){
                        System.out.printf("Digite a letra da fileira: (%s a %s) \n", "A", rowsStringIndices[seatMap.getRowsQuantity()-1]);
                        chosenRowStringIndex = Validations.validateChosenRowInput(rowsStringIndices[seatMap.getRowsQuantity()-1]);
                        System.out.printf("FIleira escolhida: %s ----------------------- \n", chosenRowStringIndex);
                        //Finding the index of the chosen row letter
                        for (int ii = 0; ii < rowsStringIndices.length; ii++){
                            if (rowsStringIndices[ii].equals(chosenRowStringIndex)){
                                chosenRowIntIndex = ii;
                                break;
                            }
                        }
                    }
                    else {
                        chosenRowStringIndex = rowsStringIndices[1];
                    }
                    if(seatMap.getSeatsPerRow() > 1){
                        System.out.printf("Digite nº da cadeira: (%s a %s) \n", 1, seatMap.getSeatsPerRow());
                        chosenSeatIntIndex = Validations.validateChosenSeatInput(seatMap.getSeatsPerRow());
                    }
                    else {
                        chosenSeatIntIndex = 1;
                    }
                    System.out.println("A reserva é para a sessão da MANHÃ, TARDE ou NOITE? \n Digite m, t ou n :");
                    chosenSessionChar = Validations.validateChosenSessionInput();

                    System.out.println("Digite o nome de quem reserva:");
                    clientName = scanner.nextLine();

                    if (chosenSessionChar == 'M'){
                        chosenSessionText = "Manhã";
                        morningSession[chosenRowIntIndex][chosenSeatIntIndex-1] = clientName;
                    }
                    if (chosenSessionChar == 'T'){
                        chosenSessionText = "Tarde";
                        afternoonSession[chosenRowIntIndex][chosenSeatIntIndex-1] = clientName;
                    }
                    if (chosenSessionChar == 'N'){
                        chosenSessionText = "Noite";
                        nightSession[chosenRowIntIndex][chosenSeatIntIndex-1] = clientName;
                    }
                    System.out.printf("----> '%s' Reservou o lugar %s%s para a " +
                            "sessão da %s \n", clientName, chosenRowStringIndex, chosenSeatIntIndex, chosenSessionText);
                    break;
                case 2:
                    System.out.println(chosenRowIntIndex);
                    System.out.println(chosenSeatIntIndex);
                    SeatMap.printReservationsMap("MANHÃ", rowsStringIndices, seatMap.getSeatsPerRow());
                    SeatMap.printReservationsMap("TARDE", rowsStringIndices, seatMap.getSeatsPerRow());
                    SeatMap.printReservationsMap("NOITE", rowsStringIndices, seatMap.getSeatsPerRow());
                    break;
                case 3:
                    System.out.println("Fim");
            }
        } while (option != 3);
    }
}