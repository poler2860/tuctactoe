package model.players;

import model.GameModel;

import java.util.Random;

public class Bean extends player {
    GameModel gm;
    int tmpmoves;
    Random rand = new Random();
    public void BeanPlacement() {
        int row = 0;
        int col = 0;
        while(gm.inPlay() && tmpmoves<=gm.totalmoves) {

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