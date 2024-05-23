package com.dlut.pathviewer.utils;

import com.dlut.pathviewer.CZML.Interval;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.utils
 * @className: modelReader
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/23 11:05
 * @version: 1.0
 */
public class ZDJ_Path_Template_Reader extends TemplateReader{

    public static void main(String[] args) {
        System.out.println(readTemplate("C:\\younghow\\gitworkspace\\worldmap\\src\\main\\resources\\static\\CZML\\ZDJ_Path_template.czml"));
        setModelName("J20.glb");
        List<Double> path=new ArrayList<>();
        path.addAll(List.of(0.0,119.2965,  26.0745,  1000.0));
        path.addAll(List.of(300.0,119.3036,  25.9948,  1000.0));
        path.addAll(List.of(600.0,119.3484,   25.8741,  1000.0));
        path.addAll(List.of(900.0,119.3745,  25.7752, 1000.0));
        path.addAll(List.of(1200.0,119.4253,  25.6491,  1000.0));
        path.addAll(List.of(1500.0,121.5654,  25.0330,   1000.0));
        setPath(path);
        System.out.println(currentTemplate);
    }
    /*
     * @param url:
      * @return void
     * @author younghow
     * @description 设置模型贴图
     * @date younghow younghow
     */
    public static void setModelName(String modelName){
        currentTemplate=currentTemplate.replace("@modelName@",modelName) ;//替换模型名称
    }
//    public static void setTimeRange(int lastHour,int lastMin,int lastSec){
//        String timeNow=Interval.getTimeNow();
//        currentTemplate=currentTemplate.replace("@timeRange@", Interval.getRange(lastHour,lastMin,lastSec)) ;//替换模型名称
//    }
    public static void setPath(List<Double> path){
        String timeNow=Interval.getTimeNow();
        currentTemplate=currentTemplate.replace("@ZDJ_Path@", path.toString()) ;//替换模型名称
    }
    public static void setStartAndEnd(int lastHour,int lastMin,int lastSec){
        ZonedDateTime currentTime=ZonedDateTime.now();
        String timeNow=Interval.getTime(currentTime);
        String timeEnd=Interval.getTimeEnd(currentTime,lastHour,lastMin,lastSec);
        currentTemplate=currentTemplate.replace("@StartTime@", timeNow) ;//起始时间
        currentTemplate=currentTemplate.replace("@timeRange@", timeNow+"/"+timeEnd) ;//时间范围
    }
}
