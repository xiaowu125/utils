package com.wwh.conditionmonitor.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @Auther: wuwenhua
 * @Date: 2020/11/15 11:05
 * @Description:
 */
public class IOUtil {

    public static JSONObject fileToJson(File file){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String data = null;
        try {
            data = IOUtils.toString(fileInputStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data !=null) {
            return JSON.parseObject(data);
        }
       return  null;
    }

    public static  void JsonWriteFile(File file,JSONObject jsonObject){
        if (!file.exists()){
            if (!file.getParentFile().exists()){
                file.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream tmpFileOut = null;
        try {
            tmpFileOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (tmpFileOut != null) {
            try {
                IOUtils.write(jsonObject.toString(SerializerFeature.PrettyFormat),tmpFileOut,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void JsonWriteFile(File file,JSONArray jsonObject){
        FileOutputStream tmpFileOut = null;
        try {
            tmpFileOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (tmpFileOut != null) {
            try {
                IOUtils.write(jsonObject.toString(SerializerFeature.PrettyFormat),tmpFileOut,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String fileToString(File file){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String data = null;
        try {
            data = IOUtils.toString(fileInputStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data !=null) {
            return data;
        }
        return  null;
    }

    public static JSONArray fileToJsonArray(File file){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String data = null;
        try {
            data = IOUtils.toString(fileInputStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data !=null) {
            return JSON.parseArray(data);
        }
        return  null;
    }
    public static JSONArray fileToJsonArray1(File file){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String data = null;
        try {
            data = IOUtils.toString(fileInputStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data !=null) {
            data = "["+data+"]";
            return JSON.parseArray(data);
        }
        return  null;
    }
}
