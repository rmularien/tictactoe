import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class used to play a TicTacToe game against the computer.
 * @author Riley Mularien
 * @version 1.0
 */

public class TicTacToe {
    private String[][] board;

    /**
     * A constructor for the 3 x 3 TicTacToe board.
     */
    public TicTacToe() {
        this.board = new String[3][3];
    }

    /**
     * Method to fill the board with an O at the user-specified coordinate.
     * @param x the horizontal coordinate of the O, does not correspond with index value
     * @param y the vertical coordinate of the O, does not correspond with index value
     * @return true if the move was possible, false if either the board was full or the space was already occupied
     */
    public boolean move(int x, int y) {
        x -= 1; // translates the x coordinate to the correct index
        y -= 1; // translates the x coordinate to the correct index

        if (!boardFull() && validCoordinates(x, y) && board[x][y] == null) { // checking if valid space
            board[x][y] = "O";
            return true;
        }

        return false;
    }

    /**
     * This method will make a move (X) based on the current state of the board.
     * @return true if a move was possible, false otherwise
     */
    public boolean autoMove() {
        if (!boardFull() && !checkForWin()) {
            String str = randomize();
            while (str.length() != 0) {
                if (str.charAt(0) == 'a' && findTwoInRow("O")) {
                    return true;
                } else if (str.charAt(0) == 'b' && findTwoInRow("X")) {
                    return true;
                } else if (addAdjacent()) {
                    return true;
                }

                str = str.substring(1);
            }

            // should only run if there are no X's on the board
            if (addRandom()) {
                return true;
            }
        }

        // should only return false if the board is full or there are 3 in a row
        return false;
    }

    /**
     * Method to find an X already on the board and add an X either horizontally, vertically, or diagonally adjacent.
     * @return true if such X was found, false otherwise
     */
    public boolean addAdjacent() {
        // if there is an X at (0, 0)
        if (board[0][0] != null && board[0][0].equals("X")) {
            if (board[0][1] == null) {
                board[0][1] = "X";
                return true;
            } else if (board[1][1] == null) {
                board[1][1] = "X";
                return true;
            } else if (board[1][0] == null) {
                board[1][0] = "X";
                return true;
            }
        }

        // if there is an X at (0, 1)
        if (board[0][1] != null && board[0][1].equals("X")) {
            if (board[0][0] == null) {
                board[0][0] = "X";
                return true;
            } else if (board[1][1] == null) {
                board[1][1] = "X";
                return true;
            } else if (board[0][2] == null) {
                board[0][2] = "X";
                return true;
            }
        }

        // if there is an X at (0, 2)
        if (board[0][2] != null && board[0][2].equals("X")) {
            if (board[0][1] == null) {
                board[0][1] = "X";
                return true;
            } else if (board[1][1] == null) {
                board[1][1] = "X";
                return true;
            } else if (board[1][2] == null) {
                board[1][2] = "X";
                return true;
            }
        }

        // if there is an X at (1, 0)
        if (board[1][0] != null && board[1][0].equals("X")) {
            if (board[0][0] == null) {
                board[0][0] = "X";
                return true;
            } else if (board[1][1] == null) {
                board[1][1] = "X";
                return true;
            } else if (board[2][0] == null) {
                board[2][0] = "X";
                return true;
            }
        }

        // if there is an X at (1, 1)
        if (board[1][1] != null && board[1][1].equals("X")) {
            if (board[0][0] == null) {
                board[0][0] = "X";
                return true;
            } else if (board[0][1] == null) {
                board[0][1] = "X";
                return true;
            } else if (board[0][2] == null) {
                board[0][2] = "X";
                return true;
            } else if (board[1][0] == null) {
                board[1][0] = "X";
                return true;
            } else if (board[1][2] == null) {
                board[1][2] = "X";
                return true;
            } else if (board[2][0] == null) {
                board[2][0] = "X";
                return true;
            } else if (board[2][1] == null) {
                board[2][1] = "X";
                return true;
            } else if (board[2][2] == null) {
                board[2][2] = "X";
                return true;
            }
        }

        // if there is an X at (1, 2)
        if (board[1][2] != null && board[1][2].equals("X")) {
            if (board[0][2] == null) {
                board[0][2] = "X";
                return true;
            } else if (board[1][1] == null) {
                board[1][1] = "X";
                return true;
            } else if (board[2][2] == null) {
                board[2][2] = "X";
                return true;
            }
        }

        // if there is an X at (2, 0)
        if (board[2][0] != null && board[2][0].equals("X")) {
            if (board[1][0] == null) {
                board[1][0] = "X";
                return true;
            } else if (board[1][1] == null) {
                board[1][1] = "X";
                return true;
            } else if (board[2][1] == null) {
                board[2][1] = "X";
                return true;
            }
        }

        // if there is an X at (2, 1)
        if (board[2][1] != null && board[2][1].equals("X")) {
            if (board[2][0] == null) {
                board[2][0] = "X";
                return true;
            } else if (board[1][1] == null) {
                board[1][1] = "X";
                return true;
            } else if (board[2][2] == null) {
                board[2][2] = "X";
                return true;
            }
        }

        // if there is an X at (2, 2)
        if (board[2][2] != null && board[2][2].equals("X")) {
            if (board[2][1] == null) {
                board[2][1] = "X";
                return true;
            } else if (board[1][1] == null) {
                board[1][1] = "X";
                return true;
            } else if (board[1][2] == null) {
                board[1][2] = "X";
                return true;
            }
        }

        return false;
    }

    /**
     * Adds an X value at a random available coordinate to the board.
     * @return true if the method completes.
     */
    public boolean addRandom() {
        boolean added = false;

        if (!boardFull()) {
            while (!added) {
                int row = (int) (Math.random() * 3);
                int col = (int) (Math.random() * 3);

                if (board[row][col] == null) {
                    board[row][col] = "X";
                    added = true;
                    break;
                }
            }

            return true;
        }


        return false;
    }

    /**
     * This method finds either two O's or two X's in a row, and fills an x if the remaining spot is empty.
     * @param key the key to search for, either an O or an X (validated with validKey())
     * @return true if two of key was found in a row and an X was added next to it, false otherwise
     */
    public boolean findTwoInRow(String key) {
        if (validKey(key)) {
            // checking to see if there are any two keys in a row or col
            for (int row = 0; row < board.length -  1; row++) {
                for (int col = 0; col < board.length - 1; col++) {
                    if (board[row][col] != null && board[row][col + 1] != null
                            && board[row][col].equals(key) && board[row][col + 1].equals(key)) {
                        if (col == 0 && board[row][2] == null) {
                            board[row][2] = "X";
                            return true;
                        } else if (board[row][0] == null) {
                            board[row][0] = "X";
                            return true;
                        }
                    }

                    if (board[row][col] != null && board[row + 1][col] != null
                            && board[row][col].equals(key) && board[row + 1][col].equals(key)) {
                        if (row == 0 && board[2][col] == null) {
                            board[2][col] = "X";
                            return true;
                        } else if (board[0][col] == null) {
                            board[0][col] = "X";
                            return true;
                        }
                    }
                }
            }

            // checking to see if there are any two keys diagonally
            if (board[0][0] != null && board[1][1] != null
                    && board[0][0].equals(key) && board[1][1].equals(key) && board[2][2] == null) {
                board[2][2] = "X";
                return true;
            }

            if (board[1][1] != null && board[2][2] != null
                    && board[1][1].equals(key) && board[2][2].equals(key) && board[0][0] == null) {
                board[0][0] = "X";
                return true;
            }

            if (board[0][2] != null && board[1][1] != null
                    && board[0][2].equals(key) && board[1][1].equals(key) && board[2][0] == null) {
                board[2][0] = "X";
                return true;
            }

            if (board[1][1] != null && board[2][0] != null
                    && board[1][1].equals(key) && board[2][0].equals(key) && board[0][2] == null) {
                board[0][2] = "X";
                return true;
            }
        }

        return false;
    }

    /**
     * Randomizes the three possible options for the autoMove method. Options are as follows:
     * a) Check for two O's in a row and add an X to block the win, if possible
     * b) Check for two X's in a row and add an X to establish a win, if possible
     * c) Check for at least one x, add an x next to it if possible
     * If none are possible, then an x is added randomly in an empty space
     * @return a String with letters a, b, c in a randomized order to represent the options
     */
    public static String randomize() {
        // Create an array with the possible options
        ArrayList<String> options = new ArrayList<String>();
        options.add("a");
        options.add("b");
        options.add("c");
        String res = "";

        int i =  (int) (Math.random() * (4 - 1));

        while (options.size() != 1) {
            res += options.get(i);
            options.remove(i);
            i = (int) (Math.random() * (3 - 1));
        }

        res += options.get(0);

        return res;

    }

    /**
     * Determines whether the coordinates are valid (must be between 0 and 2).
     * @param x the column index on the board
     * @param y the row index on the board
     * @return true if coordinates are valid, false otherwise
     */
    public boolean validCoordinates(int x, int y) {
        if (x <= 2 && x >= 0 && y <= 2 && y >= 0) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the inputted key is either an O or X.
     * @param key the key to be inputted
     * @return true if the key is valid, false otherwise
     */
    public boolean validKey(String key) {
        if (key != null && (key.equals("O") || key.equals("X"))) {
            return true;
        }

        return false;
    }

    /**
     * Method used to test if the board is full.
     * @return true if the board is full, false otherwise
     */
    public boolean boardFull() {
        boolean full = true;

        for (int i = 0; i < board.length; i++) {
            for (int x = 0; x < board.length; x++) {
                if (board[i][x] == null) {
                    full = false;
                    break;
                }
            }
        }

        return full;
    }

    /**
     * Method that checks to see if either party has won based on the state of the board.
     * Criteria for a win: three in a row either diagonally, or across a single row or column
     * @return true if there is a win, false otherwise
     */
    public boolean checkForWin() {
        // ROW WIN CASES
        if (!checkNullRow(0) && board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) {
            return true;
        } else if (!checkNullRow(1) && board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) {
            return true;
        } else if (!checkNullRow(2) && board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) {
            return true;
        }

        // COL WIN CASES
        if (!checkNullCol(0) && board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) {
            return true;
        } else if (!checkNullCol(1) && board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) {
            return true;
        } else if (!checkNullCol(2) && board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) {
            return true;
        }

        // DIAGONAL WIN CASES
        if (board[0][0] != null && board[1][1] != null && board[2][2] != null
                && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return true;
        } else if (board[0][2] != null && board[1][1] != null && board[2][0] != null
                && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return true;
        }

        return false;
    }

    /**
     * Checks if any values in a specified row are null.
     * @param row the row to be checked, as an index
     * @return true if at least one value was null, false otherwise
     */
    public boolean checkNullRow(int row) {
        for (int col = 0; col < 3; col++) {
            if (board[row][col] == null) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if any values in a specified column are null.
     * @param col the column to be checked, as an index
     * @return true if at least one value was null, false otherwise
     */
    public boolean checkNullCol(int col) {
        for (int row = 0; row < 3; row++) {
            if (board[row][col] == null) {
                return true;
            }
        }

        return false;
    }

    /**
     * Formats the TicTacToe board to be readable by the user.
     * @return a formatted TicTacToe board
     */
    public String toString() {
        return boardFormat();
    }

    /**
     * A helper method for the toString that formats the board correctly.
     * @return a readable TicTacToe board
     */
    private String boardFormat() {
        String res = "";

        for (int i = 0; i < board.length; i++) {
            for (int x = 0; x < board.length; x++) {
                if (board[i][x] == null) {
                    res += "- ";
                } else {
                    res += board[i][x] + " ";
                }
            }

            if (i != 2) {
                res += "\n";
            }
        }

        return res;
    }

    /**
     * Main method for a game of TicTacToe, allows for user input to play the game.
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicTacToe board = new TicTacToe();

        System.out.println("Welcome to TicTacToe!");
        System.out.println("When prompted to enter a row value, choose a number between 1 and 3.");
        System.out.println("When prompted to enter a column value, choose a number between 1 and 3.");
        System.out.println("  1 2 3");
        System.out.println("1 - - -");
        System.out.println("2 - - -");
        System.out.println("3 - - -");

        while (!board.boardFull() && !board.checkForWin()) {
            System.out.println("Your turn.");
            boolean moved = false;

            while (!moved) {
                System.out.println("Choose a row value:");
                int row = input.nextInt();
                input.nextLine();

                System.out.println("Choose a column value:");
                int col = input.nextInt();
                input.nextLine();

                if (board.move(row, col)) {
                    moved = true;
                } else {
                    System.out.println("Please input a coordinate that does not already have a value.");
                }
            }

            System.out.println("Making move...Done!");
            System.out.println("Board looks like this:");
            System.out.println(board);

            System.out.println("Computer's turn.");
            board.autoMove();

            System.out.println("Making move...Done!");
            System.out.println("Board looks like this:");
            System.out.println(board);
        }

        System.out.println("Done!");
    }
}
