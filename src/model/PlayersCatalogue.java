package model;

import model.players.Player;
import model.players.Bean;
import model.players.Hal;
import arraylist.Array_List;
import control.GameController;

import java.io.*;

public class PlayersCatalogue {


	int NumOfPlayers;
    Array_List players;


    public PlayersCatalogue(GameController gc){

        GameModel gm = gc.getModel();
        players = new Array_List(50);

        Player p1 = new Player("Namios", 20, 10, 5, 5, gc, gm);
        Player p2 = new Player("smt", 10, 5, 3, 2, gc, gm);
        Bean bean = new Bean("Mr. Bean", 20, 6, 2, 12, gc);
        Hal hal9000 = new Hal("Hal 9000", 40, 25, 2, 13, gc);

        players.add(p1);
        players.add(p2);
        players.add(bean);
        players.add(hal9000);

        NumOfPlayers = players.size();

    }

    public void addPlayer(Player player) {
        players.add(player);
        NumOfPlayers++;
    }

    public Array_List getPlayers() {
        return players;
    }

    public Player[] getPlayerArray() {
        Player[] tmpArray = new Player[NumOfPlayers];
        for (int i = 0; i < NumOfPlayers; i++) {
            tmpArray[i] = (Player) players.get(i);
        }
        return tmpArray;
    }

    public String[] getPlayerNames() {
        String[] tmpArray = new String[NumOfPlayers];
        Player p;
        for (int i = 0; i < players.size(); i++) {
            p = (Player) players.get(i);
            tmpArray[i] = p.getNickname();
        }
        return tmpArray;
    }

    public Player findByName(String name) {

        Player p;

        for (int i = 0; i < players.size(); i++) {

            p = (Player) players.get(i);

            if( p.getNickname().equals(name) ){
                System.out.println(p.getNickname());
                return p;
            }

        }

        return null;
    }

    public int getNumOfPlayers(){
        return NumOfPlayers;
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
