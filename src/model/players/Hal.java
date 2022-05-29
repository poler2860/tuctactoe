package model.players;

import model.GameModel;
import control.GameController;
public class Hal {
    GameController gc = new GameController();
    GameModel gm = new GameModel(gc);

    public void Play() {
        if(gm.inPlay()) {
            //Hal
        }
    }

}
