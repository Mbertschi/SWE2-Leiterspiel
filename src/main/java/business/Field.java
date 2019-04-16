package business;

import java.util.Objects;

public class Field {
    private int fieldNummer;

    public int getFieldNummer() {
        return fieldNummer;
    }

    public void setFieldNummer(int fieldNummer) {
        this.fieldNummer = fieldNummer;
    }

    public Field(int fieldNummer){
        this.fieldNummer=  fieldNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;
        Field field = (Field) o;
        return fieldNummer == field.fieldNummer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldNummer);
    }
}
