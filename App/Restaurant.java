package App;

import ClientMessages.CheckIn;
import Utils.Time;

import java.util.LinkedList;
import java.util.TreeMap;

public class Restaurant {

    //Lista de Mesas
    private LinkedList <Table> tables = new LinkedList<>();


    //cola de clientes
    private TreeMap<Time,Client> commensals = new TreeMap<>();

    //armando el resto
    public void addTable(int size){
        Table table = new Table(size);
        tables.add(table);
    }

    // llega commensal
    public CheckIn addCommensal(int size){

        Client client = new Client(size);
        Time time = new Time();
        Table table = aveilableTable(size);

        System.out.println("x");
        if(table != null && commensals.size() == 0){
           // a comer
            table.busy();
        }else{
            commensals.put(time,client);
        }

        return new CheckIn();
    }


    //se libera una mesa

    public void freeTable(int size){
        for(Table table : tables){
            if(table.size == size && !table.isReady()){
                freeTable(table);
            }
        }
    }
    private void freeTable(Table table){
        tables.get(tables.indexOf(table)).free();
        for(Time time : commensals.keySet()){
            if(table.fits(commensals.get(time).getSize())){
                table.free();
                return;
            }
        }

    }


    //busca el primero disponible y lo atiende
    public void attendClient(){

        for(Time time : commensals.keySet()){
            for(Table table : tables) {
                Client client = commensals.get(time);
                if (table.isReady() && table.fits(client.getSize())) {
                    client.call();
                    commensals.remove(time);
                    table.busy();
                }
            }
        }
    }

    // retorna la mesa si hay.
    // null cc.
    private Table aveilableTable(int size){
        for (Table t : tables){
            if(t.isReady()){
                if(t.fits(size)){
                    return t;
                }
            }
        }

        return null;
    }

    public String toString(){
        String s = "comensales  en cola= " + commensals.size();
        for(Table table : tables){
            s+= "\n" + table.isReady();
        }
        return s;
    }

}
