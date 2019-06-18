package console;

public class ConsoleMain {
    public static void main(String[] args) {

        Console console = new Console();
        console.initializePlayers();
        console.showList();
        console.startClient();

    }
}
