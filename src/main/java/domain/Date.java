package domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
    private GregorianCalendar date;

    public Date() {
        date = new GregorianCalendar();
    }

    public Date(int year, int month, int day) {
        date = new GregorianCalendar(year, month, day);
    }

    @Override
    public int compareTo(Date date2) {
        return this.date.compareTo(date2.date);
    }

    @Override
    public String toString() {
        return (this.date.get(Calendar.YEAR)
                + "."
                + this.date.get(Calendar.MONTH)
                + "."
                + this.date.get(Calendar.DAY_OF_MONTH));
    }

    public int getYear() {
        return this.date.get(Calendar.YEAR);
    }

    public int getMonth() {
        return this.date.get(Calendar.MONTH);
    }

    public int getDayOfMonth() {
        return this.date.get(Calendar.DAY_OF_MONTH);
    }
}
