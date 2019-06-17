package business;

import javafx.scene.paint.Color;
import persistence.DataFieldState;
import persistence.PlayerList;

public class Player {

    private String name;
    private Color playerColor;
    private Integer playerPlayFieldCellNumber;
    private Integer playerNumber;
    private Boolean playerTurn;

    public Player() {
    }

    public Player(String name){
        setName(name);
    }

    public Player(Integer playerNumber, String name, Color playerColor, Integer playerPlayFieldCellNumber, Boolean playerTurn) {
        setPlayerNumber(playerNumber);
        setName(name);
        setPlayerColor(playerColor);
        setPlayerPlayFieldCellNumber(playerPlayFieldCellNumber);
        setPlayerTurn(playerTurn);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }
    public Integer getPlayerNumber() {
        return this.playerNumber;
    }

    private void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private void setPlayerColor(Color color) {
        this.playerColor = color;
    }
    public Color getPlayerColor() {
        return this.playerColor;
    }

    public void setPlayerPlayFieldCellNumber(Integer playerPlayFieldCellNumber) {
        this.playerPlayFieldCellNumber = playerPlayFieldCellNumber;
    }
    public Integer getPlayerPlayFieldCellNumber() {
        return this.playerPlayFieldCellNumber;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Boolean getPlayerTurn() {
        return this.playerTurn;
    }

    public void addPlayertoList(Player player) {
        PlayerList.getInstance().addPlayerToList(player);
    }

    public Player getPlayer(int x) {
        return PlayerList.getInstance().showList(x);
    }


}








