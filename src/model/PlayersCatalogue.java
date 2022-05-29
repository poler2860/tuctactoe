package model;

import model.players.Player;
import arraylist.Array_List;
import control.GameController;

import java.io.*;

public class PlayersCatalogue {


	int NumOfPlayers;
    Array_List players;


    public PlayersCatalogue(GameModel gm, GameController gc){

        players = new Array_List(50);

        Player p1 = new Player("Namios", 20, 10, 5, 5, gc, gm);
        Player p2 = new Player("smt", 10, 5, 3, 2, gc, gm);
        Player p3 = new Player("getOut", 30, 20, 5, 5, gc, gm);

        players.add(p1);
        players.add(p2);
        players.add(p3);


    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Array_List getPlayers() {
        return players;
    }
/*
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

 */

}
