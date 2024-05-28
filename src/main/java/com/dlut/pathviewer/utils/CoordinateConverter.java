package com.dlut.pathviewer.utils;


import static org.apache.sis.util.resources.Vocabulary.Keys.Coordinate;

public class CoordinateConverter {
    // 地球半径（单位：米）
    private static final double EARTH_RADIUS = 6371000;

    // 经纬度增量计算函数
    public static double[] calculateNewCoordinates(double originLongitude, double originLatitude,
                                                   double deltaX, double deltaY) {
        // 将经度和纬度转换为弧度
        double radOriginLongitude = Math.toRadians(originLongitude);
        double radOriginLatitude = Math.toRadians(originLatitude);

        // 计算新的经度
        double newLongitude = originLongitude + Math.toDegrees(deltaX / (EARTH_RADIUS * Math.cos(radOriginLatitude)));

        // 计算新的纬度
        double newLatitude = originLatitude + Math.toDegrees(deltaY / EARTH_RADIUS);

        // 返回新的经纬度坐标
        return new double[]{newLongitude, newLatitude};
    }

    public static void main(String[] args) {
        // 原点的经度和纬度
        double originLongitude = 121.5; // 例如上海的经度
        double originLatitude = 31.2; // 例如上海的纬度

        // 增量（以米为单位）
        double deltaX = 10; // 10公里
        double deltaY = 50; // 5公里

        // 计算新的经纬度坐标
        double[] newCoordinates = calculateNewCoordinates(originLongitude, originLatitude, deltaX, deltaY);

        // 打印结果
        System.out.println("新的经度：" + newCoordinates[0]);
        System.out.println("新的纬度：" + newCoordinates[1]);
    }
}
