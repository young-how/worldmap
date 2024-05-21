package com.dlut.pathviewer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class threaten {
    private coordinate center_point;  //威胁中心点
    private double R;  //威胁半径(KM)
}
