package console;



public class ConsoleMain {
    public static void main(String[] args) {

        Console console = new Console();


        console.start();
        console.initializePlayers();
        console.showList();

        console.printTableHeader();
        console.printTableContent();
        console.printTableFooter();


    }
}
