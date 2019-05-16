package business;



public class Rules {

    public static boolean validateNumberOfPlayer(String amountPlayer) {
        if(!amountPlayer.isEmpty()) {
            if(isNumeric(amountPlayer)) {
                Integer amountPlayerValue = Integer.valueOf(amountPlayer);
                if (amountPlayerValue >= 2 && amountPlayerValue <= 8) {
                    return true;
                } else {
                    return false;
                }
            }else{
                return false;
            }

        }
        else {
            return false;
        }
    }


    public static boolean isNumeric(String maybeNumeric){
        return maybeNumeric != null &&  maybeNumeric.matches("[0-9]+");

    }
}
