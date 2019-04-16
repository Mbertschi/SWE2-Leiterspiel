package business;

import persistence.MokInterfaceDataPlayer;


import java.util.Scanner;



public class MainController {
        Player player;

        public int setAmountPlayerIn( Scanner amountPlayerIn) {
               amountPlayerIn.nextInt() ;

               return amountPlayerIn.nextInt();
        }

        private int numberOfPlayers;
        Scanner amountPlayerIn = new Scanner(System.in);
        Scanner playerName = new Scanner(System.in);

        public Object createPlayer( ){
                for (int i=0; i== amountPlayerIn.nextInt() ; i++){


                        System.out.println("Bitte geben sie ihren Namen ein");
                        new Player(namePlayer());




                }




                return player;

        }







        public String namePlayer(){
                playerName.next();
                return namePlayer();
        }


        public void setAmountPlayerIn() {
        }
}