

public class Solver extends Board{
    
    Solver(){
        randomize();
    };

    void randomize(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(((int)(Math.random()*3)) == 0){
                    ++super.dashes;
                    super.puzzleBoard[i][j] = 0;
                }else{
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
