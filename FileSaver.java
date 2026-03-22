

import java.io.*;
public class FileSaver extends Solver{
    boolean check = false;
    private int points;
    int dashSave;
    int[][] puzzle = new int[9][9];
    
    FileSaver(){}
    
    public void saveGame(int points){
        try(PrintWriter pw = new PrintWriter(new FileWriter("SaveFile.txt"))){
            setPoints(points);
            check = true;
            
            pw.println("    0 1 2   3 4 5   6 7 8");
            for(int i = 0; i < 9; i++){
                if(i%3 == 0){ //after every 3 row
                    pw.println("    - - - - - - - - - - -");
                }
                pw.print(i);
                for(int j = 0; j < 9; j++){
                    if(j == 0)  pw.print(" | ");
                    if(j%3 == 0 && j!= 0){    
                        pw.print("| ");
                    }

                    if(puzzle[i][j] != 0){
                        pw.print(puzzle[i][j] + " ");
                    }else{
                        pw.print("_ ");
                    }


                    if(j == 8)  pw.print("|");
                }
                pw.println();
            }
            pw.flush();
            
        }catch(IOException e){
            System.out.println("File could not be written");
        }catch(Exception e){
            System.out.println("Something wrong");
        }
    }
    
    public int getPoints(){
        return points;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
}
