package com.dlut.pathviewer.CZML.entityElement;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML.entityElement
 * @className: viewForm
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/23 9:31
 * @version: 1.0
 */
@Data
public class ViewForm {
    private List<Double> cartesian=new ArrayList<>();  //坐标系
    public void addPoint(double longitude,double latitude,double height){
        cartesian.add(longitude);
        cartesian.add(latitude);
        cartesian.add(height);
    }
    public ViewForm(){
        //默认位置
        cartesian.add(0.0);
        cartesian.add(0.0);
        cartesian.add(100.0);
    }
}
