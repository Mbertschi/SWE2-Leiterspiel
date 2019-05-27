package persistence;

import business.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;


public class PlayerList implements MokInterfaceDataPlayer {


    private Player player;

    private static PlayerList setInstance = new PlayerList();
    public static PlayerList getInstance() {
        return setInstance;
    }

    private List<Player> playerList = new LinkedList<>();
    private void setPlayerList(Player player) {
        this.playerList.add(player);
    }
    public List<Player> getPlayerList() {
        return this.playerList;
    }

    @Override
    public void getDataPlayer() {

    }

    @Override
    public void SetDataPlayer() {

    }

    @Override
    public void updateDataPlayer() {

    }

    @Override
    public void SaveDataPlayer() {

    }

    @Override
    public void addPlayerToList(Player player) {
        setPlayerList(player);
    }

    public  Integer sizeOfList(){
        int x = getPlayerList().size();
        return x;
    }

    public Player showList(int i){
        player = getPlayerList().get(i);
        return player;
    }

//    public ListView<Player>  showList(){
//        System.out.println(playerList);
//        playerListView.setItems(playerListOb);
//        return playerListView;
//    }
}
