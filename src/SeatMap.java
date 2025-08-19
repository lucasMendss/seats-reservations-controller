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

    public static void printReservationsMap(String sessionText, String[] rowsLetterIndices, int seatsPerRow){
        System.out.println(" ");
        System.out.printf("%s:---------------------------\n", sessionText);
        System.out.print(" - ");
        for (int ii = 0; ii < rowsLetterIndices.length; ii++) {
            System.out.print(" - " + rowsLetterIndices[ii] + " - "); // print rows letters horizontally
        }
        System.out.println(" ");
        for (int ii = 1; ii <= seatsPerRow; ii++) {
            System.out.print(ii); // print seats numbers vertically
            for (int jj = 0; jj < rowsLetterIndices.length; jj++) {
                if (jj == 0) {
                    System.out.print("   |___| "); // print seat representation
                } else {
                    System.out.print(" |___| "); // print seat representation
                }
            }
            System.out.println(" ");
        }
    }
}
