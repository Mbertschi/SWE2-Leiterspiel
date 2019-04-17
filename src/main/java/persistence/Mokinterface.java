package persistence;

import business.Player;

import java.util.List;

public interface Mokinterface {

    public void getPlayer();
    public void setPlayer();
    public void updatePlayer();
    public void createLinkedList();
    public void addPlayerToList();
    List<Player> selectAllPlayers();




}
