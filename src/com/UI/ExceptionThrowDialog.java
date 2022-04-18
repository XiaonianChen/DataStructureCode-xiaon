package com.UI;

import javax.swing.*;
import java.awt.*;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/611:01
 */
public class ExceptionThrowDialog {
    public ExceptionThrowDialog(String contest) {
        JFrame dialogFrame = new JFrame("异常提示框");
        dialogFrame.setLayout(null);
        dialogFrame.setVisible(true);
        dialogFrame.setBounds(200,200,300,200);
        JLabel dialogLabel = new JLabel(contest, SwingConstants.CENTER);
        dialogLabel.setBounds(0,0,300,200);
        dialogFrame.add(dialogLabel);
        dialogLabel.setFont(new Font("隶书", Font.PLAIN,18));
    }
}
