package com.dlut.pathviewer.utils;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

public class SmoothPath {

    public static List<List<Double>> smoothPath(List<List<Double>> path) {
        List<Double> times = new ArrayList<>();
        List<Double> xCoords = new ArrayList<>();
        List<Double> yCoords = new ArrayList<>();
        List<Double> zCoords = new ArrayList<>();

        // 提取时间和坐标
        for (List<Double> point : path) {
            times.add(point.get(0));
            xCoords.add(point.get(1));
            yCoords.add(point.get(2));
            zCoords.add(point.get(3));
        }

        // 将List转换为数组
        double[] timeArray = times.stream().mapToDouble(Double::doubleValue).toArray();
        double[] xArray = xCoords.stream().mapToDouble(Double::doubleValue).toArray();
        double[] yArray = yCoords.stream().mapToDouble(Double::doubleValue).toArray();
        double[] zArray = zCoords.stream().mapToDouble(Double::doubleValue).toArray();

        // 使用样条插值法
        SplineInterpolator interpolator = new SplineInterpolator();
        PolynomialSplineFunction xSpline = interpolator.interpolate(timeArray, xArray);
        PolynomialSplineFunction ySpline = interpolator.interpolate(timeArray, yArray);
        PolynomialSplineFunction zSpline = interpolator.interpolate(timeArray, zArray);

        List<List<Double>> smoothPath = new ArrayList<>();

        // 生成平滑后的路径
        for (double t : timeArray) {
            List<Double> smoothPoint = new ArrayList<>();
            smoothPoint.add(t);
            smoothPoint.add(xSpline.value(t));
            smoothPoint.add(ySpline.value(t));
            smoothPoint.add(zSpline.value(t));
            smoothPath.add(smoothPoint);
        }

        return smoothPath;
    }
}