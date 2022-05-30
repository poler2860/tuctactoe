package model;

import arraylist.Array_List;
import control.GameController;
import model.players.Player;

public class GameCatalogue {
    GameController gc;
    GameModel gm;
    int NumOfPlayers;
    Array_List players;

public double[] getPlayerScore(int numOfPlayers)
{
    double[] scores = new double[NumOfPlayers];
    for(int i=0;i<NumOfPlayers; i ++)
    {
        scores[i]=gc.getModel().getPlayerCatalogue().getPlayerArray()[i].ScoreCalculator();
    }
    return scores;
}

public void sortplayersbyScore()
{
    Player[] tmparr = new Player[1];
    for(int i=0;i<NumOfPlayers;i ++)
    {

        if(gc.getModel().getPlayerCatalogue().getPlayerArray()[i].ScoreCalculator()<=gc.getModel().getPlayerCatalogue().getPlayerArray()[i].ScoreCalculator())
        {
            tmparr[0]=gc.getModel().getPlayerCatalogue().getPlayerArray()[i];
            gc.getModel().getPlayerCatalogue().getPlayerArray()[i]=gc.getModel().getPlayerCatalogue().getPlayerArray()[i+1];
            tmparr[0]=gc.getModel().getPlayerCatalogue().getPlayerArray()[i+1];
        }
    }
}

}
