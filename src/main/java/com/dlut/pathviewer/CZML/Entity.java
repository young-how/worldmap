package com.dlut.pathviewer.CZML;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML
 * @className: entity
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/22 20:52
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity extends base{
    private Position position;  //坐标
    private Model model;  //模型贴图
}
