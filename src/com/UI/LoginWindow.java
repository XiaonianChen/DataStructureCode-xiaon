package com.UI;

import com.CoreCode.Person;
import com.CoreCode.StoreCourseMsg;
import com.CoreCode.StoreExamMsg;
import com.CoreCode.StoreOutClassMsg;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 初始时的登录界面
 * @date 2022/4/912:20
 */
public class LoginWindow {
    private JFrame loginWindow;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton commitButton;
    private JButton registerButton;
    private final Font font = new Font("隶书", Font.PLAIN, 18);
    public LoginWindow() {
        initLoginWindow();
        setLabel();
        setField();
        setButton();
        setButtonActionListener();
    }
    private void initLoginWindow() {
        loginWindow = new JFrame("登录界面");
        loginWindow.setVisible(true);
        loginWindow.setResizable(false);
        loginWindow.setLayout(null);
        loginWindow.setFont(font);
        loginWindow.setBounds(300,200,600,400);
        loginWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void setLabel() {
        JLabel accountLabel = new JLabel("学号");
        JLabel passwordLabel = new JLabel("密码");
        accountLabel.setFont(font);
        passwordLabel.setFont(font);
        accountLabel.setBounds(150,70,80,40);
        passwordLabel.setBounds(150,150,80,40);
        loginWindow.add(accountLabel);
        loginWindow.add(passwordLabel);
    }
    private void setField() {
        accountField = new JTextField();
        passwordField = new JPasswordField();
        accountField.setFont(font);
        accountField.setBounds(230,70,200,30);
        passwordField.setBounds(230,160,200,30);
        loginWindow.add(passwordField);
        loginWindow.add(accountField);
    }
    private void setButton() {
        commitButton = new JButton("登录");
        registerButton = new JButton("注册账号");
        commitButton.setFont(font);
        registerButton.setFont(font);
        commitButton.setBounds(180,240,80,40);
        registerButton.setBounds(340,240,120,40);
        loginWindow.add(commitButton);
        loginWindow.add(registerButton);
    }
    private void setButtonActionListener() {
        commitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (findAccount(account)) {
                    if (passwordIsRight(password)) {
                        loginWindow.setVisible(false);
                        Person.accountMsg = account;
                        new MainWindow();
                        new StoreCourseMsg(account);
                        new StoreExamMsg(account);
                        new StoreOutClassMsg(account);
                    }
                    else {
                        new ExceptionThrowDialog("密码错误，请重新输入");
                    }
                }
                else {
                    new ExceptionThrowDialog("账号未注册，请先注册账号");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterAccountWindow();
            }
        });
    }
    private boolean findAccount(String account) {
        File file = new File(".\\Data\\UserLoginMsg\\AccountPasswordClass.txt");
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] buff = line.split("\\s+");
                if (buff[0].equals(account)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean passwordIsRight(String password) {
        File file = new File(".\\Data\\UserLoginMsg\\AccountPasswordClass.txt");
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] buff = line.split("\\s+");
                if (buff[2].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
