package console;


import business.Playfield;


public class ConsoleMain {
    public static void main(String[] args) {

        Console console = new Console();
        Playfield p1 = new Playfield();


        console.start();
        console.initializePlayers();
        console.showList();
        p1.creatConsolPlayfield();


        console.printTableHeader();
        console.printTableContent();
        console.printTableFooter();


    }
}
