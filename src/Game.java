import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{

    private final int[][] game = new int[4][4];
    private int removed2048 = 0;
    private int currentScore=0;
    public Game() {

        setFocusable(true);
        Color lightCyan = new Color(221, 242, 235);
        setBackground(lightCyan);
        //setLayout(null);
        setVisible(true);
    }

    protected void up() {
        compressUp();

        compressUp();
        createNumber();
    }

    protected void left() {
        compressLeft();

        compressLeft();
        createNumber();
    }

    protected void down() {
        compressDown();
        compressDown();
        createNumber();
    }

    protected void right(){
        compressRight();
        mergerRight();
        compressRight();
        createNumber();
    }

    private void createNumber() {
        game[(int) Math.round(3*Math.random())][(int) Math.round(3*Math.random())]=2;
        showGameState();
        System.out.println(getScore());
    }

    private void showGameState(){
        for(int y = 0; y<4;y++){
             System.out.print("[");
             for(int x = 0; x<4;x++){
                 System.out.print(game[x][y]+"; ");
                 //System.out.print(x+" "+y);
             }
            System.out.println("]");

         }
        System.out.println("");
    }

    private void mergerRight() { //W.I.P.
        for(int y=0;y<4;y++){
            for(int x=3;x>0;x--){
                if(game[x-1][y] == game[x][y] && game[x][y]!=0){
                    game[x-1][y]=0;
                    game[x][y]=game[x][y]*2;
                }
            }
        }
    }   //W.I.P.
    private void mergerLeft() { //W.I.P.
        for(int y=0;y<4;y++){
            for(int x=0;x<3;x++){
                if(game[x+1][y] == 0){
                    game[x+1][y]=game[x][y];
                    game[x][y]=0;
                }
            }
        }

    }   //W.I.P.
    private void mergerDown() { //W.I.P.
        for(int x=0;x<4;x++){
            for(int y=3;y>0;y--){
                if(game[x][y-1] == game[x][y]){
                    game[x][y-1]=0;
                    game[x][y]=game[x][y]*2;
                }
            }
        }

    }   //W.I.P.
    private void mergerUP() {   //W.I.P.
        for(int x=0;x<4;x++){
            for(int y=0;y<3;y++){
                if(game[x][y+1] == 0){
                    game[x][y+1]=game[x][y];
                    game[x][y]=0;
                }
            }
        }

    }   //W.I.P.

    private void compressRight() {
        for(int y=0;y<4;y++){
            for(int x=0;x<3;x++){
                //System.out.println("x: "+x+"; y: "+y); // debug
                if(game[x+1][y] == 0 && game[x][y]!=0){
                    game[x+1][y]=game[x][y];
                    game[x][y]=0;
                    //showGameState(); //debug
                }
            }
        }
    }   // Works
    private void compressDown() {
        for(int x=0;x<4;x++){
            for(int y=0;y<3;y++){
                //System.out.println("x: "+x+"; y: "+y); //debug
                if(game[x][y+1] == 0 && game[x][y]!=0){
                    game[x][y+1]=game[x][y];
                    game[x][y]=0;
                    //showGameState(); //debug
                }
            }
        }
    }   // Works
    private void compressUp() {
        for(int x=0;x<4;x++){
            for(int y=3;y>0;y--){
                //System.out.println("x: "+x+"; y: "+y); // debug
                if(game[x][y-1] == 0 && game[x][y]!=0){
                    game[x][y-1]=game[x][y];
                    game[x][y]=0;
                    //showGameState(); //debug
                }
            }
        }
    }   // Works
    private void compressLeft() {
        for(int y=0;y<4;y++){
            for(int x=3;x>0;x--){
                //System.out.println("x: "+x+"; y: "+y); // debug
                if(game[x-1][y] == 0 && game[x][y]!=0){
                    game[x-1][y]=game[x][y];
                    game[x][y]=0;
                    //showGameState(); //debug
                }
            }
        }
    }   // Works

    public int getScore(){
        int ret = 0;
        for(int y = 0; y<4;y++){
            for(int x = 0; x<4;x++){
                ret = game[x][y] + ret + 2480 * removed2048;
            }
        }
        currentScore = ret;
        return ret;
    }
}
