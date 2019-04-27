package persistence;

import business.Player;
import business.MainController;
import java.util.LinkedList;
import java.util.List;


public class PlayerList implements MokInterfaceDataPlayer {


    private Player player;

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
    public void addPlayerToList() {

      createList().add(new Player(""));


    }

    public List<Player> createList(){
      List<Player> playerList = new LinkedList<>();

      return playerList;
    }

    public void  showList(){



    }
}
