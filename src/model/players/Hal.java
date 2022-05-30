package model.players;

import model.Game;
import model.GameModel;
import control.GameController;
public class Hal extends Player {
    GameController gc;

    public Hal(String name, int games, int wins, int defeats, int ties, GameController gc){
        super(name, games, wins, defeats, ties, gc, gc.getModel());
        this.gc = gc;
    }
    public void HalPlacement(){
        int[] tmparr = new int[2];
        if(gm.inPlay())
        {
            tmparr=getBestMove();
            gm.makeMove(tmparr[0],tmparr[1]);
        }
    }

    public int miniMax(boolean isMax) {

        int boardVal = gm.getResult();
        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (gm.getBoardMark(row, col) == null) {
                        gm.makeMove(row, col);
                        highestVal = Math.max(highestVal, miniMax(false));
                        gm.makeblankMove(row, col);
                    }
                }
            }
            return highestVal;
            // Minimising player, find the minimum attainable value;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (gm.getBoardMark(row, col) == null) {
                        gm.makeMove(row, col);
                        lowestVal = Math.min(lowestVal, miniMax(true));
                        gm.makeblankMove(row, col);
                    }
                }
            }
            return lowestVal;
        }
    }

    public int[] getBestMove () {
        int[] bestMove = new int[]{-1, -1};
        int bestValue = Integer.MIN_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gm.getBoardMark(row, col) == null) {
                    gm.makeMove(row, col);
                    int moveValue = miniMax(false);
                    gm.makeblankMove(row, col);
                    if (moveValue > bestValue) {
                        bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }

}
