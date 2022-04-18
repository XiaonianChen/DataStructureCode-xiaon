package com.CoreCode;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 创建一个Dialog.txt文件
 * @date 2022/3/2915:41
 */
public class DialogCreate {
    public static void createFile(String filePath) {
//        String dialogPath = System.getProperty ("user.dir");
//        dialogPath = dialogPath.concat("\\Data\\1.txt");
        System.out.println(filePath);
        try{
            File dialog = new File(filePath);
            if (dialog.createNewFile()) {
                System.out.println("文件创建成功！");
            }
            else {
                System.out.println("出错了，该文件已经存在。");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
