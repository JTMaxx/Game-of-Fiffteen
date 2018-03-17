public class Replacement {
    private int rowChoice;
    private int colChoice;
    private int rowBlank;
    private int colBlank;
    private int[][] grid;
    private String[][] displayGrid;

    public Replacement(int rowChoice, int colChoice, int rowBlank, int colBlank, int[][] grid, String[]... displayGrid) {
        this.rowChoice = rowChoice;
        this.colChoice = colChoice;
        this.rowBlank = rowBlank;
        this.colBlank = colBlank;
        this.grid = grid;
        this.displayGrid = displayGrid;
    }

    public int getRowBlank() {
        return rowBlank;
    }

    public int getColBlank() {
        return colBlank;
    }

    public Replacement invoke() {
        int rowTemp;
        int colTemp;
        grid[rowBlank][colBlank] = grid[rowChoice][colChoice];
        displayGrid[rowBlank + 1][colBlank + 1] = Integer.toString(grid[rowChoice][colChoice]);
        grid[rowChoice][colChoice] = 0;
        displayGrid[rowChoice + 1][colChoice + 1] = " ";
        rowTemp = rowBlank;
        colTemp = colBlank;
        rowBlank = rowChoice;
        colBlank = colChoice;
        rowChoice = rowTemp;
        colChoice = colTemp;
        return this;
    }
}