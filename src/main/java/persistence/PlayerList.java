package persistence;

import business.Player;

import java.util.LinkedList;
import java.util.List;

public class PlayerList implements MokInterfaceDataPlayer {






    @Override
        public List getDataPlayer() {
        return creatList();
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

    creatList().add(new Player(""));


    }

    public List creatList(){
      List<Player> playerList = new LinkedList<>();

      return playerList;
    }
}
