package persistence;

import business.Field;

import java.util.ArrayList;
import java.util.List;

public class DataFieldState implements MokInterfaceDataFieldState {

    List<Field> fildState = new ArrayList();
    private static DataFieldState setInstance = new DataFieldState();
    public static DataFieldState getInstance() {
        return setInstance;
    }

    @Override
    public List getDataFieldState() {
        return null;
    }

    @Override
    public void updateFieldState() {

    }

    @Override
    public void saveFieldState() {

    }

    public void addFieldsToList(Field field){
        fildState.add(field);
    }


}
