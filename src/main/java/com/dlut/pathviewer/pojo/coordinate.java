package com.dlut.pathviewer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class coordinate {
    private double longitude; //经度
    private double latitude; //纬度
    private double height; //高度(m)
}
