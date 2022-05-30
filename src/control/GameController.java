package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.sun.tools.javac.Main;
import model.GameModel;
import model.players.Player;
import view.MainAreaPanel;
import view.MainWindow;

public class GameController extends WindowAdapter {
	MainWindow view;
	GameModel model;
	
	public GameController() {		
		
	}
	
	@Override
	public void windowClosing(WindowEvent event) {
		quit();
	}
	
	
	public void start() {
		this.view= new MainWindow(this);
		this.model = new GameModel(this);
		this.view.addWindowListener(this);
		this.view.setVisible(true);
	}
	
	public void quit() {		
		System.out.println("bye bye...");		
		System.exit(0);
	}
	
	
	public void selectPlayer(Player p, int pos) {
		this.model.selectPlayer(p, pos);	
		System.out.println("Player " + pos + " set to " + p);
		this.view.getTopPanel().getStartBtn().setEnabled(model.ready());
	}
	
	public void startGame() {
		this.model.setGameBoard(new String[3][3]);
		this.view.getTopPanel().getStartBtn().setEnabled(false);
		this.view.getMainPanel().showCard(MainAreaPanel.BOARD);
		this.view.getLeftPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
		this.view.getRightPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
	}

	/*public void restart()
	{
		if(model.endGame())
		{
			startGame();
			this.view.getTopPanel().getRestartBtn().setEnabled(false);
		}

	}
*/
	public void endGame(Player winner, Player loser, int gameType) {
		if(gameType == 1) {
			model.handleGameEnding(winner, loser, gameType);
			this.view.getTopPanel().getDoneBtn().setEnabled(true);
		}else if(gameType == 0) {
			model.handleGameEnding(winner, loser, gameType);
			this.view.getTopPanel().getDoneBtn().setEnabled(true);
		}
	}

	public void stopGame(){
		if(model.endGame()) {
			model.clearGamePanel();
			this.view.getMainPanel().repaint();
			this.view.getMainPanel().showCard(MainAreaPanel.HOF);
			this.view.getTopPanel().getStartBtn().setEnabled(true);
		}
	}

	public void botMove() {

	}
	public GameModel getModel() {
		return model;
	}
	
	public MainWindow getView() {
		return view;
	}
	
}
