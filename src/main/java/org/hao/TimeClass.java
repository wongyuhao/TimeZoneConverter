package org.hao;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeClass extends TimeController{

    private  final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a z";
    private  final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private ZonedDateTime time;

    private ZoneId timeZone;

    public TimeClass(){
        this.timeZone= ZoneId.systemDefault();
    }

    public TimeClass(String zoneString){
        this.setTimeZone(zoneString);
    }

    public String getTime(){

        return formatter.format(time.now(this.timeZone));
    }

    public void setTimeZone(String zoneString){
        this.timeZone= ZoneId.of(zoneString);
    }

    public String getTimeZoneAsString (){
        return this.timeZone.toString();
    }

    @Override
    public String toString(){
        return this.timeZone.toString() + ": "+ this.getTime();
    }
}
