package com.dlut.pathviewer.CZML.entityElement;

import lombok.Data;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.CZML.entityElement
 * @className: Path
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/23 9:38
 * @version: 1.0
 */
@Data
public class Path {
    private Material material=new Material();
    private Width width=new Width();
}
