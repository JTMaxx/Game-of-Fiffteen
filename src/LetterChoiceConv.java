public class LetterChoiceConv {
    private boolean myResult;
    private int colChoiceChar;
    private int colChoice;

    public LetterChoiceConv(int colChoiceChar) {
        this.colChoiceChar = colChoiceChar;
    }

    boolean is() {
        return myResult;
    }

    public int getColChoice() {
        return colChoice;
    }

    public LetterChoiceConv invoke() {
        if (colChoiceChar >= ((int) 'A') && colChoiceChar <= ((int) 'D')) {
            colChoice = colChoiceChar - ((int) 'A');
        } else if (colChoiceChar >= ((int) 'a') && colChoiceChar <= ((int) 'd')) {
            colChoice = colChoiceChar - ((int) 'a');
        } else {
            System.out.println("Unknown symbol. Try again.");
            myResult = true;
            return this;
        }
        myResult = false;
        return this;
    }
}