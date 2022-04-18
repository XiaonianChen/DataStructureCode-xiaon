package com.Run;

import com.UI.*;
import com.CoreCode.*;

import java.util.HashMap;

import static com.CoreCode.StoreCourseMsg.courseMsgHashMap;

/**
 * @author ccr
 * @Title: 入口
 * @Package
 * @Description: 程序入口
 * @date 2022/3/2916:17
 */
public class RunCode {
    public static void main(String[] args) {
        new LoginWindow();
    }
    private static void createDialogTxt() {
        String dialogPath = System.getProperty ("user.dir");
        dialogPath = dialogPath.concat("\\Data\\dialog.txt");
        DialogCreate.createFile(dialogPath);
    }
}
