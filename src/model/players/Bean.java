package model.players;

import control.GameController;

//import java.util.Random;


public class Bean extends Player {


    String name;

    GameController gc;

    public Bean(GameController gc) {
        super();
        this.name = "Mr. Bean";
        this.gc = gc;

    }
    int tmpmoves;
    //Random rand = new Random();
    public void BeanPlacement() {
        int row = 0;
        int col = 0;
        while(gc.getModel().inPlay() && tmpmoves<=gc.getModel().moves) {

            row = getRandomNumber(0,2);
            col = getRandomNumber(0,2);
            if (gm.getBoardMark(row,col)==null) {
                gm.makeMove(row, col);
                tmpmoves++;
            }
            continue;
        }

    }

    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max-min) + min);

    }
}