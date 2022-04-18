package com.UI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author ccr
 * @Title: 西土城校区地图
 * @Package
 * @Description:
 * @date 2022/3/2515:10
 */
public class XituchengMapWindow {
    private final JFrame mapWindowOfXitucheng;
    public XituchengMapWindow() {
        mapWindowOfXitucheng = new JFrame("西土城校区地图");
        mapWindowOfXitucheng.setLayout(null);
        mapWindowOfXitucheng.setBounds(100,100,600,800);
        mapWindowOfXitucheng.setVisible(true);
        mapWindowOfXitucheng.setResizable(false);
        mapWindowOfXitucheng.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addMapToFrame();
    }
    private void addMapToFrame() {
        JLabel xituchengMap = new JLabel();
        xituchengMap.setLayout(null);
        xituchengMap.setBounds(0,0,600,800);
        URL url = XituchengMapWindow.class.getResource("xituchengMap.jpg");
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage(); // transform it
        Image newImg = image.getScaledInstance(600, 800, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newImg);  // transform it back
        xituchengMap.setIcon(imageIcon);
        mapWindowOfXitucheng.add(xituchengMap);
    }
}
