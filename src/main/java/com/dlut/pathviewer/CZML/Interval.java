package com.dlut.pathviewer.CZML;

import lombok.Data;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML
 * @className: Interval
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/23 9:42
 * @version: 1.0
 */
@Data
public class Interval {
    public static String getInterval(int lastHour,int lastMin,int lastSec){
        // 创建格式化器，并指定格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        // 获取当前时间
        ZonedDateTime currentTime = ZonedDateTime.now();
        // 格式化当前时间
        String formattedTime = currentTime.format(formatter);
        // 加上持续时间后
        ZonedDateTime tenMinutesLater = currentTime.plusMinutes(lastMin).plusHours(lastHour).plusSeconds(lastSec);
        String formattedTenMinutesLater = tenMinutesLater.format(formatter);
        return  formattedTime+"/"+formattedTenMinutesLater;
    }
    public static String getTimeNow(){
        // 获取当前时间
        ZonedDateTime currentTime = ZonedDateTime.now();
        // 创建格式化器，并指定格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        // 格式化当前时间
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }
    public static String getTime(ZonedDateTime currentTime){
        // 创建格式化器，并指定格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        // 格式化当前时间
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }
    public static String getInterval(ZonedDateTime currentTime,int lastHour,int lastMin,int lastSec){
        // 创建格式化器，并指定格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        // 格式化当前时间
        String formattedTime = currentTime.format(formatter);
        // 加上持续时间后
        ZonedDateTime tenMinutesLater = currentTime.plusMinutes(lastMin).plusHours(lastHour).plusSeconds(lastSec);
        String formattedTenMinutesLater = tenMinutesLater.format(formatter);
        return  formattedTime+"/"+formattedTenMinutesLater;
    }
    public static String getRange(int lastHour,int lastMin,int lastSec){
        // 创建格式化器，并指定格式
        ZonedDateTime currentTime=ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        // 格式化当前时间
        String formattedTime = currentTime.format(formatter);
        // 加上持续时间后
        ZonedDateTime tenMinutesLater = currentTime.plusMinutes(lastMin).plusHours(lastHour).plusSeconds(lastSec);
        String formattedTenMinutesLater = tenMinutesLater.format(formatter);
        return  formattedTime+"/"+formattedTenMinutesLater;
    }
    public static String getTimeEnd(ZonedDateTime currentTime,int lastHour,int lastMin,int lastSec){
        // 创建格式化器，并指定格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        // 格式化当前时间
        String formattedTime = currentTime.format(formatter);
        // 加上持续时间后
        ZonedDateTime tenMinutesLater = currentTime.plusMinutes(lastMin).plusHours(lastHour).plusSeconds(lastSec);
        String formattedTenMinutesLater = tenMinutesLater.format(formatter);
        return  formattedTenMinutesLater;
    }
}
