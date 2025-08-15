public class SeatMap {
    private int rowsQuantity, seatsPerRow;
    private String[] rowsStringIndices;

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

    public static void printReservationsMap(String sessionText, String[] rowsLetterIndices, int seatsPerRow){
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
