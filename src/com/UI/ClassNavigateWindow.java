package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author ccr
 * @Title: 课程导航窗口
 * @Package
 * @Description:
 * @date 2022/3/2515:10
 */
public class ClassNavigateWindow{
    private JFrame classNavigateWindow;
    private JPanel chooseMenuPanel;
    private JPanel printRoutePanel;
    private JTextField nameOfClassField;
    private JComboBox<String> timeOfClassComboBox;
    private JComboBox<String> placeOfClassComboBox;
    private JComboBox<String> placeOfNowComboBox;
    private JComboBox<String> travelMethodComboBox;
    private JButton confirmButton;
    private final Font font = new Font("隶书",Font.PLAIN,18);
    private static final String[] timeOfClassString = {"8:00", "8:50", "9:45", "10:40", "11:30", "13:00", "13:50", "14:45", "15:40", "16:35", "17:25"};
    private static final String[] travelMethodString = {"最短距离策略", "最少时间策略", "交通工具的最短时间策略"};
    public ClassNavigateWindow() {
        init();
        setChooseMenuPanel();
        setPrintRoutePanel();
        addActionListenerToModel();
        classNavigateWindow.setLayout(null);
        classNavigateWindow.setBounds(100,100,1200,650);
        classNavigateWindow.setVisible(true);
        classNavigateWindow.setResizable(false);
        classNavigateWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    private void init() {
        classNavigateWindow = new JFrame();
        chooseMenuPanel = new JPanel();
        printRoutePanel = new JPanel();
    }
    private void setChooseMenuPanel() {
        chooseMenuPanel.setLayout(null);
        chooseMenuPanel.setBounds(0, 0,700,650);
        classNavigateWindow.add(chooseMenuPanel);
        classNavigateWindow.add(printRoutePanel);

        JLabel nameOfClass = new JLabel("课程名称", SwingConstants.CENTER);
        nameOfClass.setFont(font);
        nameOfClass.setBounds(50,50,100,50);
        chooseMenuPanel.add(nameOfClass);

        JLabel timeOfClass = new JLabel("上课时间", SwingConstants.CENTER);
        timeOfClass.setFont(font);
        timeOfClass.setBounds(50,150,100,50);
        chooseMenuPanel.add(timeOfClass);

        JLabel placeOfClass = new JLabel("上课地点", SwingConstants.CENTER);
        placeOfClass.setFont(font);
        placeOfClass.setBounds(50,250,100,50);
        chooseMenuPanel.add(placeOfClass);

        JLabel placeOfNow = new JLabel("您的当前位置", SwingConstants.CENTER);
        placeOfNow.setFont(font);
        placeOfNow.setBounds(50,350,150,50);
        chooseMenuPanel.add(placeOfNow);

        JLabel travelMethodLabel = new JLabel("您的出行策略");
        travelMethodLabel.setFont(font);
        travelMethodLabel.setBounds(50, 450, 150, 50);
        chooseMenuPanel.add(travelMethodLabel);

        nameOfClassField = new JTextField(SwingConstants.CENTER);
        nameOfClassField.setBounds(200,50,400,50);
        nameOfClassField.setFont(font);
        chooseMenuPanel.add(nameOfClassField);

        timeOfClassComboBox = new JComboBox<String>(timeOfClassString);
        timeOfClassComboBox.setFont(font);
        timeOfClassComboBox.setBounds(200, 150,300,50);
        chooseMenuPanel.add(timeOfClassComboBox);

        placeOfClassComboBox = new JComboBox<String>();
        placeOfClassComboBox.setFont(font);
        placeOfClassComboBox.setBounds(200, 250,400,50);
        chooseMenuPanel.add(placeOfClassComboBox);

        placeOfNowComboBox = new JComboBox<String>();
        placeOfNowComboBox.setFont(font);
        placeOfNowComboBox.setBounds(200,350,400,50);
        chooseMenuPanel.add(placeOfNowComboBox);

        travelMethodComboBox = new JComboBox<String>(travelMethodString);
        travelMethodComboBox.setFont(font);
        travelMethodComboBox.setBounds(200, 450, 300,50);
        chooseMenuPanel.add(travelMethodComboBox);

        confirmButton = new JButton("确认");
        confirmButton.setFont(font);
        confirmButton.setBounds(300,550,80,50);
        chooseMenuPanel.add(confirmButton);
    }
    private void setPrintRoutePanel() {
        printRoutePanel.setLayout(null);
        printRoutePanel.setBounds(700,0,500,650);

        JLabel printRoutePanelMsg = new JLabel("为您规划的路径如下", SwingConstants.CENTER);
        printRoutePanelMsg.setFont(font);
        printRoutePanelMsg.setBounds(50,50,300,50);
        printRoutePanel.add(printRoutePanelMsg);

        JTextArea printRouteArea = new JTextArea();
        printRouteArea.setBounds(50,150,400,500);
        printRouteArea.setFont(font);
        printRoutePanel.add(printRouteArea);
    }
    private void addActionListenerToModel() {
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
