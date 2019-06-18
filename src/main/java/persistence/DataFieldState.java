package persistence;

import java.util.ArrayList;
import java.util.List;

public class DataFieldState  {

    private Integer playFieldState;

    List<Integer> fildState = new ArrayList();
    private static DataFieldState setInstance = new DataFieldState();
    public static DataFieldState getInstance() {
        return setInstance;
    }

    public Integer showList(int i){
        playFieldState = this.fildState.get(i);
        return playFieldState;
    }
    public List<Integer>  showList() {


        return this.fildState;
    }

    public void addStartfield() {
        fildState.add(startField);
    }
    private int startField = 1;
}
