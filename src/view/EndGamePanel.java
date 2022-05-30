package view;

import javax.swing.*;

public class EndGamePanel{

    JPanel jp;
    JButton[] jb;
    JTextPane jText;
    public EndGamePanel() {
        jp = new JPanel();
        jb = new JButton[2];

        jp.setSize(600,200);

        jText = new JTextPane();


    }
}
