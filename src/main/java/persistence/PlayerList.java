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

        this.playerList.remove(this.playerList.get(playerId));
        this.playerNumbers.remove(this.playerList.get(playerId));

        System.out.println("Now is turn Player: " + this.playerList.get(nextPlayerId).getName());
        this.playerList.get(nextPlayerId).setPlayerTurn(true);
    }

    // ToDo : check in debugging the index of new list after first player won and deleted in list
    private int chooseNextPlayer(int deletedPlayerId) {
        System.out.println(deletedPlayerId);
        boolean playerFound = false;
        for (Player player : this.playerList) {
            if(playerFound) {
                return this.playerList.indexOf(player);
            }
            else {
                if(deletedPlayerId == this.playerList.indexOf(deletedPlayerId)) {
                    playerFound = true;
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
}
