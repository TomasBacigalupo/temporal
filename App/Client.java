package App;

import ClientMessages.CheckOut;
import ClientMessages.TableReady;

import java.util.HashMap;

public class Client {
    HashMap<String,Person> persons = new HashMap<>();

    private int size;

    private int priority;

    public void call(){
        new TableReady();
    }

    public Client(int size, int priority){
        this.size = size;
        this.priority = priority;
    }

    public Client(int size){
        this.size = size;
        this.priority = 0;
    }

    public CheckOut finish(){

        return new CheckOut();
    }

    public int getSize() {
        return size;
    }
}
