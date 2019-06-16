package persistence;

import business.Player;

import java.util.ArrayList;
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

    public void RemovePlayerFromList(Player player) {
        int playerId = this.playerList.indexOf(player);
        int nextPlayerId = this.chooseNextPlayer(playerId);

        for (Player playerTurn : this.playerList) {
            int idx = this.playerList.indexOf(playerTurn);
            System.out.println("Index:  " + idx + "-- Player : " + this.playerList.get(idx).getName() + "-- Turn :" + this.playerList.get(idx).getPlayerTurn());
        }

        this.playerList.get(nextPlayerId).setPlayerTurn(true);
        System.out.println("Now is turn Player: " + this.playerList.get(nextPlayerId).getName() + "-- Turn :" + this.playerList.get(nextPlayerId).getPlayerTurn());
    }

    private int chooseNextPlayer(int deletePlayerId) {
        System.out.println(deletePlayerId);
        for (Player player : this.playerList) {

            if(deletePlayerId == this.playerList.indexOf(player)) {
                this.playerList.remove(this.playerList.get(deletePlayerId));

                if(deletePlayerId == 0) {
                    int lastPlayerIdx = this.playerList.size() - 1;
                    return lastPlayerIdx;
                }
                else {
                    deletePlayerId = deletePlayerId - 1;
                    return deletePlayerId;
                }
            }
        }
        return 0;
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

    public List<Player>  showList() {


        return playerList;
    }

}
