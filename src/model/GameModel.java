package model;

import java.time.LocalDateTime;

import control.GameController;
import model.players.*;


public class GameModel {
	PlayersCatalogue  playerCatalogue;
	Player[] gamePlayers;
	String[][] gameBoard;
	GameController gc;
	boolean mover;
	boolean gameEnded;
	public int moves;

	Bean bean;

	Hal hal;
	public GameModel(GameController gc) {
		this.gc=gc;
		gamePlayers = new Player[2];
		gameBoard= null;
		playerCatalogue= new PlayersCatalogue(gc);
		mover=false;
		moves = 0;
	}

	public void checkDimValidity(int row, int col) {
		if (row <0 || col < 0 || row > 2 || col >2) {
			throw new IndexOutOfBoundsException(row + ","+col +" is not a valid board cell");
		}
	}

	public void checkMoveValidity(int row, int col) {
		checkDimValidity(row, col);
		if (gameBoard[row][col]!=null) {
			throw new IllegalArgumentException("Non playable cell");
		}
	}

	public String getBoardMark(int row, int col) {
		checkDimValidity(row, col);
		return gameBoard[row][col];
	}

	/*public void makeMove(int row, int col) {
		checkMoveValidity(row, col);
		gameBoard[row][col]=getMoverMark();
		mover=!mover;
	}
	*/

	public String getMoverMark() {
		return mover? "X": "O";
	}
	public void selectPlayer(Player player, int pos) {
		if (pos<0 && pos>1)return;
		gamePlayers[pos]=player;
	}

	public boolean ready() {
		return (gamePlayers[0] != null && gamePlayers[1] !=null);
	}

	public void startGame() {
		gameBoard= new String[3][3]; //rows | columns
	}

	public boolean endGame() {

		if(getResult() == 1 || getResult() == -1 || getResult() == 2) {
			return true;
		}

		return false;
	}

	public int makeMove(int row, int col) {
		if(endGame() == false) {
			if(inPlay()) {
				checkMoveValidity(row, col);
				gameBoard[row][col]=getMoverMark();
				int check = getResult();
			if(getResult() == 0 || getResult() == 1) {
					gameEnded = true;
					gc.endGame(gamePlayers[check],gamePlayers[check == 0 ? check+1 : check-1], 1);
				}else if(check == 2) {
					gc.endGame(null, null, 0);
				}
				mover=!mover;
				moves++;
				return 0;
				}
			}
			System.out.println("Game ended. No move is legal!");
			return 1;
		}

	public boolean inPlay() {
		return gameBoard != null;
	}

	public boolean NoPlay() {
		return !inPlay();
	}

	public void clearGamePanel() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = null;
			}
		}
	}

	public Player[] getGamePlayers() {
		return gamePlayers;
	}

	public String[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(String[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public void makeblankMove(int row, int col) {
		if(endGame() == false) {
			checkMoveValidity(row, col);
			gameBoard[row][col] = " ";
		}
	}

	public String getPlayerStats(Player player) {
		StringBuilder sb = new StringBuilder("");
		sb.append(player.getNickname()).append("\n\n\n");
		sb.append("Total:").append("\t").append(player.getGames()).append("\n");
		sb.append("Won:").append("\t").append(player.getWins()).append("\n");
		sb.append("Lost:").append("\t").append(player.getDefeats()).append("\n");
		sb.append("Ties:").append("\t").append(player.getTies()).append("\n");
		return sb.toString();
	}

	public void handleGameEnding(Player winner, Player loser, int gameType) {
		LocalDateTime timeStamp = LocalDateTime.now();
		moves = 0;
		if(gameType == 1) {

			winner.win();
			loser.defeat();



		}else if(gameType == 0){

			winner.tie();
			loser.tie();


			}

	}
	public int getResult(){

		if(moves == 9) {
			return 2;
		}
		if(horizontalCheck() == "X" || verticalCheck() == "X" || DiagonalCheck() == "X"){
			return 0;
		}
		if(horizontalCheck() == "O" || verticalCheck() == "O" || DiagonalCheck() == "O"){
			return 1;
		}

		return -1;
	}

	public String horizontalCheck(){

		String result = null;
		int tmp_res = 0;

		for (int i = 0; i < 3; i++) {
			if(tmp_res == 3 || tmp_res == -3){
				break;
			}
			tmp_res = 0;
			for (int j = 0; j < 3; j++) {
				if(gameBoard[i][j] == "X"){
					tmp_res++;
				}
				if(gameBoard[i][j] == "O"){
					tmp_res--;
				}
			}
		}
		if(tmp_res == 3) {
			result = "X";
		}
		if(tmp_res == -3) {
			result = "O";
		}

		return result;

}

	public String verticalCheck(){

		String result = null;
		int tmp_res = 0;

		for (int i = 0; i < 3; i++) {
			if(tmp_res == 3 || tmp_res == -3){
				break;
			}
			tmp_res = 0;
			for (int j = 0; j < 3; j++) {
				if(gameBoard[j][i] == "X"){
					tmp_res++;
				}
				if(gameBoard[j][i] == "O"){
					tmp_res--;
				}
			}
		}
		if(tmp_res == 3) {
			result = "X";
		}
		if(tmp_res == -3) {
			result = "O";
		}

		return result;

	}
	public String DiagonalCheck() {

		String result = null;
		int tmp_res = 0;
		int tmp_res2 = 0;

		for (int i = 0; i < 3; i++) {
			if (gameBoard[i][i] == "X") {
				tmp_res++;
			}
			if (gameBoard[i][i] == "O") {
				tmp_res--;
			}
		}

		for (int i = 0; i < 3; i++) {
			int j = 2 - i;

			if(gameBoard[i][j] == "X"){
				tmp_res2++;
			}

			if(gameBoard[i][j] == "O"){
				tmp_res2++;
			}
		}

		if (tmp_res == 3 || tmp_res2 == 3) {
			result = "X";
		}
		if (tmp_res == -3 || tmp_res2 == -3) {
			result = "O";
		}

		return result;
	}
	public PlayersCatalogue getPlayerCatalogue() {
		return playerCatalogue;
	}

	public void setPlayerCatalogue(PlayersCatalogue playerCatalogue) {
		this.playerCatalogue = playerCatalogue;
	}

	public Bean getBean() {
		return bean;
	}

	public Hal getHal() {
		return hal;
	}
}