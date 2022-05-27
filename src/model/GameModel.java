package model;

import control.GameController;


public class GameModel {
	PlayersCatalogue playerCatalogue;
	String[] gamePlayers;
	String[][] gameBoard;
	GameController gc;
	Boolean mover;
	public int totalmoves;
	public GameModel(GameController gc) {
		this.gc = gc;
		gamePlayers = new String[2];
		gameBoard = null;
		playerCatalogue = new PlayersCatalogue();
		mover = false;
	}

	public void checkDimValidity(int row, int col) {
		if (row < 0 || col < 0 || row > 2 || col > 2) {
			throw new IndexOutOfBoundsException(row + "," + col + " is not a valid board cell");
		}
	}

	public void checkMoveValidity(int row, int col) {
		checkDimValidity(row, col);
		if (gameBoard[row][col] != null) {
			throw new IllegalArgumentException("Non playable cell");
		}
	}

	public String getBoardMark(int row, int col) {
		checkDimValidity(row, col);
		return gameBoard[row][col];
	}

	public void makeMove(int row, int col) {
		checkMoveValidity(row, col);
		gameBoard[row][col] = getMoverMark();
		mover = !mover;
		totalmoves++;

	}

	public String getMoverMark() {
		return mover ? "X" : "O";
	}

	public void selectPlayer(String player, int pos) {
		if (pos < 0 && pos > 1) return;
		gamePlayers[pos] = player;
	}

	public boolean ready() {
		return (gamePlayers[0] != null && gamePlayers[1] != null);
	}

	public void startGame() {
		totalmoves=0;
		gameBoard = new String[3][3];//rows | columns
	}

	public boolean inPlay() {
		return gameBoard != null;
	}

	public boolean NoPlay() {
		return !inPlay();
	}

	public String[] getGamePlayers() {
		return gamePlayers;
	}

	public int getGamePlayerspos(String j) {
		int tmp=-1;
		for (int i = 0; i < 2; i++) {
			if (gamePlayers[i] == "j")
				tmp=i;
		}
		return tmp;
	}
	public String[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(String[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public PlayersCatalogue getPlayerCatalogue() {
		return playerCatalogue;
	}

	public void setPlayerCatalogue(PlayersCatalogue playerCatalogue) {
		this.playerCatalogue = playerCatalogue;
	}

	public String getPlayerStats(String player) {
		StringBuilder sb = new StringBuilder("");
		sb.append(player).append("\n\n\n");
		sb.append("Total:").append("\t").append(4).append("\n");
		sb.append("Won:").append("\t").append("75%").append("\n");
		sb.append("Lost:").append("\t").append("25%").append("\n");
		return sb.toString();
	}

	public void getResult(){

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

		if (tmp_res == 3) {
			result = "X";
		}
		if (tmp_res == -3) {
			result = "O";
		}

		return result;

	}
}