

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//This contains the board in which the numbers will be laid out
public abstract class Board {
    int dashes; //the number of gaps in the board, the numbers user will put in
    int[][] board = new int[9][9]; //the fully solved board
    int[][] puzzleBoard = new int[9][9]; //board but some numbers are taken out and a dash is put in their place
    
    Board(){
        fillboard(board);
    }
    
    boolean isValid(int[][] board, int r, int c, int k){
        //checking each row and column
        for(int i = 0; i < 9; i++){
            if(board[r][i] == k || board[i][c] == k)    return false;
        }
        
        //checking the 3x3 subgrid
        int row = r - r%3;
        int col = c - c%3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i+row][j+col] == k)    return false;
            }
        }
        
        return true;
        
    }
    //this function is done using Backtracking
    boolean fillboard(int[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0){
                    ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3,4 ,5 ,6, 7, 8, 9));
                    Collections.shuffle(arr);

                    for(int num: arr){
                        if(isValid(board, i, j, num)){ //for each and everynumber check if it can be placed on the board
                            board[i][j] = num;

                            if(fillboard(board))    return true; //see if the number placed can then be used with other numbers

                            board[i][j] = 0; //backtrack and set it to 0 if that number is already in that column or row, or more numbers cannot be placed because of it
                        }
                    }
                    return false;
                    
                } 
                
                
            }
        }
        
        return true;
    }
    
    abstract void displayBoard();
}
