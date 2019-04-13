package business;

public class SpecialField extends Field {


    public SpecialField(int fieldNummer) {
        super(fieldNummer);
    }

    public int goUP(){
        return getFieldNummer();
    }
    public int goDown(){
        return getFieldNummer();
    }
}
