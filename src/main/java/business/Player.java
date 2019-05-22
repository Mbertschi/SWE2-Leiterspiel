package business;


import javafx.scene.control.ListView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import persistence.PlayerList;

public class Player {

    private Player player;
    private String name;
    private Circle colorCircle;

    public Player() {
    }

    public Player(String name, Circle colorCircle) {
        this.name = name;
        this.colorCircle = colorCircle;
    }

    @Override
    public String toString() {
        return this.name;
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

    public void addPlayertoList(Player player) {
        PlayerList.getInstance().addPlayerToList(player);
    }

    public Player getPlayer(int x) {
        this.player = PlayerList.getInstance().showList(x);
        setName(player.name);
        setCircle(player.colorCircle);
        return PlayerList.getInstance().showList(x);
    }





}








