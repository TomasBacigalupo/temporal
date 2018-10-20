package Utils;

import java.util.Date;

public class Time extends Date {
    int seconds;
    int minutes;
    int hours;

    public Time(){
        Date date = new Date();
        seconds = date.getSeconds();
        minutes = date.getMinutes();
        hours = date.getHours();
    }


    public int compareTo(Time time){
        if(time.hours != this.hours){
            return hours - time.hours;
        }
        if(time.minutes != minutes){
            return minutes - time.minutes;
        }
        if(time.seconds != seconds){
            return seconds - time.seconds;
        }
        return 0;
    }


}
