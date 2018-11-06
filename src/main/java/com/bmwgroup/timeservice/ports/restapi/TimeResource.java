package com.bmwgroup.timeservice.ports.restapi;

public class TimeResource {
    private int seconds;
    private int minutes;
    private int hours;
    private int day;
    private int month;
    private int year;

    public TimeResource(int seconds, int minutes, int hours, int day, int month, int year) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
