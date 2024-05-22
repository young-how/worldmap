package com.dlut.pathviewer.CZML;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML
 * @className: CZML
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/22 20:59
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CZML {
    private List<Object> czml=new ArrayList<>();
    public void addEntity(Object entity){
        czml.add(entity);
    }
}
