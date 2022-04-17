import javax.swing.*;

public class MainMenu{
        JFrame frame;
public void mainMenu() {
        frame = new JFrame("TucTacToe");

        JButton button;

        button = new JButton("Click");
        button.setBounds(frame.getSize().width/10 , frame.getSize().height/10 , 60,20);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800,600);
        
        frame.add(button);
    }
}
