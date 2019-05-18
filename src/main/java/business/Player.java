package business;


import javafx.scene.control.TextField;
import persistence.PlayerList;


import java.util.Scanner;

public class Player implements PlayerInterface{

    private String name;
    private int amountPlayerValue;


    public Player(String name) {
        this.name = name;

    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int amoutnPlayer() {
        return 0;
    }

    @Override
    public void updatePlayer() {

    }


    @Override
    public void displayPlayer() {
        PlayerList.getInstance().showList();
    }

//    public Player createPlayer(String nubmerOfPlayer){
//        Player player = new Player("");
//        int playerNumbers = Integer.parseInt(nubmerOfPlayer);
//
//        for(int i = 0; i <= playerNumbers; i++){
//
//            new Player("");
//
//        }
//        return player;
//    }



}








