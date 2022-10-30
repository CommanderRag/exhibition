import java.util.*;
public class Game
{


    static String[] board;
    static String turn;


    // CheckWinner method will
    // decide the combination
    // of three box given below.
    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if(contains(board, String .valueOf(a+1)))
                break;
            else if (a == 8)
                return "draw";

        }

        // To enter the X Or O at the exact place on board.
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }



    static boolean contains(String[] board, String a)
    {
        for(int i = 0; i < board.length; i++)
        {
            if(board[i].equals(a))
                return true;
        }
        return false;
    }

    // To print out the board.
    /* |---|---|---|
    | 1 | 2 | 3 |
    |-----------|
    | 4 | 5 | 6 |
    |-----------|
    | 7 | 8 | 9 |
    |---|---|---|*/

    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    public static void tictactoe()
    {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();

        System.out.println(
                "X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;

            // Exception handling.
            // numInput will take input from user like from 1 to 9.
            // If it is not in range from 1 to 9.
            // then it will show you an error "Invalid input."
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input; re-enter slot number:");
                continue;
            }

            // This game has two player X and O.
            // Here is the logic to decide the turn.
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }
        }

        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }

        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                    "Congratulations! " + winner
                            + " has won! Thanks for playing.");
        }

    }


    public static void connect4() {
        Scanner in = new Scanner(System.in);

        char[][] grid = new char[6][7];

        //initialize array
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                grid[row][col] = ' ';
            }
        }

        int turn = 1;
        char player = 'Y';
        boolean winner = false;

        //play a turn
        while (winner == false && turn <= 42){
            boolean validPlay;
            int play;
            do {
                display(grid);

                System.out.print("Player " + player + ", choose a column: ");
                play = in.nextInt();

                //validate play
                validPlay = validate(play,grid);

            }while (validPlay == false);

            //drop the checker
            for (int row = grid.length-1; row >= 0; row--){
                if(grid[row][play] == ' '){
                    grid[row][play] = player;
                    break;
                }
            }

            //determine if there is a winner
            winner = isWinner(player,grid);

            //switch players
            if (player == 'Y'){
                player = 'B';
            }else{
                player = 'Y';
            }

            turn++;
        }
        display(grid);

        if (winner){
            if (player=='Y'){
                System.out.println("Black won!!");
            }else{
                System.out.println("Yellow won!!");
            }
        }else{
            System.out.println("Tie game!!");
        }

    }

    public static void display(char[][] grid){
        System.out.println(" 0 1 2 3 4 5 6");

        for (int row = 0; row < grid.length; row++){
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++){
                System.out.print(grid[row][col]);
                System.out.print("|");
            }
            System.out.println();

        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }

    public static boolean validate(int column, char[][] grid){
        //valid column?
        if (column < 0 || column > grid[0].length){
            return false;
        }

        if(column < 0 || column > 6)
        {
            System.out.println("INVALID Number ");
            return false;
        }
        //full column?
        if (grid[0][column] != ' '){
            return false;
        }

        return true;
    }

    public static boolean isWinner(char player, char[][] grid){
        //check for 4 across
        for(int row = 0; row<grid.length; row++){
            for (int col = 0;col < grid[0].length - 3;col++){
                if (grid[row][col] == player   &&
                        grid[row][col+1] == player &&
                        grid[row][col+2] == player &&
                        grid[row][col+3] == player){
                    return true;
                }
            }
        }
        //check for 4 up and down
        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] == player   &&
                        grid[row+1][col] == player &&
                        grid[row+2][col] == player &&
                        grid[row+3][col] == player){
                    return true;
                }
            }
        }
        //check upward diagonal
        for(int row = 3; row < grid.length; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   &&
                        grid[row-1][col+1] == player &&
                        grid[row-2][col+2] == player &&
                        grid[row-3][col+3] == player){
                    return true;
                }
            }
        }
        //check downward diagonal
        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   &&
                        grid[row+1][col+1] == player &&
                        grid[row+2][col+2] == player &&
                        grid[row+3][col+3] == player){
                    return true;
                }
            }
        }
        return false;
    }

    static int numRandom()
    {
        double randBot=Math.random();
        int run;

        if(randBot>0 && randBot<=0.16667)
            run=1;
        else if(randBot>0.16667 && randBot<=0.3333)
            run=2;
        else if(randBot>0.3333 && randBot<=0.5)
            run=3;
        else if(randBot>0.5 && randBot<=0.6667)
            run=4;
        else if(randBot>0.6667 && randBot<=0.8333)
            run=5;
        else
            run=6;


        return run;
    }

    static int numUser(Scanner sc)
    {
        System.out.print("\nEnter a number between 1-6: ");
        int num = sc.nextInt();


        while(num > 6 || num < 1)
        {
            System.out.print("Invalid number entered... Enter a number between 1-6: ");
            num = sc.nextInt();
        }

        return num;

    }



    public static void handcricket()
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your choice:");
        System.out.println("1)Batting");
        System.out.println("2)Bowling");

        int choice = 0;
        int countUser = 0,countBot = 0;

        do {
            try {
                choice = sc.nextInt();
                if(choice != 1 && choice != 2)
                {
                    throw new InputMismatchException("");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input.");
            }
        }while (choice != 1 && choice != 2);


        switch(choice)
        {
            case 1:
            {
                int userRun = numUser(sc);
                int botRun = numRandom();
                while(userRun != botRun)
                {
                    countUser = countUser + userRun;

                    System.out.println("Bot chose: " + botRun);

                    System.out.println("Your score is : " + countUser);

                    userRun = numUser(sc);
                    botRun = numRandom();
                }

                System.out.println("Player OUT! Your score is : " + countUser +" Bot's turn...");
                System.out.println("----------------------------------");

                botRun = numRandom();
                boolean out = false;
                boolean won = false;

                while(numUser(sc) != botRun)
                {
                    if(out == false)
                        out = true;
                    System.out.println("Bot chose :" + botRun);
                    countBot = countBot + botRun;
                    System.out.println("Bot's score is :" + countBot);
                    System.out.println("-------------------");

                    if(countBot > countUser)
                    {
                        //   ch=1;
                        won = true;
                        break;
                    }
                    botRun = numRandom();
                }

                if(!won){
                    System.out.println("Bot OUT! Bot's total score is: " + countBot + "\n RESULTS ARE BELOW");
                    break;
                }
                if(!out)
                    System.out.println("Bot chose: " + botRun);
                break;
            }

            case 2:
            {
                int botRun = numRandom();

                while(numUser(sc) != botRun)
                {
                    System.out.println("Bot chose :" + botRun);
                    countBot=countBot + botRun;
                    System.out.println("Bot's score is :" + countBot);
                    System.out.println("-------------------");

                    botRun = numRandom();
                }

                // System.out.println("Bot chose :"+temp1);
                System.out.println("Bot OUT! Bot's total score is: " + countBot + " User's turn...");
                System.out.println("------------------------");

                int userRun = numUser(sc);
                botRun = numRandom();
                boolean won = false;
                boolean out = false;
                while(userRun != botRun)
                {
                    if(out == false)
                        out = true;
                    countUser = countUser + userRun;

                    System.out.println("Bot chose: " + botRun);
                    System.out.println("Player's score is: " + countUser);

                    if(countBot < countUser)
                    {
                        //ch=1;
                        won = true;
                        break;
                    }
                    botRun = numRandom();
                    userRun = numUser(sc);
                }
                if(!won)
                {
                    if(!out)
                        System.out.println("Bot chose: " + botRun);
                    // if(ch==1)
                    // System.out.println("Score reached \n RESULTS ARE BELOW");
                    System.out.println("Player OUT! Your score is :" + countUser + "\nRESULTS ARE BELOW");
                }
                break;
            }

            default:
                System.out.println("INVALID INPUT");
        }

        System.out.println("Player's score:\t Bot's score:");
        System.out.println(countUser+"\t \t " + countBot);

        if(countUser > countBot)
        {
            System.out.println("Player won by "+(countUser-countBot)+" runs");
        }
        else if(countUser == countBot)
        {
            System.out.println("DRAW");
        }
        else
        {
            System.out.println("Bot won by " +(countBot-countUser) +" runs");
        }

        System.out.println("-------------------------------");

    }


    public static void main(String[] args) {
        System.out.println("-------------------GAME------------------");
        System.out.println("Enter your choice: ");
        System.out.println("1) Tic-Tac-Toe ");
        System.out.println("2) Connect 4 ");
        System.out.println("3) Hand Cricket ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                tictactoe();
                break;
            case 2:
                connect4();
                break;
            case 3:
                handcricket();
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }
}
