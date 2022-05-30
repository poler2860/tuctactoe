package model.players;

import control.GameController;

//import java.util.Random;


public class Bean extends Player {


    String name;

    GameController gc;

    public Bean(String name, int games, int wins, int defeats, int ties, GameController gc) {
        super("Mr. Bean", games, wins, defeats, ties, gc, gc.getModel());
        this.name = "Mr. Bean";
        this.gc = gc;

    }
    //Random rand = new Random();
    public void BeanPlacement() {
        int tmpMoves = 0;
        int row = 0;
        int col = 0;
        while(gc.getModel().inPlay() && tmpMoves<=gc.getModel().moves) {

            row = getRandomNumber(0,2);
            col = getRandomNumber(0,2);
            if (gm.getBoardMark(row,col)==null) {
                gm.makeMove(row, col);
                tmpMoves++;
            }
            continue;
        }

    }

    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max-min) + min);

    }
}