import java.util.Arrays;
import java.util.Scanner;

public class Game {


    public static void main(String[] args) {


        // RowZero and colBlank refer to blank spot, rowChoice and colChoice to choice of user.
        int rowChoice, colChoice, rowBlank = 0, colBlank = 0;

        int move = 1;
        Character colChoiceChar, rowChoiceChar;
        boolean correctChoice = true; // refer to user's choices
        int[][] grid = new int[4][4];
        String[][] displayGrid = {{" *", "A", "B", "C", "D"},
                {" 1", "null", "null", "null", "null"},
                {" 2", "null", "null", "null", "null"},
                {" 3", "null", "null", "null", "null"},
                {" 4", "null", "null", "null", "null"}};
        int[][] wonGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

        ArraysInit.fillArraysByRandomNumbers(grid, displayGrid);


        // assigns initial position of blank spot
        BlankSpotPosition blankSpotPosition = new BlankSpotPosition(rowBlank, colBlank, grid, displayGrid).invoke();
        rowBlank = blankSpotPosition.getRowBlank();
        colBlank = blankSpotPosition.getColBlank();


        while (!(Arrays.equals(grid, wonGrid))) {

                        if (correctChoice) {

                            System.out.println("\n  GAME OF FIFTEEN.\n  Sort numbers from 1 to 15.\n  Remember that you can move only these" +
                                    "\n  which are next to the blank spot. Have fun!\n" + "  MOVE: " + move + "\n");


                            // displays top margin
                            for (int col = 0; col <= displayGrid[0].length - 1; col++) {
                                System.out.print(displayGrid[0][col] + "\t");
                            }
                            System.out.println("\n");


                            // displays displayGrid
                            for (int row = 1; row <= displayGrid.length - 1; row++) {  // row = 1 (not 0), because we leave out row with top margin
                                System.out.print(displayGrid[row][0] + "\t"); // displays left margin
                                for (int col = 1; col <= displayGrid[0].length - 1; col++) { // col = 1 (not 0), similarly like row variable
                                    System.out.print(displayGrid[row][col] + "\t");
                                }
                                System.out.println("\n");
                            }
                        } // END---if (correctChoice)---END


                        // reads user's input and changes it to coordinates of chosen puzzle
                        System.out.println("     Which number do you want to move?\n     (Put e.g. B2)");
                        Scanner choiceScanner = new Scanner(System.in);
                        String choice = choiceScanner.next();
                        colChoiceChar = choice.charAt(0);

                        // converts letter to index of column
                        LetterChoiceConv letterChoiceConversion = new LetterChoiceConv(colChoiceChar).invoke();
                        if (letterChoiceConversion.is()) continue;
                        colChoice = letterChoiceConversion.getColChoice();


                        rowChoiceChar = choice.charAt(1);
                        System.out.println("      You chose " + " column " + colChoiceChar + " and " + "row " + rowChoiceChar);
                        rowChoice = Character.getNumericValue(rowChoiceChar) - 1;     // - 1 because user counts from 1, rowChoice indexes begins from 0

                        // condition: user chose puzzle which isn't next to the blank spot
                        if (rowChoice != rowBlank - 1 && rowChoice != rowBlank + 1 && rowChoice != rowBlank || colChoice != colBlank - 1 && colChoice != colBlank + 1 && colChoice != colBlank) {
                            System.out.println("  You can move only numbers\n  which are next to the blank spot.");
                            correctChoice = false;
                            move--;
                            continue;
                        }


                        // replaces blank spot with chosen number on grid and displayGrid
                        Replacement replacement = new Replacement(rowChoice, colChoice, rowBlank, colBlank, grid, displayGrid).invoke();
                        rowBlank = replacement.getRowBlank();
                        colBlank = replacement.getColBlank();

                        correctChoice = true;
                        move++;

                    }
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\t  YOU WON! CONGRATULATIONS!\n\n\n\n\n\n\n\n\n\n\n\n");
         }



}













