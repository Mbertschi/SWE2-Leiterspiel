package business;


import javafx.scene.control.TextField;

import java.util.ArrayList;
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
        Scanner playerName = new Scanner(System.in);

    }

    @Override
    public void displayPlayer() {

    }

    public TextField createPlayer(String nubmerOfPlayer){

        int playerNumbers = Integer.parseInt(nubmerOfPlayer);

        for(int i = 0; i <= playerNumbers; i++){

            createTexfield(i);

        }
        return new TextField();
    }

    public TextField createTexfield( int s){


        return new TextField("Spielername"+s);
    }
}








