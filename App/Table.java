package App;

import ClientMessages.CheckOut;
import Utils.State;
import Utils.TableSpace;

public class Table {

    private TableSpace space = new TableSpace();
    private State state = new State();
    private Client client;

    //temporal
    int size;

    public Table(int size){
        this.size = size;
    }

    public CheckOut free(){
        state.setFree();
        return new CheckOut();
    }

    public void busy(){
        state.setBusy();
    }

    public boolean isReady(){
        return state.isReady();
    }

    public boolean fits(int size){
        return space.fits(size);
    }




}
