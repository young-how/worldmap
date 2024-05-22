package com.dlut.pathviewer.CZML;

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
    private List<Double> cartographicDegrees=new ArrayList<>();
    //添加经纬高
    public void addPoint(double longitude,double latitude,double height){
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
