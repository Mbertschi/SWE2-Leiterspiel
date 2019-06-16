package console;


import business.Converter;
import business.Field;
import business.Player;
import business.Rules;
import persistence.DataFieldState;
import persistence.PlayerList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private String numbersOfPlayers;

    public String getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    public void setNumbersOfPlayers(String numbersOfPlayers) {
        this.numbersOfPlayers = numbersOfPlayers;
    }






    public void start(){
        System.out.println("Leiterspiel by Rehan & Michi");


    }

    public void initializePlayers(){
        System.out.println("Bitte eine Spieleranzahl zwischen 2 und 8 eingeben");
        amountPlayerConsole();

    }

    public void amountPlayerConsole(){
        Scanner scannerPlayer = new Scanner(System.in);
        String numberOfPlayer = scannerPlayer.next();

         setNumbersOfPlayers(numberOfPlayer);
         validateNumber(getNumbersOfPlayers());
    }

   // String numberOfPlayers = amountPlayerConsole();

    public void validateNumber( String numberOfPlayers ) {
        //String numberOfPlayers = amountPlayerConsole();
        if (Rules.validateNumberOfPlayer(numberOfPlayers)) {
            Integer amountPlayers = Converter.convertStringToInt(numberOfPlayers);
            createPlayer(amountPlayers);

        } else {
            System.out.println("ERROR: Eingabe überprüfen");

            initializePlayers();

        }
    }

    public void createPlayer(Integer amountPlayer){
        Scanner scannerPlayerName = new Scanner(System.in);


        for(int i =0; i <amountPlayer; i++ ){
            int x = i+1;
            System.out.println("Bitte geben sie den Spielernamen ein");
            System.out.print("Spieler "+x+" :");
            String playerName = scannerPlayerName.next();
            Player player = new Player(playerName);
            player.addPlayertoList(player);
        }

    }

    public void showList(){

          System.out.println(PlayerList.getInstance().getPlayerList());
    }

    public static void printTableHeader() {
        System.out.format("+--------+-----------------+-----------------+------------+%n");
        System.out.format("| ID     | Spielername     | Aktuelles Feld  | Zielfeld   |%n");
        System.out.format("+--------+-----------------+-----------------+------------+%n");
    }

    public static void printTableContent() {

        String leftAlignFormat = "| %-6s | %-15s | %-15s | %-15s |%n";

        List<Player> players = PlayerList.getInstance().showList();


        for(int i = 0; i < PlayerList.getInstance().showList().size(); i++) {
            System.out.printf(
                    leftAlignFormat,
                    i,
                    players.get(i).getName()
            );
        }
    }

    public static void printTableFooter() {
        System.out.format("+--------+-----------------+-----------------+------------+%n");
    }


}
