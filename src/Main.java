public class Main {
    public static void main(String[] args) {
        SeatMap seatMap = new SeatMap();

        //Receiving quantity of rows
        System.out.println("Digite quantas FILEIRAS terá a sala do teatro (min: 2 | máx: 26):");
        seatMap.setRowsQuantity(Validations.validateRowsQuantityInput());
        System.out.println(seatMap.getRowsQuantity());

        //Creating an array of alphabetical indices of rows whose length is rowsQuantity
        seatMap.setRowsStringIndices(seatMap.getRowsQuantity());
        for (int ii = 0; ii < seatMap.getRowsQuantity(); ii++) {
            System.out.println(seatMap.getRowsStringIndices()[ii]);
        }

        //Receiving quantity of seats per row
        System.out.println("Digite quantas CADEIRAS terá cada fileira (min: 2):");
        seatMap.setSeatsPerRow(Validations.validateSeatsPerRowInput());
        System.out.printf("Fileiras: %s \n Cadeiras por fileira: %s \n", seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());

        //Creating a reservation names array for each session
        seatMap.setMorningSession(seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());
        seatMap.setAfternoonSession(seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());
        seatMap.setNightSession(seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());

        int option;
        do {
            OptionsMenu.printMenu();
            option = Validations.validateMenuOptionInput();
            switch (option){
                case 1:
                    Reservation reservation = new Reservation();

                    System.out.printf("Digite a letra da fileira: (%s a %s) \n", "A", seatMap.getRowsStringIndices()[seatMap.getRowsQuantity()-1]);
                    reservation.setChosenRowStringIndex(Validations.validateChosenRowInput(seatMap.getRowsStringIndices()[seatMap.getRowsQuantity()-1]));
                    System.out.printf("FIleira escolhida: %s ----------------------- \n", reservation.getChosenRowStringIndex());
                    //Finding the index of the chosen row letter
                    for (int ii = 0; ii < seatMap.getRowsStringIndices().length; ii++){
                        if (seatMap.getRowsStringIndices()[ii].equals(reservation.getChosenRowStringIndex())){
                            reservation.setChosenRowIntIndex(ii);
                            break;
                        }
                    }

                    System.out.printf("Digite nº da cadeira: (%s a %s) \n", 1, seatMap.getSeatsPerRow());
                    //chosenSeatIntIndex = Validations.validateChosenSeatInput(seatMap.getSeatsPerRow());
                    reservation.setChosenSeatIntIndex(Validations.validateChosenSeatInput(seatMap.getSeatsPerRow()));

                    System.out.println("A reserva é para a sessão da MANHÃ, TARDE ou NOITE? \n Digite m, t ou n :");
                    //chosenSessionFirstLetter = Validations.validateChosenSessionInput();
                    reservation.setChosenSessionFirstLetter(Validations.validateChosenSessionFirstLetterInput());

                    System.out.println("Digite o nome de quem reserva:");
                    //clientName = scanner.nextLine();
                    reservation.setClientName(Validations.validateClientNameInput());

                    if (reservation.getChosenSessionFirstLetter() == 'M'){
                        reservation.setChosenSession("Manhã");
                        seatMap.getMorningSession()[reservation.getChosenRowIntIndex()][reservation.getChosenSeatIntIndex()-1] = reservation.getClientName();
                    }
                    if (reservation.getChosenSessionFirstLetter() == 'T'){
                        reservation.setChosenSession("Tarde");
                        seatMap.getAfternoonSession()[reservation.getChosenRowIntIndex()][reservation.getChosenSeatIntIndex()-1] = reservation.getClientName();
                    }
                    if (reservation.getChosenSessionFirstLetter() == 'N'){
                        reservation.setChosenSession("Noite");
                        seatMap.getNightSession()[reservation.getChosenRowIntIndex()][reservation.getChosenSeatIntIndex()-1] = reservation.getClientName();
                    }
                    System.out.printf("----> '%s' Reservou o lugar %s%s para a " +
                            "sessão da %s \n", reservation.getClientName(), reservation.getChosenRowStringIndex(), reservation.getChosenSeatIntIndex(), reservation.getChosenSession());
                    System.out.println(reservation.getChosenRowIntIndex());
                    System.out.println(reservation.getChosenSeatIntIndex());
                    System.out.println(seatMap.getMorningSession()[reservation.getChosenRowIntIndex()][reservation.getChosenSeatIntIndex()-1]);
                    //System.out.println(seatMap.getMorningSession()[0][0]);
                    //System.out.println(seatMap.getAfternoonSession()[0][0]);
                    //System.out.println(seatMap.getNightSession()[0][0]);
                    break;

                case 2:
                    SeatMap.printReservationsMap("MANHÃ", seatMap.getRowsStringIndices(), seatMap.getSeatsPerRow());
                    SeatMap.printReservationsMap("TARDE", seatMap.getRowsStringIndices(), seatMap.getSeatsPerRow());
                    SeatMap.printReservationsMap("NOITE", seatMap.getRowsStringIndices(), seatMap.getSeatsPerRow());
                    break;

                case 3:
                    System.out.println("Fim");
            }
        } while (option != 3);
    }
}