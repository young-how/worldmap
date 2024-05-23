package com.dlut.pathviewer.CZML.entityElement;

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
    private double scale=2.0; //尺寸
    private int minimumPixelSize=128; //最小尺寸
    private int maximumScale=20000; //最大尺寸
}
