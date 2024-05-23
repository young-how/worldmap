package com.dlut.pathviewer.CZML.entityElement;

import com.dlut.pathviewer.CZML.Interval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML
 * @className: Position
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/22 20:54
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private String interpolationAlgorithm="LAGRANGE";  //插值算法
    private int interpolationDegree=1;    //插值度数
    private String epoch= Interval.getTimeNow();   //起始时间
    private List<Double> cartographicDegrees=new ArrayList<>();  //经纬高坐标系
    //添加经纬高
    public void addPoint(double longitude,double latitude,double height){
        cartographicDegrees.add(longitude);
        cartographicDegrees.add(latitude);
        cartographicDegrees.add(height);
    }
    public void addPoint(double time,double longitude,double latitude,double height){
        cartographicDegrees.add(time);
        cartographicDegrees.add(longitude);
        cartographicDegrees.add(latitude);
        cartographicDegrees.add(height);
    }
    public Position(double longitude,double latitude,double height){
        cartographicDegrees.add(longitude);
        cartographicDegrees.add(latitude);
        cartographicDegrees.add(height);
    }
}
