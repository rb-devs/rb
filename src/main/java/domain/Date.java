package domain;

import org.dom4j.datatype.DatatypeAttribute;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Date implements Comparable<Date> {
    private java.util.Date date;

    public Date() {
        date = new java.util.Date();
    }

    public Date(int year, int month, int day, int hourOfDay, int minutes) {
        date = new GregorianCalendar(year, month - 1, day, hourOfDay, minutes).getTime();
    }

    private Date(long milli) {
        date = new java.util.Date(milli);
    }

    @Override
    public int compareTo(Date date2) {
        return this.date.compareTo(date2.date);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(date.getTime());
    }

    public static Date getUTCDate(Date localDate) {
        String timeZone = Calendar.getInstance().getTimeZone().getID();
        return new Date(localDate.getTime() - TimeZone.getTimeZone(timeZone).getOffset(localDate.getTime()));
    }

    /**
     * @return LOCAL date
     */
    public static Date now() {
        return new Date();
    }

    public long getTime() {
        return date.getTime();
    }

    public static Date getLocalDate(Date UTCDate) {
        String timeZone = Calendar.getInstance().getTimeZone().getID();
        return new Date(UTCDate.getTime() + TimeZone.getTimeZone(timeZone).getOffset(UTCDate.getTime()));
    }

    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public int getMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public int getDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getHourOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinutes() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }
//    public static void main(String[] args) {
////        Date check = new Date();
////        System.out.println(check.toString() + "\n" + Date.now().toString());
////        java.util.Date date = new java.util.Date();
////        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
////        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
////        System.out.println("UTC Time is: " + dateFormat.format(date)); // to UTC
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
//        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//        Date check = new Date(2012,12,12,13,0);
//
//        Date date = new Date(2017,1,12,13,0);
//        GregorianCalendar calendar = new GregorianCalendar(2012,10,12,13,0);
//        System.out.println(getLocalDate(date).toString()); //from UTC
//    }
}
