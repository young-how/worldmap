package com.dlut.pathviewer.pojo;

import lombok.Data;

import java.util.List;

@Data
public class path {
    List<coordinate> pathPoints;  //航路点
}
