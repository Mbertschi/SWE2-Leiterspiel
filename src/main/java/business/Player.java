package business;


import java.util.Scanner;

public class Player implements PlayerInterface{

    private String name;

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

    public void createPlayer(){
        MainController mainController = new MainController();
        for(int i =0; i <= mainController.getAmountPlayer();i++){

        }
    }
}








