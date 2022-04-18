package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 注册界面
 * @date 2022/4/917:27
 */
public class RegisterAccountWindow {
    JFrame registerAccountWindow;
    JTextField accountField;
    JTextField classField;
    JPasswordField passwordField;
    JButton commitButton;
    private final Font font = new Font("隶书", Font.PLAIN, 18);
    public RegisterAccountWindow() {
        initRegisterAccountWindow();
        initLabel();
        initField();
        initButton();
        initButtonActionListener();
    }
    private void initRegisterAccountWindow() {
        registerAccountWindow = new JFrame("注册界面");
        registerAccountWindow.setVisible(true);
        registerAccountWindow.setResizable(false);
        registerAccountWindow.setLayout(null);
        registerAccountWindow.setFont(font);
        registerAccountWindow.setBounds(300,200,400,600);
    }
    private void initLabel() {
        JLabel accountLabel = new JLabel("学号");
        JLabel passwordLabel = new JLabel("密码");
        JLabel classLabel = new JLabel("班级");
        accountLabel.setBounds(80,80,80,40);
        classLabel.setBounds(80,200,80,40);
        passwordLabel.setBounds(80,320,80,40);
        accountLabel.setFont(font);
        classLabel.setFont(font);
        passwordLabel.setFont(font);
        registerAccountWindow.add(accountLabel);
        registerAccountWindow.add(classLabel);
        registerAccountWindow.add(passwordLabel);
    }
    private void initField() {
        accountField = new JTextField();
        passwordField = new JPasswordField();
        classField = new JTextField();
        accountField.setFont(font);
        classField.setFont(font);
        accountField.setBounds(140,80,200,40);
        classField.setBounds(140,200,200,40);
        passwordField.setBounds(140,320,200,40);
        registerAccountWindow.add(accountField);
        registerAccountWindow.add(classField);
        registerAccountWindow.add(passwordField);
    }
    private void initButton() {
        commitButton = new JButton("提交");
        commitButton.setFont(font);
        commitButton.setBounds(180,420,80,40);
        registerAccountWindow.add(commitButton);
    }
    private void initButtonActionListener() {
        commitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountMsg = accountField.getText();
                String classMsg = classField.getText();
                String passwordMsg = String.valueOf(passwordField.getPassword());
                if (findAccount(accountMsg)) {
                    new ExceptionThrowDialog("该账号已被注册，请登录");
                }
                else if (!malformationPassword(passwordMsg)) {
                    new ExceptionThrowDialog("密码非法，仅以数字或字母构成");
                }
                else if (malformationAccountClass(classMsg)) {
                    new ExceptionThrowDialog("班级非法，仅以数字构成");
                }
                else if (malformationAccountClass(accountMsg)) {
                    new ExceptionThrowDialog("学号非法，仅以数字构成");
                }
                else {
                    try {
                        addFileToData(accountMsg, classMsg, passwordMsg);
                    } catch (IOException ioException) {
                        new ExceptionThrowDialog("创建文件时出错了...");
                    }
                }
            }
        });
    }
    private boolean findAccount(String accountMsg) {
        File file = new File(".\\Data\\UserLoginMsg\\AccountPasswordClass.txt");
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] buff = line.split("\\s+");
                if (buff[0].equals(accountMsg)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean malformationPassword(String x) {
        return x.matches("^[a-z0-9A-Z]+$") && !x.isEmpty();
    }
    private boolean malformationAccountClass(String x) {
        return !x.matches("[0-9]+") || x.isEmpty();
    }
    private void addFileToData(String accountMsg, String classMsg, String passwordMsg) throws IOException {
        String outClassFileName = ".\\Data\\OutClassCard\\" + accountMsg + "-OutClassCard.txt";
        String classFileName = ".\\Data\\ClassScheduleCard\\" + accountMsg + "-ClassScheduleCard.txt";
        String examFileName = ".\\Data\\ExamCard\\" + accountMsg + "-ExamCard.txt";
        File outClassFile = new File(outClassFileName);
        File classFile = new File(classFileName);
        File examFile = new File(examFileName);
        if (!outClassFile.createNewFile() || !classFile.createNewFile() || !examFile.createNewFile()) {
            new ExceptionThrowDialog("创建课外文件失败");
        }
        else {
            new AddPersonMsg(accountMsg);
            String path = ".\\Data\\UserLoginMsg\\AccountPasswordClass.txt";
            String msg = accountMsg + " " + classMsg + " " + passwordMsg;
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true)));
            out.write( msg + "\r\n");
            out.close();
        }
    }
}
