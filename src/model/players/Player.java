package model.players;

import model.GameModel;
import control.GameController;

public class Player {

    private String nickname;
    private int games;
    private int wins;
    private int defeats;
    private int ties;
    private double score;
    private boolean placedMark;

    GameController gc = new GameController();
    GameModel gm = new GameModel(gc);


    public Player(String nickname) {
        this.wins=0;
        this.defeats=0;
        this.ties=0;
        this.score=0;
        this.nickname = nickname;

    }

    public void ScoreCalculator(){
        if(games>0){
            score = ( (2 * wins +ties ) / games ) * 50;
        }
    }

    public void win(){
        games++;
        wins++;
    }

    public void defeat(){
        games++;
        defeats++;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isPlacedMark() {
        return placedMark;
    }

    public void setPlacedMark(boolean placedMark) {
        this.placedMark = placedMark;
    }

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
    }

}

