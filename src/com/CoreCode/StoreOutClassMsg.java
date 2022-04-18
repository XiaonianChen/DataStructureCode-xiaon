package com.CoreCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/1014:25
 */
public class StoreOutClassMsg {
    public static HashMap<String, OutClassActivityMsg> outClassActivityMsgHashMap = new HashMap<String, OutClassActivityMsg>();
    public static ArrayList<OutClassActivityMsg> outClassActivityMsgArray = new ArrayList();
    public StoreOutClassMsg(String account) {
        String pathName = ".\\Data\\OutClassCard\\" + account + "-OutClassCard.txt";
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
        String firstIdx = buff[1];
        OutClassActivityMsg tmp = new OutClassActivityMsg(buff[0], buff[1], Integer.parseInt(buff[2]), Integer.parseInt(buff[2]), buff[3], buff[4], buff[5]);
        outClassActivityMsgHashMap.put(firstIdx, tmp);
    }
    public void storeIntoArray(String line) {
        String[] buff = line.split("\\s+");
        String firstIdx = buff[1];
        OutClassActivityMsg tmp = new OutClassActivityMsg(buff[0], buff[1], Integer.parseInt(buff[2]), Integer.parseInt(buff[2]), buff[3], buff[4], buff[5]);
        outClassActivityMsgArray.add(tmp);
    }
}
