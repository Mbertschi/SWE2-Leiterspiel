package business;


import javafx.scene.control.ListView;
import persistence.PlayerList;

public class Player implements PlayerInterface{

    private String name;
    private ColorCircle colorCircle;


    public Player(String name) {
        this.name = name;


    }

    public Player(String name, ColorCircle colorCircle){
        this.name= name;
        this.colorCircle= colorCircle;
    }

    @Override
    public String toString() {
        return this.name;
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
    public void addPlayertoList(Player player){
        PlayerList.getInstance().addPlayerToList(player);
    }

    @Override
    public ListView<Player> displayPlayer() {
        PlayerList.getInstance().showList();

        return PlayerList.getInstance().showList();
    }





}








