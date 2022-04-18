package com.CoreCode;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 课外活动信息
 * @date 2022/4/1013:45
 */
public class OutClassActivityMsg {
    private String activityType; // 课外活动类型, 个人活动或集体活动
    private String activityName; // 课外活动名称
    private int month; // 活动月份
    private int day; // 活动日期
    private String beginTime; // 活动起始时间，如 19:00
    private String endTime; // 活动结束时间，如2 0:00
    private String location; // 活动地点

    public OutClassActivityMsg(String activityType, String activityName, int month, int day, String beginTime, String endTime, String location) {
        this.activityType = activityType;
        this.activityName = activityName;
        this.month = month;
        this.day = day;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.location = location;
    }
    public OutClassActivityMsg(String activityType, String activityName, int month, int day, int hour, int minute, int duration, String location) {
        this.activityType = activityType;
        this.activityName = activityName;
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
        return activityType + " " + activityName + " " + month + " " + day + " " + beginTime + " " + endTime + " " + location;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getActivityName() {
        return activityName;
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

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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
