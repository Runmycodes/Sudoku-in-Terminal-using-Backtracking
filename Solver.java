

public class Solver extends Board{
    
    Solver(){
        randomize();
    };

    //the fully solved board is copied to puzzleBoard, but not all of it
    void randomize(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(((int)(Math.random()*3)) == 0){ //if the random number is 0, the puzzleBoard will be 0 that will leave a dash
                    ++super.dashes;
                    super.puzzleBoard[i][j] = 0;
                }else{ //otherwise if it's not 0, the number is copied
                    super.puzzleBoard[i][j] = super.board[i][j];
                }
                
            }
        }
        
    }
    
    
    @Override
    void displayBoard(){
        System.out.println("    0 1 2   3 4 5   6 7 8");
        for(int i = 0; i < 9; i++){
            if(i%3 == 0){ //after every 3 row
                System.out.println("    - - - - - - - - - - -");
            }
            System.out.print(i);
            for(int j = 0; j < 9; j++){
                if(j == 0)  System.out.print(" | ");
                if(j%3 == 0 && j!= 0){    
                    System.out.print("| ");
                }
                
                // this is the main part, other things are decorations
                // if there is a 0, just add a dash for user to figure what number will be there
                if(super.puzzleBoard[i][j] != 0){
                    System.out.print(super.puzzleBoard[i][j] + " ");
                }else{
                    System.out.print("_ ");
                }
                
                
                if(j == 8)  System.out.print("|");
            }
            System.out.println();
        }
    }
    
}
