public class Main {
    public static void main(String[] args) {
        SeatMap seatMap = new SeatMap();

        //Receiving quantity of rows
        System.out.println("Digite quantas FILEIRAS terá a sala do teatro (min: 2 | máx: 26):");
        seatMap.setRowsQuantity(Validations.validateRowsQuantityInput());

        //Creating an array of alphabetical indices of rows whose length is rowsQuantity
        seatMap.setRowsStringIndices(seatMap.getRowsQuantity());

        //Receiving quantity of seats per row
        System.out.println("Digite quantas CADEIRAS terá cada fileira (min: 2):");
        seatMap.setSeatsPerRow(Validations.validateSeatsPerRowInput());
        System.out.printf("Fileiras: %s \nCadeiras por fileira: %s \n", seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());

        //Creating a reservation names array for each session
        seatMap.setMorningSession(seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());
        seatMap.setAfternoonSession(seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());
        seatMap.setNightSession(seatMap.getRowsQuantity(), seatMap.getSeatsPerRow());

        //Printing the visual representation of the three seat maps (all seats empty)
        seatMap.printReservationsMap("MANHÃ", seatMap.getMorningSession());
        seatMap.printReservationsMap("TARDE", seatMap.getAfternoonSession());
        seatMap.printReservationsMap("NOITE", seatMap.getNightSession());
        System.out.println("\nLEGENDA: ------------------------");
        System.out.println("- Assento vazio: |___|");
        System.out.println("- Assento ocupado: |-X-|");
        System.out.println("-----------------------------------");

        int option;
        do {
            OptionsMenu.printMenu();
            option = Validations.validateMenuOptionInput();
            switch (option){
                case 1:
                    boolean reservationCompleted = false;
                    while (!reservationCompleted){
                        Reservation reservation = new Reservation();

                        System.out.printf("Digite a letra da fileira: (%s a %s) \n", "A", seatMap.getRowsStringIndices()[seatMap.getRowsQuantity()-1]);
                        reservation.setChosenRowStringIndex(Validations.validateChosenRowInput(seatMap.getRowsStringIndices()[seatMap.getRowsQuantity()-1]));
                        //Finding the index of the chosen row letter
                        for (int ii = 0; ii < seatMap.getRowsStringIndices().length; ii++){
                            if (seatMap.getRowsStringIndices()[ii].equals(reservation.getChosenRowStringIndex())){
                                reservation.setChosenRowIntIndex(ii);
                                break;
                            }
                        }

                        System.out.printf("Digite nº da cadeira: (%s a %s) \n", 1, seatMap.getSeatsPerRow());
                        reservation.setChosenSeatIntIndex(Validations.validateChosenSeatInput(seatMap.getSeatsPerRow()));

                        System.out.println("A reserva é para a sessão da MANHÃ, TARDE ou NOITE? \n Digite m, t ou n :");
                        reservation.setChosenSessionFirstLetter(Validations.validateChosenSessionFirstLetterInput());

                        System.out.println("Digite o nome de quem reserva:");
                        reservation.setClientName(Validations.validateClientNameInput());

                        if (reservation.getChosenSessionFirstLetter() == 'M'){
                            reservation.setChosenSession("Manhã");
                            if(reservation.chosenSeatIsEmpty(seatMap.getMorningSession(), reservation.getChosenRowIntIndex(), reservation.getChosenSeatIntIndex())){
                                seatMap.getMorningSession()[reservation.getChosenRowIntIndex()][reservation.getChosenSeatIntIndex()-1] = reservation.getClientName();
                                reservationCompleted = true;
                            }
                        }
                        if (reservation.getChosenSessionFirstLetter() == 'T'){
                            reservation.setChosenSession("Tarde");
                            if(reservation.chosenSeatIsEmpty(seatMap.getAfternoonSession(), reservation.getChosenRowIntIndex(), reservation.getChosenSeatIntIndex())){
                                seatMap.getAfternoonSession()[reservation.getChosenRowIntIndex()][reservation.getChosenSeatIntIndex()-1] = reservation.getClientName();
                                reservationCompleted = true;
                            }
                        }
                        if (reservation.getChosenSessionFirstLetter() == 'N'){
                            reservation.setChosenSession("Noite");
                            if(reservation.chosenSeatIsEmpty(seatMap.getNightSession(), reservation.getChosenRowIntIndex(), reservation.getChosenSeatIntIndex())){
                                seatMap.getNightSession()[reservation.getChosenRowIntIndex()][reservation.getChosenSeatIntIndex()-1] = reservation.getClientName();
                                reservationCompleted = true;
                            }
                        }
                    }
                    break;

                case 2:
                    seatMap.printReservationsMap("MANHÃ", seatMap.getMorningSession());
                    seatMap.printReservationsMap("TARDE", seatMap.getAfternoonSession());
                    seatMap.printReservationsMap("NOITE", seatMap.getNightSession());
                    break;

                case 3:
                    System.out.println("Fim");
                    break;
            }
        } while (option != 3);
    }
}