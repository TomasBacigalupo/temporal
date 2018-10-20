package Utils;

public class State {
     boolean busy;
     boolean free = true;


    public boolean isReady(){
        return free;
    }

    public void setBusy(){
        this.busy = true;
        this.free = false;
    }

    public void setFree(){
        busy = false;
        free = true;
    }
}
