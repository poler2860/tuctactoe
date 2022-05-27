package model.players;

import model.GameModel;

public class Bean {
GameModel Bm;
    void Beanplacemt() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Bm.makeMove(i, j);

            }
        }
    }
}