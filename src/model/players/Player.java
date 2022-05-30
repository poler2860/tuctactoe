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

    GameController gc;
    GameModel gm;


    public Player(String nickname, GameController gc) {
        this.wins = 0;
        this.defeats = 0;
        this.ties = 0;
        this.score = 0;
        this.nickname = nickname;
        this.gc = gc;
        this.gm = gc.getModel();
    }

    public Player(String nickname, int games, int wins, int defeats, int ties, GameController gc, GameModel gm) {
        this.nickname = nickname;
        this.games = games;
        this.wins = wins;
        this.defeats = defeats;
        this.ties = ties;
        this.score = getScore();
        this.gc = gc;
        this.gm = gm;
    }

    public Player() {

    }

    public double ScoreCalculator(){
        if(games>0){
            score = ( (2 * wins +ties ) / games ) * 50;
        } else {
            score = 0;
        }

        return score;
    }

    public void win(){
        games++;
        wins++;
    }

    public void defeat(){
        games++;
        defeats++;
    }

    public void tie() {
        games++;
        ties++;
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

