package business;


import javafx.scene.control.ListView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import persistence.PlayerList;

public class Player {

    private String name;
    private Circle colorCircle;
    private Integer playerPlayFieldCellNumber;
    private Integer playerNumber;

    public Player() {
    }

    public Player(Integer playerNumber, String name, Circle colorCircle, Integer playerPlayFieldCellNumber) {
        this.playerNumber = playerNumber;
        this.name = name;
        this.colorCircle = colorCircle;
        this.playerPlayFieldCellNumber = playerPlayFieldCellNumber;
        setPlayerNumber(this.playerNumber);
        setName(this.name);
        setCircle(this.colorCircle);
        setPlayerPlayFieldCellNumber(this.playerPlayFieldCellNumber);
    }

    @Override
    public String toString() {
        return this.name;
    }

    private void setPlayerNumber(Integer playerNumber) {
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

    private void setCircle(Circle circle) {
        this.colorCircle = circle;
    }
    public Circle getCircle() {
        return this.colorCircle;
    }

    private void setPlayerPlayFieldCellNumber(Integer playerPlayFieldCellNumber) {
        this.playerPlayFieldCellNumber = playerPlayFieldCellNumber;
    }
    public Integer getPlayerPlayFieldCellNumber() {
        return this.playerPlayFieldCellNumber;
    }

    public void addPlayertoList(Player player) {
        PlayerList.getInstance().addPlayerToList(player);
    }

    public Player getPlayer(int x) {
        return PlayerList.getInstance().showList(x);
    }
}








