public class Reservation {
    private int chosenRowIntIndex, chosenSeatIntIndex;
    private char chosenSessionFirstLetter;
    private String chosenSession, chosenRowStringIndex, clientName;

    public boolean chosenSeatIsEmpty(String[][] chosenSessionArray, int chosenRowIntIndex, int chosenSeatIntIndex){
        if(chosenSessionArray[chosenRowIntIndex][chosenSeatIntIndex-1] == null){
            System.out.printf("----> '%s' Reservou o assento %s%s para a " +
                    "sessão da %s \n", getClientName(), getChosenRowStringIndex(), getChosenSeatIntIndex(), getChosenSession());
                    return true;
        }
        else{
            System.out.printf("O assento %s%s já está ocupado! Escolha outro.\n\n", getChosenRowStringIndex(), getChosenSeatIntIndex());
            return false;
        }
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getChosenRowStringIndex() {
        return chosenRowStringIndex;
    }

    public void setChosenRowStringIndex(String chosenRowStringIndex) {
        this.chosenRowStringIndex = chosenRowStringIndex;
    }

    public String getChosenSession() {
        return chosenSession;
    }

    public void setChosenSession(String chosenSession) {
        this.chosenSession = chosenSession;
    }

    public char getChosenSessionFirstLetter() {
        return chosenSessionFirstLetter;
    }

    public void setChosenSessionFirstLetter(char chosenSessionFirstLetter) {
        this.chosenSessionFirstLetter = chosenSessionFirstLetter;
    }

    public int getChosenSeatIntIndex() {
        return chosenSeatIntIndex;
    }

    public void setChosenSeatIntIndex(int chosenSeatIntIndex) {
        this.chosenSeatIntIndex = chosenSeatIntIndex;
    }

    public int getChosenRowIntIndex() {
        return chosenRowIntIndex;
    }

    public void setChosenRowIntIndex(int chosenRowIntIndex) {
        this.chosenRowIntIndex = chosenRowIntIndex;
    }
}
