package persistence;

import business.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlayerList implements MokInterfaceDataPlayer {


  private Player player;

  @Override
        public List getDataPlayer() {
        return createList();
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
    public void addPlayerToList() {
        playerList.add(player);


    }

    public List createList(){
      List<Player> playerList = new LinkedList<>();

      return playerList;
    }
    public void showList(){
    System.out.println(playerList);
    }
    List<Player> playerList= new ArrayList<>();
}
