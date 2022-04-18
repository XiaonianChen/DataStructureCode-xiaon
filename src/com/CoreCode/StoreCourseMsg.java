package com.CoreCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 创建CourseMsg类数组, 存储课程信息
 * @date 2022/4/320:02
 */
public class StoreCourseMsg {
    public static HashMap<String, CourseMsg>courseMsgHashMap = new HashMap<String, CourseMsg>();
    public static ArrayList<CourseMsg>courseMsgArray = new ArrayList();
    public StoreCourseMsg(String account) {
        String pathName = ".\\Data\\ClassScheduleCard\\" + account + "-ClassScheduleCard.txt";
        File file = new File(pathName);
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                storeIntoHashMap(line);
                storeIntoArray(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void storeIntoHashMap(String line) {
        String[] buff = line.split("\\s+");
        String firstIdx = buff[0];
        CourseMsg tmp = new CourseMsg(buff[0], Integer.parseInt(buff[1]), buff[2], buff[3], buff[4], buff[5]);
        courseMsgHashMap.put(firstIdx, tmp);
    }
    public void storeIntoArray(String line) {
        String[] buff = line.split("\\s+");
        String firstIdx = buff[0];
        CourseMsg tmp = new CourseMsg(buff[0], Integer.parseInt(buff[1]), buff[2], buff[3], buff[4], buff[5]);
        courseMsgArray.add(tmp);
    }
}
