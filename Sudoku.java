

import java.util.*;
public class Sudoku {
    public static void main(String[] args) {
        FileSaver fs = new FileSaver();
        Board b = new Solver();
        b.displayBoard();
        
        Scanner scan = new Scanner(System.in);
        int points = 0;
        
        System.out.println();
        System.out.println("Type \"help\" to check the guide!");
        System.out.println("Type \"save\" to save the board and overwrite previous save!");
        System.out.println("Type \"load\" to resume the game from last save!");
        
        while(true){
            boolean option = false;
            
            System.out.println("Enter your position: ");
            String pos = scan.nextLine();
            while( (pos.length() != 2) || pos.charAt(0) < 48 || pos.charAt(0) > 56 || pos.charAt(1) < 48 || pos.charAt(1) > 56 ){
                if(help(pos)){
                    option = true;
                    break;
                }
                if(save(pos, fs, points, b)){
                    option = true;
                    break;
                }
                if(load(pos, fs, b)){
                    points = fs.getPoints();
                    b.displayBoard();
                    option = true;
                    break;
                }
                if(pos.equals("-1")){
                    option = true;
                    break;
                }
                System.out.println("Enter a proper postion: ");
                pos = scan.nextLine();
            }
            if(option == true)  continue;
            
            
            System.out.println("Enter your number: ");
            String num = scan.nextLine();
            while( (num.length() != 1) || (num.charAt(0) < 49 || num.charAt(0) > 57) ){
                if(help(num)){
                    option = true;
                    break;
                }
                if(save(num, fs, points, b)){
                    option = true;
                    break;
                }
                if(load(num, fs, b)){
                    points = fs.getPoints();
                    b.displayBoard();
                    option = true;
                    break;
                }
                if(num.equals("-1")){
                    option = true;
                    break;
                }
                System.out.println("Enter a proper number from 1-9: ");
                num = scan.nextLine();
            }
            if(option == true)  continue;

            int row = pos.charAt(0) - 48;
            int col = pos.charAt(1) - 48;
            
            if(b.board[row][col] == (num.charAt(0) - 48)){
                points += 15;
                --b.dashes;
                b.puzzleBoard[row][col] = (num.charAt(0) - 48);
                System.out.println("Correct!");
                if(b.dashes == 0){
                    if(points >= 0){
                        System.out.println("Congratulations! You won the game! Your Points: " + points);
                    }else{
                        System.out.println("Unfortunately, You lost the game! Your Points: " + points);
                    }
                    break;
                }
            }else{
                points -= 5;
                System.out.println("Not Correct!");
            }
            
            System.out.println("Points: " + points);
            System.out.println("Dashesh: " + b.dashes);
            b.displayBoard();
        }
        
        System.out.println("THANKS FOR PLAYING SUDOKU!");
        
        
    }
    static boolean help(String input){
        if(input.equalsIgnoreCase("help")){
            System.out.println("To play the game, enter the row and column first, then you will be prompted to enter the number you want to place.");
            System.out.println("For instance, 13 means 1st index of row(horizontal) and 3rd index of column(vertical) as seen on the board");
            System.out.println("Then just enter the value you want to place.");
            System.out.println("If you want to try another position, enter -1");
            System.out.println("Wrong answer -5 points, correct answer +15 points!");
            return true;
        }
        return false;
    }
    static boolean save(String input, FileSaver fs, int points, Board b){
        if(input.equalsIgnoreCase("save")){
            for(int i = 0; i < 9; i++)
                for(int j = 0; j < 9; j++)
                    fs.puzzle[i][j] = b.puzzleBoard[i][j];
            
            fs.dashes = b.dashes;
            System.out.println("Game has been saved!");
            fs.saveGame(points);
            return true;
        }
        else{
            return false;
        }
    }
    static boolean load(String input, FileSaver fs, Board b){
        if(input.equalsIgnoreCase("load")){
            if(fs.check == false){
                System.out.println("There is no save file");
                return false;
            }else{
                b.dashes = fs.dashes;
                for(int i = 0; i < 9; i++)
                    for(int j = 0; j < 9; j++)
                        b.puzzleBoard[i][j] = fs.puzzle[i][j];
                System.out.println("Game has been loaded to last check point!");
                return true;
            }
        }
        return false;
    }
    
}
