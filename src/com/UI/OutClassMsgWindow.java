package com.UI;

import com.CoreCode.OutClassActivityMsg;
import com.CoreCode.Person;
import com.CoreCode.StoreOutClassMsg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author ccr
 * @Title: 课外信息窗口
 * @Package
 * @Description:
 * @date 2022/3/2515:07
 */
public class OutClassMsgWindow{
    private final JFrame outClassMsgWindow;
    private JPanel personalActivity;
    private JPanel groupActivity;
    private JPanel alarmClockSet;
    private JTextField printTextFieldOfPersonalActivity;
    private JTextField comboBoxOfPersonalActivity;
    private JTextField printTextFieldOfGroupActivity;
    private JTextField comboBoxOfGroupActivity;
    private JComboBox<String> hourBox;
    private JComboBox<String> minuteBox;
    private JComboBox<String> frequencyBox;
    private JButton commitAlarm;
    private JButton personalActivityButton;
    private JButton groupActivityButton;
    private final Font font = new Font("隶书",Font.PLAIN,18);
    private JLabel labelOfAlarmClock;
    private String outClassActivitySearchCinText;
    public OutClassMsgWindow() {
        outClassMsgWindow = new JFrame();
        initPanel();
        moduleSetLayout();
        addPanelToWindow();
        panelSetBound();
        setPersonalActivity();
        setGroupActivity();
        setAlarmClockSet();
        moduleAddActionListener();
        outClassMsgWindow.setResizable(false);
        outClassMsgWindow.setLayout(null);
        outClassMsgWindow.setBounds(100,100,1000,600);
        outClassMsgWindow.setVisible(true);
        outClassMsgWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    private void moduleSetLayout() {
        outClassMsgWindow.setLayout(null);
        personalActivity.setLayout(null);
        groupActivity.setLayout(null);
        alarmClockSet.setLayout(null);
    }
    private void initPanel() {
        personalActivity = new JPanel();
        groupActivity = new JPanel();
        alarmClockSet = new JPanel();
    }
    private void addPanelToWindow() {
        outClassMsgWindow.add(personalActivity);
        outClassMsgWindow.add(groupActivity);
        outClassMsgWindow.add(alarmClockSet);
    }
    private void panelSetBound() {
        personalActivity.setBounds(0,0,800,200);
        groupActivity.setBounds(0,200,800,200);
        alarmClockSet.setBounds(0,400,800,100);
    }
    private void setPersonalActivity() {
        JLabel labelOfPersonalActivity = new JLabel("个人活动", SwingConstants.CENTER);
        labelOfPersonalActivity.setFont(font);
        labelOfPersonalActivity.setBounds(0,0,300,100);
        personalActivity.add(labelOfPersonalActivity);
        comboBoxOfPersonalActivity = new JTextField();
        comboBoxOfPersonalActivity.setHorizontalAlignment(JTextField.CENTER);
        comboBoxOfPersonalActivity.setBounds(300,25,300,50);
        personalActivity.add(comboBoxOfPersonalActivity);
        comboBoxOfPersonalActivity.setFont(font);
        JLabel labelOfFindResultOfPersonalActivity = new JLabel("查询结果", SwingConstants.CENTER);
        labelOfFindResultOfPersonalActivity.setFont(font);
        labelOfFindResultOfPersonalActivity.setBounds(0,100,300,100);
        personalActivity.add(labelOfFindResultOfPersonalActivity);
        printTextFieldOfPersonalActivity = new JTextField();
        printTextFieldOfPersonalActivity.setBounds(300,125,350,50);
        printTextFieldOfPersonalActivity.setFont(font);
        personalActivity.add(printTextFieldOfPersonalActivity);
        personalActivityButton = new JButton("确认");
        personalActivityButton.setFont(font);
        personalActivityButton.setBounds(700,30,80,40);
        personalActivity.add(personalActivityButton);
    }
    private void setGroupActivity() {
        JLabel labelOfGroupActivity = new JLabel("集体活动", SwingConstants.CENTER);
        labelOfGroupActivity.setFont(font);
        labelOfGroupActivity.setBounds(0,0,300,100);
        groupActivity.add(labelOfGroupActivity);
        comboBoxOfGroupActivity = new JTextField();
        comboBoxOfGroupActivity.setFont(font);
        comboBoxOfGroupActivity.setHorizontalAlignment(JTextField.CENTER);
        comboBoxOfGroupActivity.setBounds(300,25,300,50);
        groupActivity.add(comboBoxOfGroupActivity);
        JLabel labelOfFindResultOfGroupActivity = new JLabel("查询结果", SwingConstants.CENTER);
        labelOfFindResultOfGroupActivity.setFont(font);
        labelOfFindResultOfGroupActivity.setBounds(0,100,300,100);
        groupActivity.add(labelOfFindResultOfGroupActivity);
        printTextFieldOfGroupActivity = new JTextField();
        printTextFieldOfGroupActivity.setFont(font);
        printTextFieldOfGroupActivity.setBounds(300,125,350,50);
        groupActivity.add(printTextFieldOfGroupActivity);
        groupActivityButton = new JButton("确认");
        groupActivityButton.setFont(font);
        groupActivityButton.setBounds(700,30,80,40);
        groupActivity.add(groupActivityButton);
    }
    private void setAlarmClockSet() {
        labelOfAlarmClock = new JLabel("闹钟设置", SwingConstants.CENTER);
        labelOfAlarmClock.setBounds(0,20,300,100);
        labelOfAlarmClock.setFont(font);
        alarmClockSet.add(labelOfAlarmClock);
        JLabel timeTip = new JLabel("   时         分");
        JLabel labelOfFrequency = new JLabel("次数", SwingConstants.CENTER);
        timeTip.setBounds(300,0,300,50);
        timeTip.setFont(font);
        labelOfFrequency.setFont(font);
        labelOfFrequency.setBounds(400,0,300,50);
        alarmClockSet.add(timeTip);
        alarmClockSet.add(labelOfFrequency);
        String[] sizeOf24 = new String[24];
        String[] sizeOf60 = new String[60];
        String[] frequencySet = {"单次", "每天一次", "每周一次", "非周末"};
        for (int i = 0; i < 24; i++)
            sizeOf24[i] = Integer.toString(i);
        for (int i = 0; i <= 59; i++)
            sizeOf60[i] = Integer.toString(i);
        hourBox = new JComboBox<String>(sizeOf24);
        minuteBox = new JComboBox<String>(sizeOf60);
        frequencyBox = new JComboBox<String>(frequencySet);
        hourBox.setBounds(300,50,70,30);
        minuteBox.setBounds(400,50,70,30);
        frequencyBox.setBounds(500,50,100,30);
        commitAlarm = new JButton("确认");
        commitAlarm.setFont(font);
        commitAlarm.setBounds(650,50,75,30);
        alarmClockSet.add(hourBox);
        alarmClockSet.add(minuteBox);
        alarmClockSet.add(frequencyBox);
        alarmClockSet.add(commitAlarm);
    }
    private void moduleAddActionListener() {
        personalActivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outClassActivitySearchCinText = comboBoxOfPersonalActivity.getText();
                boolean outClassActivityMsgFlag = false;
                StoreOutClassMsg storeOutClassMsg = new StoreOutClassMsg(Person.accountMsg);
                OutClassActivityMsg[] outClassActivityMsgs = new OutClassActivityMsg[20];
                int outClassActivityMsgNum = 0;
                if (storeOutClassMsg.outClassActivityMsgHashMap.get(outClassActivitySearchCinText) != null)
                    printTextFieldOfPersonalActivity.setText(String.valueOf(storeOutClassMsg.outClassActivityMsgHashMap.get(outClassActivitySearchCinText)));//精准查询O（1）
                else {
                    Set<String> keySets = storeOutClassMsg.outClassActivityMsgHashMap.keySet();
                    for (String keySet : keySets) {
                        if (matchString(keySet, outClassActivitySearchCinText)) {
                            //if(keySet.contains(outClassActivitySearchCinText)){  //可直接调用contains判断子串
                            outClassActivityMsgs[outClassActivityMsgNum++] = storeOutClassMsg.outClassActivityMsgHashMap.get(keySet);
                            outClassActivityMsgFlag = true;
                        }
                    }
                    quickSort(outClassActivityMsgs, 0, outClassActivityMsgNum - 1);
                    for (int i = 0; i < outClassActivityMsgNum; i++)
                        System.out.println(outClassActivityMsgs[i]);
                    if (!outClassActivityMsgFlag)
                        printTextFieldOfPersonalActivity.setText("暂无查找结果");
                }
            }
        });
        groupActivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outClassActivitySearchCinText = comboBoxOfGroupActivity.getText();
                boolean outClassActivityMsgFlag = false;
                StoreOutClassMsg storeOutClassMsg = new StoreOutClassMsg(Person.accountMsg);
                OutClassActivityMsg[] outClassActivityMsgs = new OutClassActivityMsg[20];
                int outClassActivityMsgNum = 0;
                if (storeOutClassMsg.outClassActivityMsgHashMap.get(outClassActivitySearchCinText) != null)
                    printTextFieldOfGroupActivity.setText(String.valueOf(storeOutClassMsg.outClassActivityMsgHashMap.get(outClassActivitySearchCinText)));//精准查询O（1）
                else {
                    Set<String> keySets = storeOutClassMsg.outClassActivityMsgHashMap.keySet();
                    for (String keySet : keySets) {
                        if (matchString(keySet, outClassActivitySearchCinText)) {
                            //if(keySet.contains(outClassActivitySearchCinText)){  //可直接调用contains判断子串
                            outClassActivityMsgs[outClassActivityMsgNum++] = storeOutClassMsg.outClassActivityMsgHashMap.get(keySet);
                            outClassActivityMsgFlag = true;
                        }
                    }
                    quickSort(outClassActivityMsgs, 0, outClassActivityMsgNum - 1);
                    for (int i = 0; i < outClassActivityMsgNum; i++)
                        System.out.println(outClassActivityMsgs[i]);
                    if (!outClassActivityMsgFlag)
                        printTextFieldOfGroupActivity.setText("暂无查找结果");
                }

            }
        });
        commitAlarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    private void quickSort(OutClassActivityMsg[] arr, int left, int right) {
        int l = left;
        int r = right;
        if(left>right)return;
        OutClassActivityMsg pivot = arr[(l + r) / 2];
        OutClassActivityMsg temp = arr[left];
        while (l < r) {
            while (temp.getMonth() <= arr[r].getMonth() && l < r) {
                r--;
            }
            while (temp.getMonth() >= arr[r].getMonth() && l < r) {
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
