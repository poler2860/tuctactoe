package model.players;

import model.GameModel;
import control.GameController;
public class Hal extends Player {
    GameController gc = new GameController();
    GameModel gm = new GameModel(gc);
    Player hal;
    public void HalPlacement(){
        int[] tmparr = new int[2];
      if(gm.inPlay())
      {
       tmparr=getBestMove(hal);
       gm.makeMove(tmparr[0],tmparr[1]);
      }
    }

    public int miniMax(Player player, boolean isMax) {

        int boardVal = gm.getResult();
        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (gm.getBoardMark(row, col) == null) {
                        gm.makeMove(row, col);
                        highestVal = Math.max(highestVal, miniMax(player, false));
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
                        lowestVal = Math.min(lowestVal, miniMax(player, true));
                        gm.makeblankMove(row, col);
                    }
                }
            }
            return lowestVal;
        }
    }

        public int[] getBestMove (Player player) {
            int[] bestMove = new int[]{-1, -1};
            int bestValue = Integer.MIN_VALUE;

                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        if (gm.getBoardMark(row, col) == null) {
                            gm.makeMove(row, col);
                            int moveValue = miniMax(player, false);
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


    public Hal(int games, int wins, int defeats, int ties, double score, boolean placedMark, GameController gc, GameModel gm, GameController gc1, GameModel gm1) {
        super(games, wins, defeats, ties, score, placedMark, gc, gm);
        this.gc = gc1;
        this.gm = gm1;
    }

    public Hal(String nickname, GameController gc, GameModel gm) {
        super(nickname);
        this.gc = gc;
        this.gm = gm;
    }

}