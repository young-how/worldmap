package com.dlut.pathviewer.controller;

import com.dlut.pathviewer.pojo.PathInfo;
import com.dlut.pathviewer.service.pathService;
import com.dlut.pathviewer.utils.Area_Template_Reader;
import com.dlut.pathviewer.utils.RDTemplateReader;
import com.dlut.pathviewer.utils.ZDJ_Path_Template_Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.sis.geometry.DirectPosition2D;
import org.apache.sis.referencing.CRS;
import org.apache.sis.referencing.GeodeticCalculator;
import org.opengis.geometry.DirectPosition;
import org.opengis.referencing.crs.CRSFactory;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static com.dlut.pathviewer.utils.CoordinateConverter.calculateNewCoordinates;

@Controller
public class uavController {
    //原点的经纬度
    double originLongitude= 21.25169434457818;  //经度
    double originLatitude=-0.008901753746210805;  //纬度
    double ori_z=390;
    @Autowired
    private pathService pathservice;
    private Integer sample_num=0;
    private List<PathInfo> samples;
    @GetMapping("/uavViewer")
    public String getCZMLPath(){
        return "UAV_Path";
    }
    @GetMapping("/getSampleCount")
    public ResponseEntity<Integer> getSampleCount(){
        try{
            samples=pathservice.getPaths();
            sample_num=samples.size();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok().body(sample_num);
    }
    @GetMapping("/getPath")
    public ResponseEntity<String> getPath(@RequestParam("no") int no){
        System.out.println(ZDJ_Path_Template_Reader.readTemplate("src/main/resources/static/CZML/UAV_Path_template.czml"));

        List<Double> path=new ArrayList<>();
        List<List<Double>> path_re=samples.get(no-1).getPath();
        int time=path_re.size();  //路径时长
        double time_count=0;
        for(List<Double> p:path_re){
            double deltaX=p.get(0);
            double deltaY=p.get(1);
            path.add(time_count); //加入时间长度
            double[] newCoordinates = calculateNewCoordinates(originLongitude, originLatitude, deltaX, deltaY);
            path.add(newCoordinates[0]);
            path.add(newCoordinates[1]);
            path.add(p.get(2)+ori_z);
            time_count=time_count+1;
        }
        String re=ZDJ_Path_Template_Reader.SetZDJPath("CesiumDrone.glb",path,0,0,time);
        return ResponseEntity.ok().body(re);
    }
    @GetMapping("/getArea")
    public ResponseEntity<String> getArea(@RequestParam("no") int no){
        System.out.println(RDTemplateReader.readTemplate("src/main/resources/static/CZML/RD.czml"));
        List<PathInfo.Building> buildings=samples.get(no-1).getThreaten();
        for(PathInfo.Building house:buildings){
            double deltaX=house.getPosition().getX();
            double deltaY=house.getPosition().getY();
            double[] newCoordinates = calculateNewCoordinates(originLongitude, originLatitude, deltaX, deltaY);
            RDTemplateReader.AddCy(newCoordinates[0],newCoordinates[1],ori_z,house.get_H(),house.get_R());
        }
        String re=RDTemplateReader.getRDs();
        return ResponseEntity.ok().body(re);
    }
}
