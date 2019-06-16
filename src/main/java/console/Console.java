package console;


import business.*;
import persistence.DataFieldState;
import persistence.PlayerList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private String numbersOfPlayers;
    private Scanner inputReader;
    private String lastUserInput;

    public Console() {
        this.inputReader = new Scanner(System.in);
    }


    public String getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    public void setNumbersOfPlayers(String numbersOfPlayers) {
        this.numbersOfPlayers = numbersOfPlayers;
    }

    Dice dice = new Dice();

    public void startClient() {

        System.out.println("\n\033[0;1m" + "Leiterspiel Rehan und Michi");
        System.out.println("----------------------------------------------------------------\n");

        this.printTableHeader();
        printTableContent();
        this.printTableFooter();
        getPlayerWhoIsInTurn();


        this.showMenu();
    }


    public void initializePlayers() {
        System.out.println("Bitte eine Spieleranzahl zwischen 2 und 8 eingeben");
        amountPlayerConsole();

    }

    public void amountPlayerConsole() {
        Scanner scannerPlayer = new Scanner(System.in);
        String numberOfPlayer = scannerPlayer.next();

        setNumbersOfPlayers(numberOfPlayer);
        validateNumber(getNumbersOfPlayers());
    }


    public void validateNumber(String numberOfPlayers) {
        if (Rules.validateNumberOfPlayer(numberOfPlayers)) {
            Integer amountPlayers = Converter.convertStringToInt(numberOfPlayers);
            createPlayer(amountPlayers);

        } else {
            System.out.println("ERROR: Eingabe überprüfen");

            initializePlayers();

        }
    }

    public void createPlayer(Integer amountPlayer) {
        Scanner scannerPlayerName = new Scanner(System.in);


        for (int i = 0; i < amountPlayer; i++) {
            int x = i + 1;
            System.out.println("Bitte geben sie den Spielernamen ein");
            System.out.print("Spieler " + x + " :");
            String playerName = scannerPlayerName.next();
            Player player = new Player(playerName);
            player.addPlayertoList(player);
            DataFieldState.getInstance().addStartfield();
        }


    }

    public void showList() {

        System.out.println(PlayerList.getInstance().getPlayerList());
        System.out.println(DataFieldState.getInstance().showList());
    }

    public static void printTableHeader() {
        System.out.format("+--------+-----------------+-----------------+------------+%n");
        System.out.format("| ID     | Spielername     | Aktuelles Feld  | Zielfeld   |%n");
        System.out.format("+--------+-----------------+-----------------+------------+%n");
    }

    public static void printTableContent() {

        String leftAlignFormat = "| %-6s | %-15s | %-15s | %-10s |%n";

        List<Player> players = PlayerList.getInstance().showList();
        List<Integer> fields = DataFieldState.getInstance().showList();
        Playfield playfield = new Playfield();

        for (int i = 0; i < PlayerList.getInstance().showList().size(); i++) {
            System.out.printf(
                    leftAlignFormat,
                    i,
                    players.get(i).getName(),
                    fields.get(i),
                    playfield.getFinishField()
            );
        }
    }

    public static void printTableFooter() {
        System.out.format("+--------+-----------------+-----------------+------------+%n");
    }

    public void showMenu() {
        System.out.println("\nWäle eine Option:");
        System.out.println("  1 - Würfeln");
        System.out.println("  q - Benden\n");

        // Wait for the user selection
        this.listenToMenuSelection();
    }

    private void listenToMenuSelection() {

        this.lastUserInput = this.inputReader.next();

        switch (this.lastUserInput) {
            case "1": {
                dice.rollConsol();
                startClient();
            }
            case "q": {
                // Tell the prozess to be exited with success
                System.exit(0);
            }
            default: {
                System.out.println("Bitte 1 oder q eingeben");
                startClient();
            }

        }
    }




    private Player getPlayerWhoIsInTurn() {
        List<Player> playerList = PlayerList.getInstance().getPlayerList();
        for (Player player : playerList) {
            int lastPlayerId = playerList.indexOf(player);
            lastPlayerId++;
            if (lastPlayerId == playerList.size()) {
                Player nextPlayer = playerList.get(0);
                System.out.println(nextPlayer.getName());
                return nextPlayer;
            }
            else {

                Player nextPlayer = playerList.get(lastPlayerId);
                System.out.println(nextPlayer.getName());
                return nextPlayer;
            }
        }

        return null;
    }

}

