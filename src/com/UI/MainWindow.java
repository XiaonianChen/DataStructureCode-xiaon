package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * @author ccr
 * @Title: 主窗口界面
 * @Package
 * @Description: 主窗口显示
 * @date 2022/3/2420:05
 */
public class MainWindow{
    private final JFrame mainWindow;
    private JPanel panelOfMap;
    private JPanel panelOfFunctionMenu;
    private JPanel panelOfTimePrint;
    private JButton classMsg;
    private JButton outClassMsg;
    private JButton classNavigate;
    private JButton dialogPrint;
    private JButton XituchengMap;
    private ClassMsgWindow classMsgWindow;
    private ClassNavigateWindow classNavigateWindow;
    private OutClassMsgWindow outClassMsgWindow;
    public MainWindow() {
        mainWindow = new JFrame("沙河校区主界面");
        mainWindow.setLayout(null);
        // 初始化四个面板
        initPanel();
        // 将四个面板添加到主页面中
        addPanelToMainWindow();
        // 设置PanelOfMap面板
        setPanelOfMap();
        // 设置PanelOfFunctionMenu面板
        setPanelOfFunctionMenu();
        // 设置PanelOfTimePrint面板
        setPanelOfTimePrint();
        // 设置按钮事件
        addActionToButton();
        mainWindow.setBounds(100,50,1200,750);
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public ClassMsgWindow getClassMsgWindow() {
        return classMsgWindow;
    }

    public ClassNavigateWindow getClassNavigateWindow() {
        return classNavigateWindow;
    }

    public OutClassMsgWindow getOutClassMsgWindow() {
        return outClassMsgWindow;
    }

    private void setPanelOfMap() {
        panelOfMap.setBounds(0,0,900,700);
        JLabel ShaheMap = new JLabel();
        URL url = MainWindow.class.getResource("ShaheMap.jpg");
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage(); // transform it
        Image newImg = image.getScaledInstance(860, 700,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newImg);  // transform it back
        ShaheMap.setIcon(imageIcon);
        panelOfMap.add(ShaheMap);
    }
    private void setPanelOfFunctionMenu() {
        panelOfFunctionMenu.setLayout(null);
        panelOfFunctionMenu.setBounds(900,0,500,500);
        classMsg = new JButton("课内信息");
        outClassMsg = new JButton("课外信息");
        classNavigate = new JButton("课程导航");
        dialogPrint = new JButton("日志打印");
        XituchengMap = new JButton("切换至西土城");
        classMsg.setBounds(0,0,150,150);
        outClassMsg.setBounds(150,0,150,150);
        classNavigate.setBounds(0,150,150,150);
        dialogPrint.setBounds(150,150,150,150);
        XituchengMap.setBounds(0,300,300,150);
        panelOfFunctionMenu.add(classMsg);
        panelOfFunctionMenu.add(outClassMsg);
        panelOfFunctionMenu.add(classNavigate);
        panelOfFunctionMenu.add(dialogPrint);
        panelOfFunctionMenu.add(XituchengMap);
    }
    private void addActionToButton() {
        classMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classMsgWindow = new ClassMsgWindow();
            }
        });
        outClassMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outClassMsgWindow = new OutClassMsgWindow();
            }
        });
        classNavigate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classNavigateWindow = new ClassNavigateWindow();
            }
        });
        dialogPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        XituchengMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new XituchengMapWindow();
            }
        });
    }
    private void setPanelOfTimePrint() {

    }
    private void initPanel() {
        panelOfMap = new JPanel();
        panelOfFunctionMenu = new JPanel();
        panelOfTimePrint = new JPanel();
    }
    private void addPanelToMainWindow() {
        mainWindow.getContentPane().add(panelOfMap);
        mainWindow.getContentPane().add(panelOfFunctionMenu);
    }
}
