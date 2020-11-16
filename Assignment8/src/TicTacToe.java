import java.util.*;




/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think. 
 * You can just delete codes or functions I wrote if you come up with some other methods to finish the requirements.
 */

public class TicTacToe {
    static ArrayList<Integer> spotsBoard = new ArrayList<>(); //to records current spots status
    static ArrayList<Integer> spotsCount = new ArrayList<>(); //to save only spots left
    static char userSymbol = 'O';
    static char computerSymbol = 'X';
    static boolean hasWin = false;
    static boolean hasFull = false;


    static char[][] gameBoard = {
            {'1', '|', '2', '|', '3'},
            {'-', '+', '-', '+', '-'},
            {'4', '|', '5', '|', '6'},
            {'-', '+', '-', '+', '-'},
            {'7', '|', '8', '|', '9'},
    };

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        playGame();
    }

        static void playGame() {
            spotsRefill();
            System.out.println("===============");
            System.out.println("Tic Tac Toe Game");
            printGameBoard();
            while (!hasFull && !hasWin) {
                userPlace();
                computerPlace();
            }
        }
    //User places the symbol.
    static void userPlace() {
        if (!hasFull && !hasWin) {
            //ask spot and place
            int num = askSpot();
            while (!spotIsEmpty(num)) {
                System.out.println("This spot is occupied.");
                num = askSpot();
            }
            System.out.printf("You choose: %d\n", num);
            place(num, userSymbol);
            //check status
            if (hasWin()) {
                System.out.println("Congratulations you won!");
            } else if (hasFull()) {
                System.out.println("CAT!");
            } else;
        }
    }

    //Ask the user for a spot number
    static int askSpot() {
        Scanner console = new Scanner(System.in);
        System.out.printf("Please enter a spot you want to place symbol '%s': \n", userSymbol);
        int num = console.nextInt();
        return num;
    }

    //Computer place a symbol on the board
    static void computerPlace() {
        if (!hasFull && !hasWin) {
            //choose the spot and place
            Random rand = new Random();
            int randomIndex = rand.nextInt(spotsCount.size());
            int num = (int) spotsCount.get(randomIndex);
            System.out.printf("Computer chooses: %d\n", num);
            place(num, computerSymbol);
            //check status
            if (hasWin()) {
                System.out.println("CPU wins! Sorry:(");
            }
            if (hasFull()) {
                System.out.println("CAT!");
            }
        }
    }

    //Check if the spot is empty
    static boolean spotIsEmpty(int num) {
        return spotsCount.contains((Integer)num);
    }

    //Place symbol in the spot
    static void place(int num, char symbol) {
        //record the status changed
        if (symbol == userSymbol) { spotsBoard.set(num - 1, 0); }
        if (symbol == computerSymbol){ spotsBoard.set(num - 1, -1);}
        //save left spots
        spotsCount.remove((Integer)num);
        //change spots on display board
        for (int i = 0; i < gameBoard.length; i ++) {
            for (int j = 0; j < gameBoard[0].length; j ++) {
                if (Character.getNumericValue(gameBoard[i][j]) == num) {
                    gameBoard[i][j] = symbol;
                }
            }
        }
        printGameBoard();
    }

    //Check if there is 3 in a row, column or diagonal
    static boolean hasWin() {
        //row
        for (int i = 0; i <= 6; i += 3) {
            if ((spotsBoard.get(i) == spotsBoard.get(i + 1)) && (spotsBoard.get(i + 1) == spotsBoard.get(i + 2))) {
                hasWin = true;
            }
        }
        //column
        for (int i = 0; i <= 2; i ++) {
            if ((spotsBoard.get(i) == spotsBoard.get(i + 3)) && (spotsBoard.get(i + 3) == spotsBoard.get(i + 6))) {
                hasWin = true;
            }
        }
        //diagonal
        if ((spotsBoard.get(0) == spotsBoard.get(5)) && (spotsBoard.get(5) == spotsBoard.get(8))) {
            hasWin = true;
        }
        if ((spotsBoard.get(2) == spotsBoard.get(4)) && (spotsBoard.get(4) == spotsBoard.get(6))) {
            hasWin = true;
        }
        return hasWin;
    }

    //Check if the game board is full
    static boolean hasFull() {
        hasFull = spotsCount.isEmpty();
        return hasFull;
    }

    //Clear the game board and refill it.
    static void spotsRefill() {
        spotsBoard.clear();
        spotsCount.clear();
        for (int i = 1; i <= 9; i++) {
            spotsBoard.add(i);
            spotsCount.add(i);
        }
    }

    //Print the game board
    static void printGameBoard() {
        System.out.println("===============");
        for (int i = 0; i < gameBoard.length; i ++) {
            for (int j = 0; j < gameBoard[0].length; j ++) {
                System.out.print(" " + gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===============");
    }


}










