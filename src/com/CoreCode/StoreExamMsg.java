package com.CoreCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ccr
 * @Title:
 * @Package
 * @Description: 存储考试日程
 * @date 2022/4/617:57
 */
public class StoreExamMsg {
    public static HashMap<String, ExamMsg> examMsgHashMap = new HashMap<String, ExamMsg>();
    public static ArrayList<ExamMsg> examMsgArray = new ArrayList();
    public StoreExamMsg(String account) {
        String pathName = ".\\Data\\ExamCard\\" + account + "-ExamCard.txt";
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
//        for (String key: examMsgHashMap.keySet()) {
//            System.out.println(examMsgHashMap.get(key));
//        }
    }
    private void storeIntoHashMap(String line) {
        String[] buff = line.split("\\s+");
        ExamMsg tmp = new ExamMsg(buff[0], Integer.parseInt(buff[1]), Integer.parseInt(buff[2]), buff[3], buff[4], buff[5]);
        examMsgHashMap.put(buff[0], tmp);
    }
    public void storeIntoArray(String line) {
        String[] buff = line.split("\\s+");
        ExamMsg tmp = new ExamMsg(buff[0], Integer.parseInt(buff[1]), Integer.parseInt(buff[2]), buff[3], buff[4], buff[5]);
        examMsgArray.add(tmp);
    }
}
