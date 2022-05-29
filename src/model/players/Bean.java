package model.players;

import model.GameModel;

import java.util.Random;

public class Bean extends player {
GameModel gm;

Random rand = new Random();
    public void BeanPlacement() {
        Boolean placedMark = true;
        int row = 0;
        int col = 0;
        while(gm.inPlay() && !placedMark) {

            row = getRandomNumber(0,2);
            col = getRandomNumber(0,2);
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max-min) + min);
    }
}