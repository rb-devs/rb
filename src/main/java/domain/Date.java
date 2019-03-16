package domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Date implements Comparable<Date> { //format "yyyy-MM-dd HH:mm"
    private String date;

    public Date(String date){
        this.date = date;
    }

    @Override
    public String toString(){
        return date;
    }

    @Override
    public int compareTo(Date o) {
        return (date.compareTo(o.toString()));
    }
}