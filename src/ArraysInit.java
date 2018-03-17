import java.util.Random;

public class ArraysInit {
    static void fillArraysByRandomNumbers(int[][] grid, String[][] displayGrid) {

        int rndRowFrom;
        int rndColFrom;
        int rndRowDest;
        int rndColDest;


        //fills grid and displayGrid by numbers from 0 to 15
        int i = 0;
        for (int row = 0; row <= grid.length - 1; row++) {
            for (int col = 0; col <= grid[0].length - 1; col++) {
                grid[row][col] = i;
                displayGrid[row + 1][col + 1] = Integer.toString(i);
                i++;
            }
        }


        // makes 15 random replacements in grid
        Random random = new Random();
        for (int replacementsNumber = 0; replacementsNumber < 15; replacementsNumber++) {
            rndRowFrom = random.nextInt(grid.length); // we don't subtract 1 because random.nextInt()
            rndColFrom = random.nextInt(grid.length); //takes numbers from 0 (inclusive) to n (exclusive)
            rndRowDest = random.nextInt(grid.length);
            rndColDest = random.nextInt(grid.length);
            int temp = grid[rndRowFrom][rndColFrom];
            grid[rndRowFrom][rndColFrom] = grid[rndRowDest][rndColDest];
            grid[rndRowDest][rndColDest] = temp;


        }

        //fills displayGrid by numbers from grid
        for (int row = 0; row <= grid.length - 1; row++) {
            for (int col = 0; col <= grid[0].length - 1; col++) {
                displayGrid[row + 1][col + 1] = Integer.toString(grid[row][col]);
            }
        }
    }
}
