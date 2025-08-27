public class SeatMap {
    private int rowsQuantity, seatsPerRow;
    private String[] rowsStringIndices;
    private String morningSession[][];
    private String afternoonSession[][] = new String[rowsQuantity][seatsPerRow];
    private String nightSession[][] = new String[rowsQuantity][seatsPerRow];

    public int getRowsQuantity() {
        return rowsQuantity;
    }

    public void setRowsQuantity(int rowsQuantity) {
        this.rowsQuantity = rowsQuantity;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public String[] getRowsStringIndices() {
        return rowsStringIndices;
    }

    public void setRowsStringIndices(int rowsQuantity) {
        this.rowsStringIndices = new String[rowsQuantity];
        for (int i = 0; i < rowsQuantity; i++) {
            rowsStringIndices[i] = String.valueOf((char) ('A' + i));
        }
    }

    public String[][] getMorningSession() {
        return morningSession;
    }

    public void setMorningSession(int rowsQuantity, int seatsPerRow) {
        this.morningSession = new String[rowsQuantity][seatsPerRow];
    }

    public String[][] getAfternoonSession() {
        return afternoonSession;
    }

    public void setAfternoonSession(int rowsQuantity, int seatsPerRow) {
        this.afternoonSession =  new String[rowsQuantity][seatsPerRow];
    }

    public String[][] getNightSession() {
        return nightSession;
    }

    public void setNightSession(int rowsQuantity, int seatsPerRow) {
        this.nightSession =  new String[rowsQuantity][seatsPerRow];
    }

    public void printReservationsMap(String chosenSession, String[][] sessionArray){
        System.out.println(" ");
        System.out.printf("%s:---------------------------\n", chosenSession);
        System.out.print(" - ");
        for (int ii = 0; ii < rowsStringIndices.length; ii++) {
            System.out.print(" - " + rowsStringIndices[ii] + " - "); // print rows letters horizontally
        }
        System.out.println(" ");
        for (int ii = 0; ii < seatsPerRow; ii++) {
            System.out.print(ii+1); // print seats numbers vertically
            for (int jj = 0; jj < rowsStringIndices.length; jj++) {
                    if (sessionArray[jj][ii] == null){
                        if (jj == 0) {
                            System.out.print("   |___| "); // print empty seat representation
                        } else {
                            System.out.print(" |___| "); // print empty seat representation
                        }
                    }
                    else {
                        if (jj == 0) {
                            System.out.print("   |-X-| "); // print occupied seat representation
                        } else {
                            System.out.print(" |-X-| "); // print occupied seat representation
                        }
                    }
            }
            System.out.println(" ");
        }
    }
}
