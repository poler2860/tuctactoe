package model;

import model.players.Player;
import arraylist.Array_List;
import java.io.*;

public class PlayersCatalogue {


	int NumOfPlayers;

    public PlayersCatalogue(){


    }

    public void addPlayer(Player player){
        try{
            FileOutputStream fileOut = new FileOutputStream("tuctactoe.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved at tuctactoe.ser");
        } catch (IOException i){
            i.printStackTrace();
        }
    }

    public Player[] getPlayers() {

        Player[] playerArray = new Player[NumOfPlayers];
        Player tmpPlayer;

        for(int i = 0; i < NumOfPlayers; i++) {

            tmpPlayer = null;

            try {
                FileInputStream fileIn = new FileInputStream("tuctactoe.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);

                tmpPlayer = (Player) in.readObject();

                in.close();
                fileIn.close();
            } catch (IOException ie) {
                ie.printStackTrace();
                //return;
            }  catch (ClassNotFoundException c) {
                System.out.println("Class not found.");
                c.printStackTrace();
                //return;
            }

            playerArray[i] = tmpPlayer;
        }

        return playerArray;
    }

}
