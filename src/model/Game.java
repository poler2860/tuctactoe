package model;

import model.players.Player;
import control.GameController;
public class Game {

    Player winner;
    Player loser;

    Player[] players = new Player[2];
    boolean tie;

    GameController gc;
    //Constructor for tie
    public Game(Player p1, Player p2, boolean tie) {
        this.players[0] = p1;
        this.players[1] = p2;
        this.winner = null;
        this.loser = null;

        this.tie = tie;
    }

    public Game(Player winner, Player loser) {
        this.winner = winner;
        this.loser = loser;

        this.tie = false;
    }


}
