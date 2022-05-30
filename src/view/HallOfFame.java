package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import control.GameController;

public class HallOfFame extends GamePanel{
	
	
	public HallOfFame(GameController gc) {
		super(gc);		
	}
	
	@Override
	public void paint(Graphics g) {
		int x = this.getWidth()/2 - 50;
		int y = this.getHeight()/2;		
		g.drawString("Hall Of Fame", x, y);
		//g.drawString();
	}

}
