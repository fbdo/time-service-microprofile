package com.bmwgroup.timeservice.adapters.worldtime;


import javax.json.bind.annotation.JsonbProperty;

public class WorldTime {

    @JsonbProperty("week_number")
    private  String weekNumber;


    @JsonbProperty("utc_offset")
    private String utcOffset;

    private String unixtime;

    private String timezone;


    @JsonbProperty("dst_until")
    private String dstUntil;

    @JsonbProperty("dst_from")
    private String dstFrom;

    private boolean dst;

    @JsonbProperty("day_of_year")
    private int dayOfYear;

    private String datetime;

    private String abbreviation;


    public String getWeekNumber() {
        return weekNumber;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public String getUnixtime() {
        return unixtime;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getDstUntil() {
        return dstUntil;
    }

    public String getDstFrom() {
        return dstFrom;
    }

    public boolean isDst() {
        return dst;
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setDstUntil(String dstUntil) {
        this.dstUntil = dstUntil;
    }

    public void setDstFrom(String dstFrom) {
        this.dstFrom = dstFrom;
    }

    public void setDst(boolean dst) {
        this.dst = dst;
    }

    public void setDayOfYear(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
