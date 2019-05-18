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
    private ObservableList<Player> playerListOb = FXCollections.observableArrayList();
    private ListView<Player>playerListView= new ListView<>();
    List<Player> playerList = new LinkedList<>();
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
        playerListOb.add(player);
        playerList.add(player);


    }




    public ListView<Player>  showList(){
        System.out.println(playerList);
        playerListView.setItems(playerListOb);
        return playerListView;
    }
}
