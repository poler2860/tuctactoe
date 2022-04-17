import javax.swing.*;

public class MainMenu{
public void mainMenu() {
        JFrame frame;
        frame = new JFrame("TucTacToe");
        frame.setLayout(null);
        frame.setVisible(false);
        frame.setSize(800,600);

        JButton button;


        button = new JButton("Click");
        button.setBounds(100, 200 , 60,20);

        frame.add(button);

    }
}
