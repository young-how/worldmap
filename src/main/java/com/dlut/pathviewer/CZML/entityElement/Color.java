package com.dlut.pathviewer.CZML.entityElement;

import com.dlut.pathviewer.CZML.Interval;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML.entityElement
 * @className: Color
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/23 9:51
 * @version: 1.0
 */
@Data
public class Color {
    private List<Integer> rgba=new ArrayList<>();
    public Color(){
        rgba.add(255);
        rgba.add(255);
        rgba.add(0);
        rgba.add(255);
    }
    public Color(int r,int g,int b,int a){
        rgba.add(r);
        rgba.add(g);
        rgba.add(b);
        rgba.add(a);
    }
}
