package domain;

import java.time.format.DateTimeFormatter;

public class Date implements Comparable<Date> { //format "yyyy-MM-dd HH:mm"
    private final String format = "yyyy-MM-dd HH:mm";
    private String date;

    public Date(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public int getYear() {
        return java.time.LocalDate.parse(date, DateTimeFormatter.ofPattern(format)).getYear();
    }

    public int getMonth() {
        return java.time.LocalDate.parse(date, DateTimeFormatter.ofPattern(format)).getMonthValue();
    }

    public int getDay() {
        return java.time.LocalDate.parse(date, DateTimeFormatter.ofPattern(format)).getDayOfMonth();
    }

    public int getHourOfDay() {
        return java.time.LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format)).getHour();
    }

    public int getMinute() {
        return java.time.LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format)).getMinute();
    }

    @Override
    public String toString() {
        return date;
    }

    @Override
    public int compareTo(Date o) {
        return (date.compareTo(o.toString()));
    }

//    public static void main(String[] args){
//        Date date = new Date("2014-10-11 13:00");
//        System.out.println(date.getYear()+","+date.getMonth()+","+date.getDay()+","+date.getHourOfDay()+","+date.getMinute());
//    }
}