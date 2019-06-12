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
        this.playerList.remove(this.playerList.get(playerId));
        int nextPlayerId = this.chooseNextPlayer(playerId);

        System.out.println("Now is turn Player: " + this.playerList.get(nextPlayerId).getName());
        this.playerList.get(nextPlayerId).setPlayerTurn(true);
    }

    private int chooseNextPlayer(int deletedPlayerId) {
        boolean playerDeleted = false;
        for(int number : this.getPlayerNumbers()) {
            if(!playerDeleted) {
                if(number == deletedPlayerId && !playerDeleted);
                this.playerNumbers.remove(deletedPlayerId);
                playerDeleted = true;
                for (Player player : this.getPlayerList()) {
                    // get first player
                    if(deletedPlayerId == 0) {
                        return player.getPlayerNumber();
                    }
                    // get some player which now comes as next
                    if(player.getPlayerNumber() == deletedPlayerId) {
                        return player.getPlayerNumber();
                    }
                    // get last player
                    if(this.getPlayerList().size() == deletedPlayerId) {
                        return player.getPlayerNumber();
                    }
                }
            }
            else {
                // ToDo : delete this because this will never happen
                // ToDo : i WAS HERE
                System.out.println(number);
                return this.playerNumbers.get(number);
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
