package com.dlut.pathviewer.CZML;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML
 * @className: model
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/22 20:48
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    private String gltf;  //贴图
    private double scale; //尺寸
    private int minimumPixelSize; //最小尺寸
    private int maximumScale; //最大尺寸
}
