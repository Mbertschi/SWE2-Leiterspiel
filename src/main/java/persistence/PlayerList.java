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
    private List<Integer> playerNumbers = new ArrayList<>();
    public void setPlayerNumbers(Player player) {
        this.playerNumbers.add(player.getPlayerNumber());
    }
    private List<Integer> getPlayerNumbers() {
        return this.playerNumbers;
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

    // ToDo : check in debugging the index of new list after first player won and deleted in list
    private int chooseNextPlayer(int deletePlayerId) {
        System.out.println(deletePlayerId);
        int idOfNewLastPlayer = this.playerList.size() - 1;
        for (Player player : this.playerList) {

            if(deletePlayerId == this.playerList.indexOf(player)) {
                this.playerList.remove(this.playerList.get(deletePlayerId));
                this.playerNumbers.remove(this.playerNumbers.get(deletePlayerId));
                // set all players their playerturn on false

                int i = 0;
                for(Player playerTurn : this.playerList) {
                    this.playerList.set(i, playerTurn).setPlayerTurn(false);
                    i++;
                }

                // if delete the last player in the list then get the first -> 0
                if(deletePlayerId == idOfNewLastPlayer) {
                    return 0;
                }
                else {
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
