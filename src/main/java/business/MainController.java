package business;

import persistence.MokInterfaceDataPlayer;


import java.util.Scanner;



public class MainController {

        private int amountPlayer;

        public void SetAmountPlayer(int amountPlayer) {
                this.amountPlayer = amountPlayer;
        }

        public int getAmountPlayer() {
                return amountPlayer;
        }
}