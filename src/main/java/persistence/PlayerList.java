package persistence;

import business.MainController;
import business.Player;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PlayerList {

    private Player player;

    private static PlayerList setInstance = new PlayerList();
    public static PlayerList getInstance() {
        return setInstance;
    }

    private List<Player> playerList = new LinkedList<>();
    private List<Player> rankingList = new ArrayList<>();
    public List<Player> getRankingList() {
        return this.rankingList;
    }
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
                addPlayerToRankinglist(player);
                System.out.println(this.rankingList.get(0));
                this.playerList.remove(this.playerList.get(deletePlayerId));

                // if list only contains one player then game is over and last scene displays
                if( this.playerList.size() == 1){
                    addPlayerToRankinglist(this.playerList.get(0));
                    MainController mainController = new MainController();
                    mainController.routeChangeToLastScene();
                    System.out.print(this.rankingList.size());
                }

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
    private void addPlayerToRankinglist(Player player){
        rankingList.add(player);
    }
}
