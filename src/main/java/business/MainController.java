package business;

import persistence.MokInterfaceDataPlayer;


import java.util.Scanner;



public class MainController {
        Player player;

        public  void startPlay(){
               System.out.println("Herzlich Willkomen zum Leiterspiel");
        }

        public  void numberOfPlayer() {

                System.out.println("Bitte geben sie die Anzahl spieler ein");

        }

        Scanner amountPlayerIn = new Scanner(System.in);
        Scanner playerName = new Scanner(System.in);

        public int setAmountPlayerIn( Scanner amountPlayerIn) {


                 setAmountPlayerIn();

               return amountPlayerIn.nextInt();
        }




        public PlayerInterface createPlayer( ){
                for (int i=0; i== amountPlayerIn.nextInt() ; i++){




                        new Player("");



                }




                return null;

        }







        public String namePlayer(){
                playerName.next();
                return namePlayer();
        }


        public void setAmountPlayerIn() {
        }
}