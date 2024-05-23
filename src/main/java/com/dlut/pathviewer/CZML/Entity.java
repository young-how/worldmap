package com.dlut.pathviewer.CZML;

import com.dlut.pathviewer.CZML.entityElement.*;
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
    private Model model=new Model();  //模型贴图
    private Orientation orientation=new Orientation();  //速度方向
    private ViewForm viewFrom=new ViewForm();  //视图方向
    private Path path=new Path();  //路径显示参数
    private Position position=new Position();  //坐标

}
