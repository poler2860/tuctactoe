package model;

import control.GameController;
import arraylist.Array_List;
import model.Game;

public class GameCatalogue {

    GameController gc;

    Array_List games;

    public GameCatalogue(GameController gc){

    }

    public void addNewGame(Game g) {
        games.add(g)
    }

    public Array_List getGames(){
        return games;
    }
}
