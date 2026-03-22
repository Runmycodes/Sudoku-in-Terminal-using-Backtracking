

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Board {
    int dashes;
    int[][] board = new int[9][9];
    int[][] puzzleBoard = new int[9][9];
    
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
    boolean fillboard(int[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0){
                    ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3,4 ,5 ,6, 7, 8, 9));
                    Collections.shuffle(arr);

                    for(int num: arr){
                        if(isValid(board, i, j, num)){
                            board[i][j] = num;

                            if(fillboard(board))    return true;

                            board[i][j] = 0; //backtrack and set it to 0 if the number doesn't make the sudoku board correct
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
