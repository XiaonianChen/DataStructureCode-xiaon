package com.UI;

import com.CoreCode.CourseMsg;
import com.CoreCode.ExamMsg;
import com.CoreCode.OutClassActivityMsg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 向文件中添加个人信息
 * @date 2022/4/1011:31
 */
public class AddPersonMsg {
    JFrame addPersonMsg;
    JPanel addClassPanel;
    JPanel addExamPanel;
    JPanel addOutClassPanel;
    JTextField classField;
    JComboBox<Integer> classWeekDayField;
    JComboBox<Integer> classHourBox;
    JComboBox<Integer> classMinuteBox;
    JComboBox<Integer> classDurationBox;
    JTextField classLocationField;
    JTextField classTeacherField;
    JButton classSubmitButton;
    JTextField examField;
    JComboBox<Integer> examMonth;
    JComboBox<Integer> examDay;
    JComboBox<Integer> examHour;
    JComboBox<Integer> examMinute;
    JComboBox<Integer> examDuration;
    JTextField examLocation;
    JButton examSubmitButton;
    JComboBox<String>outClassType;
    JTextField outClassField;
    JComboBox<Integer> outClassMonth;
    JComboBox<Integer> outClassDay;
    JComboBox<Integer> outClassHour;
    JComboBox<Integer> outClassMinute;
    JComboBox<Integer> outClassDuration;
    JTextField outClassLocation;
    JButton outClassSubmit;
    Integer[] hour = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    Integer[] minute = new Integer[60];
    Integer[] week = {1, 2, 3, 4, 5, 6, 7};
    Integer[] month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    Integer[] day = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    Integer[] minuteOfDuration = {30, 60, 90, 95, 120, 150, 180};
    String[] activityType = {"个人活动", "集体活动"};
    private final Font font = new Font("隶书", Font.PLAIN, 18);
    public AddPersonMsg(String account) {
        for (int i = 0; i < 60; i++) {
            minute[i] = i;
        }
        initAddPersonMsg();
        initPanel();
        initAddClass();
        initAddExam();
        initAddOutClass();
        addActionListener(account);
    }
    private void initAddPersonMsg() {
        addPersonMsg = new JFrame();
        addPersonMsg.setVisible(true);
        addPersonMsg.setLayout(null);
        addPersonMsg.setBounds(200,200,1450,600);
        addPersonMsg.setResizable(false);
    }
    private void initPanel() {
        addClassPanel = new JPanel();
        addExamPanel = new JPanel();
        addOutClassPanel = new JPanel();
        addClassPanel.setBounds(0,0,1450,150);
        addExamPanel.setBounds(0,200,1450,150);
        addOutClassPanel.setBounds(0,400,1450,150);
        addClassPanel.setLayout(null);
        addExamPanel.setLayout(null);
        addOutClassPanel.setLayout(null);
        addPersonMsg.add(addClassPanel);
        addPersonMsg.add(addExamPanel);
        addPersonMsg.add(addOutClassPanel);
    }
    private void initAddClass() {
        // 数据结构 1 8:00 9:35 教学实验综合楼N116 张海旸
        classField = new JTextField();
        classWeekDayField = new JComboBox<Integer>(week);
        classHourBox = new JComboBox<Integer>(hour);
        classMinuteBox = new JComboBox<Integer>(minute);
        classDurationBox = new JComboBox<Integer>(minuteOfDuration);
        classLocationField = new JTextField();
        classTeacherField = new JTextField();
        classSubmitButton = new JButton("添加");
        classField.setHorizontalAlignment(JTextField.CENTER);
        classLocationField.setHorizontalAlignment(JTextField.CENTER);
        classTeacherField.setHorizontalAlignment(JTextField.CENTER);
        JLabel courseReleaseLabel = new JLabel("添加课程", SwingConstants.CENTER);
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
        courseReleaseLabel.setFont(font);
        courseDuration.setFont(font);
        courseLabel.setFont(font);
        courseWeekDay.setFont(font);
        courseHour.setFont(font);
        courseMinute.setFont(font);
        courseLocation.setFont(font);
        courseTeacher.setFont(font);
        classField.setFont(font);
        classSubmitButton.setFont(font);
        classLocationField.setFont(font);
        classTeacherField.setFont(font);
        classDurationBox.setFont(font);
        classField.setBounds(175, 50, 200, 50);
        classWeekDayField.setBounds(400, 50, 80, 50);
        classHourBox.setBounds(505, 50, 80, 50);
        classMinuteBox.setBounds(610, 50, 80, 50);
        classDurationBox.setBounds(715, 50, 80, 50);
        classTeacherField.setBounds(810, 50, 150, 50);
        classLocationField.setBounds(985, 50, 200, 50);
        classSubmitButton.setBounds(1210, 50, 80, 50);
        addClassPanel.add(classField);
        addClassPanel.add(classWeekDayField);
        addClassPanel.add(classHourBox);
        addClassPanel.add(classMinuteBox);
        addClassPanel.add(classDurationBox);
        addClassPanel.add(classTeacherField);
        addClassPanel.add(classLocationField);
        addClassPanel.add(classSubmitButton);
        addClassPanel.add(courseReleaseLabel);
        addClassPanel.add(courseLabel);
        addClassPanel.add(courseWeekDay);
        addClassPanel.add(courseHour);
        addClassPanel.add(courseMinute);
        addClassPanel.add(courseDuration);
        addClassPanel.add(courseTeacher);
        addClassPanel.add(courseLocation);
    }
    private void initAddOutClass() {
        // 个人活动 自习 3 8 14 0 120 教一楼
        outClassType = new JComboBox<>(activityType);
        outClassField = new JTextField();
        outClassSubmit = new JButton("提交");
        outClassMonth = new JComboBox<>(month);
        outClassDay = new JComboBox<>(day);
        outClassHour = new JComboBox<>(hour);
        outClassMinute = new JComboBox<>(minute);
        outClassDuration = new JComboBox<>(minuteOfDuration);
        outClassLocation = new JTextField();
        JLabel outClassLabel = new JLabel("添加活动", SwingConstants.CENTER);
        JLabel outClassTypeLabel = new JLabel("活动类型", SwingConstants.CENTER);
        JLabel outClassActiveLabel = new JLabel("活动", SwingConstants.CENTER);
        JLabel outClassMonthLabel = new JLabel("月", SwingConstants.CENTER);
        JLabel outClassDayLabel = new JLabel("日", SwingConstants.CENTER);
        JLabel outClassHourLabel = new JLabel("时", SwingConstants.CENTER);
        JLabel outClassMinuteLabel = new JLabel("分", SwingConstants.CENTER);
        JLabel outClassDurationLabel = new JLabel("时长", SwingConstants.CENTER);
        JLabel outClassLocationLabel = new JLabel("地点", SwingConstants.CENTER);
        outClassField.setHorizontalAlignment(JTextField.CENTER);
        outClassLocation.setHorizontalAlignment(JTextField.CENTER);
        outClassType.setFont(font);
        outClassField.setFont(font);
        outClassSubmit.setFont(font);
        outClassLocation.setFont(font);
        outClassLabel.setFont(font);
        outClassTypeLabel.setFont(font);
        outClassActiveLabel.setFont(font);
        outClassMonthLabel.setFont(font);
        outClassDayLabel.setFont(font);
        outClassHourLabel.setFont(font);
        outClassMinuteLabel.setFont(font);
        outClassDurationLabel.setFont(font);
        outClassLocationLabel.setFont(font);
        outClassLabel.setBounds(25,50,100,30);
        outClassType.setBounds(175,50,150,50);
        outClassField.setBounds(350,50,200,50);
        outClassMonth.setBounds(575,50,80,50);
        outClassDay.setBounds(680,50,80,50);
        outClassHour.setBounds(785,50,80,50);
        outClassMinute.setBounds(890,50,80,50);
        outClassDuration.setBounds(995,50,80,50);
        outClassLocation.setBounds(1100,50,200,50);
        outClassSubmit.setBounds(1325,50,80,50);
        outClassTypeLabel.setBounds(200,20,100,30);
        outClassActiveLabel.setBounds(425,20,50,30);
        outClassMonthLabel.setBounds(600,20,50,30);
        outClassDayLabel.setBounds(690,20,50,30);
        outClassHourLabel.setBounds(795,20,50,30);
        outClassMinuteLabel.setBounds(900,20,50,30);
        outClassDurationLabel.setBounds(1000,20,50,30);
        outClassLocationLabel.setBounds(1170,20,50,30);
        addOutClassPanel.add(outClassLabel);
        addOutClassPanel.add(outClassTypeLabel);
        addOutClassPanel.add(outClassActiveLabel);
        addOutClassPanel.add(outClassType);
        addOutClassPanel.add(outClassField);
        addOutClassPanel.add(outClassSubmit);
        addOutClassPanel.add(outClassMonth);
        addOutClassPanel.add(outClassDay);
        addOutClassPanel.add(outClassHour);
        addOutClassPanel.add(outClassMinute);
        addOutClassPanel.add(outClassDuration);
        addOutClassPanel.add(outClassLocation);
        addOutClassPanel.add(outClassMonthLabel);
        addOutClassPanel.add(outClassDayLabel);
        addOutClassPanel.add(outClassHourLabel);
        addOutClassPanel.add(outClassMinuteLabel);
        addOutClassPanel.add(outClassDurationLabel);
        addOutClassPanel.add(outClassLocationLabel);
    }
    private void initAddExam() {
        //数据结构 4 6 14:00 16:00 教学实验综合楼N111
        examField = new JTextField();
        examMonth = new JComboBox<>(month);
        examDay = new JComboBox<>(day);
        examHour = new JComboBox<>(hour);
        examMinute = new JComboBox<>(minute);
        examDuration = new JComboBox<>(minuteOfDuration);
        examLocation = new JTextField();
        examSubmitButton = new JButton("添加");
        examField.setHorizontalAlignment(JTextField.CENTER);
        examLocation.setHorizontalAlignment(JTextField.CENTER);
        JLabel examReleaseLabel = new JLabel("添加考试", SwingConstants.CENTER);
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
        examReleaseLabel.setFont(font);
        courseMonth.setFont(font);
        courseDay.setFont(font);
        courseLabel.setFont(font);
        courseHour.setFont(font);
        courseMinute.setFont(font);
        courseLocation.setFont(font);
        timeDuration.setFont(font);
        examLocation.setFont(font);
        examDuration.setFont(font);
        examField.setFont(font);
        examSubmitButton.setFont(font);
        examField.setBounds(175, 50, 200, 50);
        examMonth.setBounds(400, 50, 80, 50);
        examDay.setBounds(505, 50, 80, 50);
        examHour.setBounds(610, 50, 80, 50);
        examMinute.setBounds(715, 50, 80, 50);
        examDuration.setBounds(810, 50, 80, 50);
        examLocation.setBounds(925, 50, 200, 50);
        examSubmitButton.setBounds(1135, 50, 80, 50);
        addExamPanel.add(examReleaseLabel);
        addExamPanel.add(courseLabel);
        addExamPanel.add(courseMonth);
        addExamPanel.add(courseDay);
        addExamPanel.add(courseLabel);
        addExamPanel.add(courseHour);
        addExamPanel.add(courseMinute);
        addExamPanel.add(courseLocation);
        addExamPanel.add(timeDuration);
        addExamPanel.add(examField);
        addExamPanel.add(examMonth);
        addExamPanel.add(examDay);
        addExamPanel.add(examHour);
        addExamPanel.add(examMinute);
        addExamPanel.add(examDuration);
        addExamPanel.add(examLocation);
        addExamPanel.add(examSubmitButton);
    }
    private void addActionListener(String account) {
        // 向学号为account的对应文件中写
        classSubmitButton.addActionListener(new ActionListener() {
            // 数据结构 1 8:00 9:35 教学实验综合楼N116 张海旸
            @Override
            public void actionPerformed(ActionEvent e) {
                String course = classField.getText();
                Integer weekday = (Integer) classWeekDayField.getSelectedItem();
                Integer beginHour = (Integer) classHourBox.getSelectedItem();
                Integer beginMinute = (Integer) classMinuteBox.getSelectedItem();
                Integer duration = (Integer) classDurationBox.getSelectedItem();
                String location = classLocationField.getText();
                String teacher = classTeacherField.getText();
                CourseMsg courseMsg = new CourseMsg(course, weekday, beginHour, beginMinute, duration, location, teacher);
                String path = ".\\Data\\ClassScheduleCard\\" + account + "-ClassScheduleCard.txt";
                String msg = courseMsg.toString();
                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true)));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                try {
                    out.write( msg + "\r\n");
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        examSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 数据结构 4 6 14:00 16:00 教学实验综合楼N111
                String exam = examField.getText();
                Integer month = (Integer) examMonth.getSelectedItem();
                Integer day = (Integer) examDay.getSelectedItem();
                Integer hour = (Integer) examHour.getSelectedItem();
                Integer minute = (Integer) examMinute.getSelectedItem();
                Integer duration = (Integer) examDuration.getSelectedItem();
                String location = examLocation.getText();
                ExamMsg examMsg = new ExamMsg(exam, month, day, hour, minute, duration, location);
                String path = ".\\Data\\ExamCard\\" + account + "-ExamCard.txt";
                String msg = examMsg.toString();
                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true)));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                try {
                    out.write( msg + "\r\n");
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        outClassSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 个人活动 自习 3 9 18 30 30 图书馆
                String activityType = (String) outClassType.getSelectedItem();
                String activityName = outClassField.getText();
                Integer month = (Integer) outClassMonth.getSelectedItem();
                Integer day = (Integer) outClassDay.getSelectedItem();
                Integer hour = (Integer) outClassHour.getSelectedItem();
                Integer minute = (Integer) outClassMinute.getSelectedItem();
                Integer duration = (Integer) outClassDuration.getSelectedItem();
                String location = outClassLocation.getText();
                OutClassActivityMsg outClassActivityMsg = new OutClassActivityMsg(activityType, activityName, month, day, hour, minute, duration, location);
                String path = ".\\Data\\OutClassCard\\" + account + "-OutClassCard.txt";
                String msg = outClassActivityMsg.toString();
                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true)));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                try {
                    out.write( msg + "\r\n");
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
