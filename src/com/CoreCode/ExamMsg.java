package com.CoreCode;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/617:47
 */
public class ExamMsg {
    private String course;
    private int month;
    private int day;
    private String beginTime;
    private String endTime;
    private String location;

    public ExamMsg(String course, int month, int day, String beginTime, String endTime, String location) {
        this.course = course;
        this.month = month;
        this.day = day;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.location = location;
    }
    public ExamMsg(String course, int month, int day, int hour, int minute, int duration, String location) {
        this.course = course;
        this.month = month;
        this.day = day;
        if (minute == 0) {
            this.beginTime = hour + ":00";
        }
        else {
            this.beginTime = hour + ":" + minute;
        }
        int endHour = (hour * 60 + minute + duration) / 60;
        int endMinute = (hour * 60 + minute + duration) % 60;
        if (endMinute == 0) {
            this.endTime = endHour + ":00";
        }
        else {
            this.endTime = endHour + ":" + endMinute;
        }
        this.location = location;
    }
    @Override
    public String toString() {
        return course + " " + month + " " + day + " " + beginTime + " " + endTime + " " + location;
    }

    public String getCourse() {
        return course;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
