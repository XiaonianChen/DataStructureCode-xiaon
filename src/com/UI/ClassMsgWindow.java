package com.UI;

import com.CoreCode.CourseMsg;
import com.CoreCode.StoreCourseMsg;
import com.CoreCode.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
/**
 * @author ccr
 * @Title: 课内信息窗口
 * @Package
 * @Description:
 * @date 2022/3/2515:09
 */
public class ClassMsgWindow {
    private final JFrame classMsgWindow;
    private JPanel courseSearch; // 课程查询
    private JButton classScheduleCardSearch; // 课程表查询
    private JButton homeworkUpload; // 上传课程资料、作业
    private JPanel homeworkSearch; // 作业、资料查询
    private JButton fileCompress; // 压缩文件
    private JButton homeworkCheckDuplicate; // 作业查重、去重
    private JButton updateCourse; // 更新课程资料
    private JButton adminInterface; // 管理员界面
    private JButton courseSearchSubmit;
    private JButton homeworkSearchSubmit;
    private final Font font = new Font("隶书", Font.PLAIN, 18);
    private JTextField courseSearchCinField;
    private JTextField homeworkSearchCinField;
    private String courseSearchCinText;
    private String homeworkSearchCinText;

    public ClassMsgWindow() {
        classMsgWindow = new JFrame();
        init();
        setModuleLocation();
        addModuleToDialog();
        addActionListenerToModule();
        setButtonFont();
        classMsgWindow.setResizable(false);
        classMsgWindow.setLayout(null);
        classMsgWindow.setBounds(100, 50, 800, 750);
        classMsgWindow.setVisible(true);
        classMsgWindow.setResizable(false);
        classMsgWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public String getCourseSearchCinText() {
        return courseSearchCinText;
    }

    public String getHomeworkSearchCinText() {
        return homeworkSearchCinText;
    }

    private void setButtonFont() {
        classScheduleCardSearch.setFont(font);
        homeworkUpload.setFont(font);
        fileCompress.setFont(font);
        homeworkCheckDuplicate.setFont(font);
        updateCourse.setFont(font);
        adminInterface.setFont(font);
        courseSearchSubmit.setFont(font);
        homeworkSearchSubmit.setFont(font);
    }

    private void init() {
        courseSearch = new JPanel();
        classScheduleCardSearch = new JButton("课程表查询");
        homeworkUpload = new JButton("上传课程作业、资料");
        homeworkSearch = new JPanel();
        fileCompress = new JButton("作业、文件压缩");
        homeworkCheckDuplicate = new JButton("作业查重、去重");
        updateCourse = new JButton("更新课程");
        adminInterface = new JButton("管理员界面");
        courseSearchSubmit = new JButton("提交");
        homeworkSearchSubmit = new JButton("提交");
    }

    private void setModuleLocation() {
        courseSearch.setBounds(0, 0, 400, 300);
        homeworkSearch.setBounds(400, 0, 400, 300);
        homeworkUpload.setBounds(0, 300, 400, 150);
        classScheduleCardSearch.setBounds(400, 300, 400, 150);
        fileCompress.setBounds(0, 450, 400, 150);
        homeworkCheckDuplicate.setBounds(400, 450, 400, 150);
        updateCourse.setBounds(0, 600, 400, 150);
        adminInterface.setBounds(400, 600, 400, 150);
        panelOfCourseSearch(courseSearch);
        panelOfHomeworkSearch(homeworkSearch);
    }

    private void panelOfCourseSearch(JPanel courseSearch) {
        courseSearch.setLayout(null);
        JLabel title = new JLabel("课程查询", SwingConstants.CENTER);
        courseSearchCinField = new JTextField(SwingConstants.CENTER);
        title.setBounds(0, 0, 400, 100);
        courseSearchCinField.setBounds(0, 100, 400, 100);
        courseSearchSubmit.setBounds(100, 200, 200, 50);
        courseSearchCinField.setHorizontalAlignment(JTextField.CENTER);
        title.setFont(font);
        courseSearchCinField.setFont(font);
        courseSearch.add(title);
        courseSearch.add(courseSearchSubmit);
        courseSearch.add(courseSearchCinField);
    }

    private void panelOfHomeworkSearch(JPanel homeworkSearch) {
        homeworkSearch.setLayout(null);
        JLabel title = new JLabel("作业查询", SwingConstants.CENTER);
        homeworkSearchCinField = new JTextField(SwingConstants.CENTER);
        title.setFont(font);
        homeworkSearchCinField.setFont(font);
        title.setBounds(0, 0, 400, 100);
        homeworkSearchCinField.setBounds(0, 100, 400, 100);
        homeworkSearchSubmit.setBounds(100, 200, 200, 50);
        homeworkSearchCinField.setHorizontalAlignment(JTextField.CENTER);
        homeworkSearch.add(title);
        homeworkSearch.add(homeworkSearchSubmit);
        homeworkSearch.add(homeworkSearchCinField);
    }

    private void addModuleToDialog() {
        classMsgWindow.add(courseSearch);
        classMsgWindow.add(homeworkSearch);
        classMsgWindow.add(homeworkUpload);
        classMsgWindow.add(classScheduleCardSearch);
        classMsgWindow.add(fileCompress);
        classMsgWindow.add(homeworkCheckDuplicate);
        classMsgWindow.add(updateCourse);
        classMsgWindow.add(adminInterface);
    }

    private void addActionListenerToModule() {
        homeworkUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        classScheduleCardSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fileCompress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        homeworkCheckDuplicate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        adminInterface.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminWindow();
            }
        });
        courseSearchSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courseSearchCinText = courseSearchCinField.getText();
                boolean courseMsgFlag = false;
                StoreCourseMsg storeCourseMsg = new StoreCourseMsg(Person.accountMsg);
                CourseMsg[] courseMsgs = new CourseMsg[20];
                int courseMsgNum = 0;
                if (storeCourseMsg.courseMsgHashMap.get(courseSearchCinText) != null)
                    System.out.println(storeCourseMsg.courseMsgHashMap.get(courseSearchCinText));//精准查询O（1）
                else {
                    Set<String> keySets = storeCourseMsg.courseMsgHashMap.keySet();
                    for (String keySet : keySets) {
                        if (matchString(keySet, courseSearchCinText)) {
                        //if(keySet.contains(courseSearchCinText)){  //可直接调用contains判断子串
                            courseMsgs[courseMsgNum++] = storeCourseMsg.courseMsgHashMap.get(keySet);
                            courseMsgFlag = true;
                        }
                    }
                    quickSort(courseMsgs, 0, courseMsgNum - 1);
                    for (int i = 0; i < courseMsgNum; i++)
                        System.out.println(courseMsgs[i]);
                    if (!courseMsgFlag)
                        System.out.println("暂无查找结果");
                }
            }
        });
        homeworkSearchSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeworkSearchCinText = homeworkSearchCinField.getText();
            }
        });
    }

    private boolean matchString(String target, String mode) {
        String newTarget = "x" + target;
        String newMode = 'x' + mode;
        int[] K = calculateK(mode);
        int i = 1;
        int j = 1;
        while (i <= target.length() && j <= mode.length()) {
            if (j == 0 || newTarget.charAt(i) == newMode.charAt(j)) {
                i++;
                j++;
            } else {
                j = K[j];
            }
        }
        if (j > mode.length()) {
            return true;
        }
        return false;
    }

    private int[] calculateK(String mode) {
        String newMode = "x" + mode;
        int[] K = new int[newMode.length()];
        int i = 1;
        K[1] = 0;
        int j = 0;
        while (i < mode.length()) {
            if (j == 0 || newMode.charAt(i) == newMode.charAt(j)) {
                i++;
                j++;
                K[i] = j;
            } else {
                j = K[j];
            }
        }
        return K;
    }

    private void quickSort(CourseMsg[] arr, int left, int right) {
        int l = left;
        int r = right;
        if(left>right)return;
        CourseMsg pivot = arr[(l + r) / 2];
        CourseMsg temp = arr[left];
        while (l < r) {
            while (temp.getWeekDay() <= arr[r].getWeekDay() && l < r) {
                r--;
            }
            while (temp.getWeekDay() >= arr[r].getWeekDay() && l < r) {
                l++;
            }
            if (l < r) {
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }


        }
        arr[left] = arr[l];
        arr[l] = temp;
        quickSort(arr, left, r - 1);
        quickSort(arr, l + 1, right);
    }
}

