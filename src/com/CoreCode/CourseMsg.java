package com.CoreCode;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 课程信息
 * @date 2022/4/319:56
 */
public class CourseMsg {
    private String courseName; // 课程名称
    private int weekDay; // 星期几上课
    private String courseBeginTime; // 课程开始时间
    private String courseEndTime; // 课程结束时间
    private String coursePlace; // 上课地点
    private String courseTeacher; // 上课教师

    public CourseMsg(String courseName, int weekDay, String courseBeginTime, String courseEndTime, String coursePlace, String courseTeacher) {
        this.courseName = courseName;
        this.weekDay = weekDay;
        this.courseBeginTime = courseBeginTime;
        this.courseEndTime = courseEndTime;
        this.coursePlace = coursePlace;
        this.courseTeacher = courseTeacher;
    }
    public CourseMsg(String courseName, int weekDay, int hour, int minute, int timeDuration, String location, String courseTeacher) {
        this.courseName = courseName;
        this.weekDay = weekDay;
        if (minute == 0) { this.courseBeginTime = hour + ":00"; }
        else { this.courseBeginTime = hour + ":" + minute; }
        int beginTime = hour * 60 + minute, endHour = 0, endMinute = 0;
        if (timeDuration + beginTime < 24 * 60) {
            endHour = (timeDuration + beginTime) / 60;
            endMinute = (timeDuration + beginTime) % 60;
        }
        else {
            endHour = (timeDuration + beginTime - 2400) / 60;
            endMinute = (timeDuration + beginTime - 2400) % 60;
        }
        if (endMinute == 0) {this.courseEndTime = endHour + ":00";}
        else { this.courseEndTime = endHour + ":" + endMinute; }
        this.coursePlace = location;
        this.courseTeacher = courseTeacher;
    }
    public String getCourseName() {
        return courseName;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public String getCourseBeginTime() {
        return courseBeginTime;
    }

    public String getCourseEndTime() {
        return courseEndTime;
    }

    public String getCoursePlace() {
        return coursePlace;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public void setCourseBeginTime(String courseBeginTime) {
        this.courseBeginTime = courseBeginTime;
    }

    public void setCourseEndTime(String courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public void setCoursePlace(String coursePlace) {
        this.coursePlace = coursePlace;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    @Override
    public String toString() {
        return  courseName + ' ' + weekDay + ' ' + courseBeginTime + ' ' + courseEndTime + ' ' + coursePlace + ' ' + courseTeacher;
    }
}
