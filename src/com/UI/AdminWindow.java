package com.UI;

import com.CoreCode.CourseMsg;
import com.CoreCode.ExamMsg;
import com.CoreCode.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import static com.CoreCode.StoreCourseMsg.courseMsgArray;
import static com.CoreCode.StoreCourseMsg.courseMsgHashMap;
import static com.CoreCode.StoreExamMsg.examMsgArray;
import static com.CoreCode.StoreExamMsg.examMsgHashMap;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 管理员界面
 * @date 2022/4/318:02
 */
public class AdminWindow {
    JFrame adminWindow;
    JPanel examReleasePanel; //考试发布
    JPanel courseReleasePanel; // 课程发布
    JPanel courseChangePanel; // 课程更改
    JButton examReleaseButton;
    JButton courseReleaseButton;
    JButton courseChangeButton;
    JComboBox<String> courseBoxOfExamRelease;
    JComboBox<Integer> monthBoxOfExamRelease;
    JComboBox<Integer> dayBoxOfExamRelease;
    JComboBox<Integer> hourBoxOfExamRelease;
    JComboBox<Integer> minuteBoxOfExamRelease;
    JTextField locationBoxOfExamRelease;
    JTextField courseBoxOfCourseRelease;
    JComboBox<Integer> weekDayBoxOfCourseRelease;
    JComboBox<Integer> hourBoxOfCourseRelease;
    JComboBox<Integer> minuteBoxOfCourseRelease;
    JTextField locationBoxOfCourseRelease;
    JComboBox<String> courseBoxOfCourseChange;
    JComboBox<Integer> weekDayBoxOfCourseChange;
    JComboBox<Integer> hourBoxOfCourseChange;
    JComboBox<Integer> minuteBoxOfCourseChange;
    JTextField locationBoxOfCourseChange;
    JComboBox<Integer> timeDurationOfExamRelease;
    JComboBox<Integer> timeDurationOfCourseRelease;
    JComboBox<Integer> timeDurationOfCourseChange;
    JTextField teacherOfCourseRelease;
    JTextField teacherOfCourseChange;
    Integer[] hour = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    Integer[] minute = new Integer[60];
    Integer[] week = new Integer[7]; // 下标0存储星期一，类推
    Integer[] month = new Integer[12]; // 下标0存储1月，类推
    Integer[] day = new Integer[31]; // 下标0存储1号，类推
    Integer[] minuteOfDuration = {30, 60, 90, 95, 120, 150, 180};
    String[] courseList;
    private final Font font = new Font("隶书", Font.PLAIN, 18);

    public AdminWindow() {
        adminWindow = new JFrame();
        adminWindow.setLayout(null);
        adminWindow.setResizable(false);
        adminWindow.setVisible(true);
        adminWindow.setBounds(100, 100, 1400, 600);
        initCalenderArray();
        initCourseList();
        initPanel();
        moduleAddActionListener();
    }

    private void initCalenderArray() {
        for (int i = 0; i < 60; i++) {
            minute[i] = i;
        }
        for (int i = 1; i < 8; i++) {
            week[i - 1] = i;
        }
        for (int i = 1; i < 13; i++) {
            month[i - 1] = i;
        }
        for (int i = 1; i < 32; i++) {
            day[i - 1] = i;
        }
    }
    private void initCourseList() {
        int mapLength = courseMsgHashMap.size();
        courseList = new String[mapLength];
        int i = 0;
        for (String key : courseMsgHashMap.keySet()) {
            courseList[i++] = key;
        }
    }
    private void initPanel() {
        examReleasePanel = new JPanel();
        courseReleasePanel = new JPanel();
        courseChangePanel = new JPanel();
        adminWindow.add(examReleasePanel);
        adminWindow.add(courseReleasePanel);
        adminWindow.add(courseChangePanel);
        examReleasePanel.setBounds(0, 0, 1400, 150);
        courseReleasePanel.setBounds(0, 200, 1400, 150);
        courseChangePanel.setBounds(0, 400, 1400, 150);
        examReleasePanel.setLayout(null);
        courseReleasePanel.setLayout(null);
        courseChangePanel.setLayout(null);
        setExamReleasePanel();
        setCourseReleasePanel();
        setCourseChangePanel();
    }

    private void setExamReleasePanel() {
        JLabel examReleaseLabel = new JLabel("考试发布", SwingConstants.CENTER);
        JLabel courseLabel = new JLabel("科目");
        JLabel courseMonth = new JLabel("月");
        JLabel courseDay = new JLabel("日");
        JLabel courseHour = new JLabel("时");
        JLabel courseMinute = new JLabel("分");
        JLabel timeDuration = new JLabel("时长(分)");
        JLabel courseLocation = new JLabel("地点");
        examReleaseLabel.setBounds(0, 0, 150, 150);
        courseLabel.setBounds(250, 20, 50, 30);
        courseMonth.setBounds(420, 20, 50, 30);
        courseDay.setBounds(525, 20, 50, 30);
        courseHour.setBounds(630, 20, 50, 30);
        courseMinute.setBounds(730, 20, 50, 30);
        timeDuration.setBounds(810, 20, 80, 30);
        courseLocation.setBounds(995, 20, 50, 30);
        courseBoxOfExamRelease = new JComboBox<String>(courseList);
        monthBoxOfExamRelease = new JComboBox<>(month);
        dayBoxOfExamRelease = new JComboBox<>(day);
        hourBoxOfExamRelease = new JComboBox<Integer>(hour);
        minuteBoxOfExamRelease = new JComboBox<Integer>(minute);
        locationBoxOfExamRelease = new JTextField();
        locationBoxOfExamRelease.setHorizontalAlignment(JTextField.CENTER);
        timeDurationOfExamRelease = new JComboBox<>(minuteOfDuration);
        examReleaseLabel.setFont(font);
        courseMonth.setFont(font);
        courseDay.setFont(font);
        courseLabel.setFont(font);
        courseHour.setFont(font);
        courseMinute.setFont(font);
        courseLocation.setFont(font);
        timeDuration.setFont(font);
        locationBoxOfExamRelease.setFont(font);
        timeDurationOfExamRelease.setFont(font);
        examReleaseButton = new JButton("确认");
        courseBoxOfExamRelease.setBounds(175, 50, 200, 50);
        monthBoxOfExamRelease.setBounds(400, 50, 80, 50);
        dayBoxOfExamRelease.setBounds(505, 50, 80, 50);
        hourBoxOfExamRelease.setBounds(610, 50, 80, 50);
        minuteBoxOfExamRelease.setBounds(715, 50, 80, 50);
        timeDurationOfExamRelease.setBounds(810, 50, 80, 50);
        locationBoxOfExamRelease.setBounds(925, 50, 200, 50);
        examReleaseButton.setBounds(1135, 50, 80, 50);
        examReleasePanel.add(examReleaseLabel);
        examReleasePanel.add(courseHour);
        examReleasePanel.add(courseMinute);
        examReleasePanel.add(courseMonth);
        examReleasePanel.add(courseDay);
        examReleasePanel.add(courseLocation);
        examReleasePanel.add(monthBoxOfExamRelease);
        examReleasePanel.add(dayBoxOfExamRelease);
        examReleasePanel.add(courseLabel);
        examReleasePanel.add(courseBoxOfExamRelease);
        examReleasePanel.add(hourBoxOfExamRelease);
        examReleasePanel.add(minuteBoxOfExamRelease);
        examReleasePanel.add(locationBoxOfExamRelease);
        examReleasePanel.add(examReleaseButton);
        examReleasePanel.add(timeDurationOfExamRelease);
        examReleasePanel.add(timeDuration);
    }

    private void setCourseReleasePanel() {
        JLabel courseReleaseLabel = new JLabel("课程发布", SwingConstants.CENTER);
        JLabel courseLabel = new JLabel("科目");
        JLabel courseWeekDay = new JLabel("周");
        JLabel courseHour = new JLabel("时");
        JLabel courseMinute = new JLabel("分");
        JLabel courseDuration = new JLabel("时长(分)");
        JLabel courseTeacher = new JLabel("教师");
        JLabel courseLocation = new JLabel("地点");
        courseLabel.setBounds(250, 20, 50, 30);
        courseWeekDay.setBounds(425, 20, 50, 30);
        courseHour.setBounds(520, 20, 50, 30);
        courseMinute.setBounds(630, 20, 50, 30);
        courseDuration.setBounds(720, 20, 80, 30);
        courseTeacher.setBounds(860, 20, 50, 30);
        courseLocation.setBounds(1060, 20, 50, 30);
        courseReleaseLabel.setBounds(0, 0, 150, 150);
        courseBoxOfCourseRelease = new JTextField();
        weekDayBoxOfCourseRelease = new JComboBox<Integer>(week);
        hourBoxOfCourseRelease = new JComboBox<Integer>(hour);
        minuteBoxOfCourseRelease = new JComboBox<Integer>(minute);
        locationBoxOfCourseRelease = new JTextField();
        locationBoxOfCourseRelease.setHorizontalAlignment(JTextField.CENTER);
        timeDurationOfCourseRelease = new JComboBox<>(minuteOfDuration);
        teacherOfCourseRelease = new JTextField();
        teacherOfCourseRelease.setHorizontalAlignment(JTextField.CENTER);
        courseBoxOfCourseRelease.setHorizontalAlignment(JTextField.CENTER);
        courseBoxOfCourseRelease.setFont(font);
        courseReleaseLabel.setFont(font);
        courseDuration.setFont(font);
        courseLabel.setFont(font);
        courseWeekDay.setFont(font);
        courseHour.setFont(font);
        courseMinute.setFont(font);
        courseLocation.setFont(font);
        courseTeacher.setFont(font);
        locationBoxOfCourseRelease.setFont(font);
        teacherOfCourseRelease.setFont(font);
        timeDurationOfCourseRelease.setFont(font);
        courseReleaseButton = new JButton("确认");
        courseBoxOfCourseRelease.setBounds(175, 50, 200, 50);
        weekDayBoxOfCourseRelease.setBounds(400, 50, 80, 50);
        hourBoxOfCourseRelease.setBounds(505, 50, 80, 50);
        minuteBoxOfCourseRelease.setBounds(610, 50, 80, 50);
        timeDurationOfCourseRelease.setBounds(715, 50, 80, 50);
        teacherOfCourseRelease.setBounds(810, 50, 150, 50);
        locationBoxOfCourseRelease.setBounds(985, 50, 200, 50);
        courseReleaseButton.setBounds(1210, 50, 80, 50);
        courseReleasePanel.add(courseReleaseLabel);
        courseReleasePanel.add(courseHour);
        courseReleasePanel.add(courseMinute);
        courseReleasePanel.add(courseLocation);
        courseReleasePanel.add(courseWeekDay);
        courseReleasePanel.add(weekDayBoxOfCourseRelease);
        courseReleasePanel.add(courseLabel);
        courseReleasePanel.add(courseTeacher);
        courseReleasePanel.add(courseBoxOfCourseRelease);
        courseReleasePanel.add(hourBoxOfCourseRelease);
        courseReleasePanel.add(minuteBoxOfCourseRelease);
        courseReleasePanel.add(locationBoxOfCourseRelease);
        courseReleasePanel.add(courseReleaseButton);
        courseReleasePanel.add(timeDurationOfCourseRelease);
        courseReleasePanel.add(teacherOfCourseRelease);
        courseReleasePanel.add(courseDuration);
    }

    private void setCourseChangePanel() {
        JLabel courseChangeLabel = new JLabel("课程更改", SwingConstants.CENTER);
        JLabel courseLabel = new JLabel("科目");
        JLabel courseWeekDay = new JLabel("周");
        JLabel courseHour = new JLabel("时");
        JLabel courseMinute = new JLabel("分");
        JLabel courseDuration = new JLabel("时长(分)");
        JLabel courseTeacher = new JLabel("教师");
        JLabel courseLocation = new JLabel("地点");
        courseLabel.setBounds(250, 20, 50, 30);
        courseWeekDay.setBounds(425, 20, 50, 30);
        courseHour.setBounds(520, 20, 50, 30);
        courseMinute.setBounds(630, 20, 50, 30);
        courseDuration.setBounds(720, 20, 80, 30);
        courseTeacher.setBounds(860, 20, 50, 30);
        courseLocation.setBounds(1060, 20, 50, 30);
        courseChangeLabel.setBounds(0, 0, 150, 150);
        courseBoxOfCourseChange = new JComboBox<String>(courseList);
        weekDayBoxOfCourseChange = new JComboBox<Integer>(week);
        hourBoxOfCourseChange = new JComboBox<Integer>(hour);
        minuteBoxOfCourseChange = new JComboBox<Integer>(minute);
        locationBoxOfCourseChange = new JTextField();
        locationBoxOfCourseChange.setHorizontalAlignment(JTextField.CENTER);
        timeDurationOfCourseChange = new JComboBox<>(minuteOfDuration);
        teacherOfCourseChange = new JTextField();
        teacherOfCourseChange.setHorizontalAlignment(JTextField.CENTER);
        courseChangeLabel.setFont(font);
        courseLabel.setFont(font);
        courseWeekDay.setFont(font);
        courseHour.setFont(font);
        courseMinute.setFont(font);
        courseLocation.setFont(font);
        courseDuration.setFont(font);
        courseTeacher.setFont(font);
        locationBoxOfCourseChange.setFont(font);
        teacherOfCourseChange.setFont(font);
        timeDurationOfCourseChange.setFont(font);
        courseBoxOfCourseChange.setBounds(175, 50, 200, 50);
        weekDayBoxOfCourseChange.setBounds(400, 50, 80, 50);
        hourBoxOfCourseChange.setBounds(505, 50, 80, 50);
        minuteBoxOfCourseChange.setBounds(610, 50, 80, 50);
        timeDurationOfCourseChange.setBounds(715, 50, 80, 50);
        teacherOfCourseChange.setBounds(810, 50, 150, 50);
        locationBoxOfCourseChange.setBounds(985, 50, 200, 50);
        courseChangeButton = new JButton("确认");
        courseChangeButton.setBounds(1210, 50, 80, 50);
        courseChangePanel.add(courseChangeLabel);
        courseChangePanel.add(courseHour);
        courseChangePanel.add(courseWeekDay);
        courseChangePanel.add(courseMinute);
        courseChangePanel.add(courseLocation);
        courseChangePanel.add(courseLabel);
        courseChangePanel.add(courseBoxOfCourseChange);
        courseChangePanel.add(weekDayBoxOfCourseChange);
        courseChangePanel.add(hourBoxOfCourseChange);
        courseChangePanel.add(minuteBoxOfCourseChange);
        courseChangePanel.add(locationBoxOfCourseChange);
        courseChangePanel.add(courseChangeButton);
        courseChangePanel.add(timeDurationOfCourseChange);
        courseChangePanel.add(teacherOfCourseChange);
        courseChangePanel.add(courseDuration);
        courseChangePanel.add(courseTeacher);
    }

    private void moduleAddActionListener() {
        examReleaseButton.addActionListener(new ActionListener() { // 考试发布事件
            @Override
            public void actionPerformed(ActionEvent e) {
                String course = (String) courseBoxOfExamRelease.getSelectedItem();
                Integer month = (Integer) monthBoxOfExamRelease.getSelectedItem();
                Integer day = (Integer) dayBoxOfExamRelease.getSelectedItem();
                Integer hour = (Integer) hourBoxOfExamRelease.getSelectedItem();
                Integer minute = (Integer) minuteBoxOfExamRelease.getSelectedItem();
                Integer duration = (Integer) timeDurationOfExamRelease.getSelectedItem();
                String location = locationBoxOfExamRelease.getText();
                ExamMsg addItem = new ExamMsg(course, month, day, hour, minute, duration, location);
                if (examMsgHashMap.containsKey(course)) {
                    new ExceptionThrowDialog("该科目考试已经添加");
                }
                boolean flag = true;
                for (ExamMsg examMsg: examMsgArray) {
                    if (examMsg.getMonth() == addItem.getMonth() && examMsg.getDay() == addItem.getDay() && examTimeConflict(examMsg, addItem)) {
                        // 日期相同，时间段冲突
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    examMsgHashMap.put(course, addItem);
                    examMsgArray.add(addItem);
                    try {
                        writeToExamScheduleCard(addItem);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else { new ExceptionThrowDialog("时间发生冲突，请重新选择"); }
            }
        });
        courseReleaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String course = (String) courseBoxOfCourseRelease.getText();
                Integer weekDay = (Integer) weekDayBoxOfCourseRelease.getSelectedItem();
                Integer hour = (Integer) hourBoxOfCourseRelease.getSelectedItem();
                Integer minute = (Integer) minuteBoxOfCourseRelease.getSelectedItem();
                String teacher = teacherOfCourseRelease.getText();
                Integer timeDuration = (Integer) timeDurationOfCourseRelease.getSelectedItem();
                String location = locationBoxOfCourseRelease.getText();
                if (courseMsgHashMap.containsKey(course)) {
                    new ExceptionThrowDialog("该课程已经存在");
                }
                else {
                    CourseMsg addItem = new CourseMsg(course, weekDay, hour, minute, timeDuration, location, teacher);
                    if (noCourseTimeConflict(addItem)) { // 时间没有发生冲突
                        courseMsgHashMap.put(course, addItem);
                        courseMsgArray.add(addItem);
                        try {
                            addToClassScheduleCard(addItem);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else {
                        new ExceptionThrowDialog("时间发生冲突，请重新选择");
                    }
                }
            }
        });
        courseChangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String course = (String) courseBoxOfCourseChange.getSelectedItem();
                Integer weekDay = (Integer) weekDayBoxOfCourseChange.getSelectedItem();
                Integer hour = (Integer) hourBoxOfCourseChange.getSelectedItem();
                Integer minute = (Integer) minuteBoxOfCourseChange.getSelectedItem();
                String teacher = teacherOfCourseChange.getText();
                Integer timeDuration = (Integer) timeDurationOfCourseChange.getSelectedItem();
                String location = locationBoxOfCourseChange.getText();
                if (courseMsgHashMap.containsKey(course)) {
                    CourseMsg addItem = new CourseMsg(course, weekDay, hour, minute, timeDuration, location, teacher);
                    if (noCourseTimeConflict(addItem)) { // 时间没有发生冲突
                        courseMsgHashMap.put(course, addItem);
                        courseMsgArray.add(addItem);
                        try {
                            writeToClassScheduleCard(addItem);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else {
                        new ExceptionThrowDialog("时间发生冲突，请重新选择");
                    }
                }
            }
        });
    }
    private boolean examTimeConflict(ExamMsg examMsg, ExamMsg addItem) {
        // 判断时间是否有冲突,true代表有冲突，false代表没有冲突
        int i = 0;
        int beginTimeX = getTime(examMsg.getBeginTime());
        int beginTimeY = getTime(addItem.getBeginTime());
        int endTimeX = getTime(examMsg.getEndTime());
        int endTimeY = getTime(addItem.getEndTime());
        return oneTimeContainAnother(beginTimeX, endTimeX, beginTimeY, endTimeY);
    }
    private boolean noCourseTimeConflict(CourseMsg addItem) {
        // 时间是否有冲突
        // 地点是否有冲突
        // 教师是否有冲突
        int beginTimeX = getTime(addItem.getCourseBeginTime());
        int endTimeX = getTime(addItem.getCourseEndTime());
        for (CourseMsg courseMsg : courseMsgArray) {
            int beginTimeY = getTime(courseMsg.getCourseBeginTime());
            int endTimeY = getTime(courseMsg.getCourseEndTime());
            if (!addItem.getCourseName().equals(courseMsg.getCourseName())) {
                if (addItem.getWeekDay() == courseMsg.getWeekDay() && oneTimeContainAnother(beginTimeX, endTimeX, beginTimeY, endTimeY)) { // 时间发生冲突
                   return false;
                }
            }
        }
        return true;
    }
    private int getTime(String time) {
        int beginTimeHour, beginTimeMinute;
        int i = 0;
        while (time.charAt(i) != ':') {i++;}
        beginTimeHour = Integer.parseInt(time.substring(0, i));
        beginTimeMinute = Integer.parseInt(time.substring(i + 1, time.length()));
        return beginTimeHour * 60 + beginTimeMinute;
    }
    private boolean oneTimeContainAnother(int beginTimeX, int endTimeX, int beginTimeY, int endTimeY) {
        // true代表有冲突,false代表没有冲突
        if (beginTimeX > endTimeY || beginTimeY > endTimeX) {
            return false;
        }
        return true;
    }
    private void writeToClassScheduleCard(CourseMsg addItem) throws IOException {
        // 更新ClassScheduleCard.txt状态, 其中addItem的课程名称作为关键字
        String path = ".\\Data\\ClassScheduleCard\\" + Person.accountMsg + "-ClassScheduleCard.txt";
        File file = new File(path);
        ArrayList<String>tmp = new ArrayList<>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.contains(addItem.getCourseName())) { // 该行不是要更新的行
                tmp.add(line);
            }
        }
        reader.close();
        bufferedReader.close();
        tmp.add(addItem.toString());
//         清空文件
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.flush();
        // 重新写入
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        for (String x: tmp) {
            bufferWriter.write(x + "\n");
        }
        bufferWriter.close();
    }
    private void writeToExamScheduleCard(ExamMsg addItem) throws IOException {
        File file = new File(".\\Data\\ExamScheduleCard.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        bufferWriter.write("\n" + addItem.toString());
        bufferWriter.close();
    }
    private void addToClassScheduleCard(CourseMsg addItem) throws IOException {
        String path = ".\\Data\\ClassScheduleCard\\" + Person.accountMsg + "-ClassScheduleCard.txt";
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        bufferWriter.write("\n" + addItem.toString());
        bufferWriter.close();
    }
}
