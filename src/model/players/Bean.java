package model.players;

import model.GameModel;

public class Bean {
    GameModel Bm;
    String mark;
    int tmpmoves= Bm.totalmoves;
    void Beanplacemt() {
    if(Bm.getGamePlayerspos("Bean")==0)
          mark="X";
    else
        mark= "O";
        outerloop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Bm.makeMove(i, j);
                if (Bm.getBoardMark(i, j) == mark &&  tmpmoves<Bm.totalmoves) {
                    break outerloop;
                }
            }
        }
    }
}