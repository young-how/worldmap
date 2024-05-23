package com.dlut.pathviewer.CZML.entityElement;

import lombok.Data;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML
 * @className: Orientation
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/23 9:28
 * @version: 1.0
 */
@Data
public class Orientation {
    private String velocityReference="#position"  ; //速度向量默认根据位置设置
}
