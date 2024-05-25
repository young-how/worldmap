package com.dlut.pathviewer.controller;

import com.dlut.pathviewer.CZML.*;
import com.dlut.pathviewer.CZML.entityElement.Model;
import com.dlut.pathviewer.CZML.entityElement.Position;
import com.dlut.pathviewer.pojo.coordinate;
import com.dlut.pathviewer.pojo.threaten;
import com.dlut.pathviewer.utils.Area_Template_Reader;
import com.dlut.pathviewer.utils.RDTemplateReader;
import com.dlut.pathviewer.utils.ZDJ_Path_Template_Reader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class pathController {
    @GetMapping("/CZMLTest")
    public String getCZMLPath(){
        return "CZML_Earth";
    }
    @GetMapping("/CZML_Entity")
    public ResponseEntity<List<Object>> getCZML_path(){
        CZML re=new CZML();
        re.addEntity(new Head("document","CZML Model","1.0"));
        Entity zdj=new Entity();
        zdj.setId("ZDJ");
        zdj.setName("ZDJ");
        zdj.getModel().setGltf("../model/J20.glb"); //设置模型
        //设置路径
        zdj.getPosition().addPoint(0.0,119.2965,  26.0745,  1000);
        zdj.getPosition().addPoint(300.0,119.3036,  25.9948,  1000);
        zdj.getPosition().addPoint(600.0,119.3484,   25.8741,  1000);
        zdj.getPosition().addPoint(900.0,119.3745,  25.7752,  1000);
        zdj.getPosition().addPoint(1200.0,119.4253,  25.6491,  1000);
        zdj.getPosition().addPoint(1500.0,121.5654,  25.0330,  1000);
        re.addEntity(zdj);
        return  ResponseEntity.ok().body(re.getCzml());
    }
    @GetMapping("/CZML_Template")
    public ResponseEntity<String> getCZML_Template_path(){
        System.out.println(ZDJ_Path_Template_Reader.readTemplate("src/main/resources/static/CZML/ZDJ_Path_template.czml"));
//        ZDJ_Path_Template_Reader.setModelName("J20.glb");
        List<Double> path=new ArrayList<>();
        path.addAll(List.of(0.0,119.2965,  26.0745,  1000.0));
        path.addAll(List.of(300.0,119.3036,  25.9948,  1000.0));
        path.addAll(List.of(600.0,119.3484,   25.8741,  1000.0));
        path.addAll(List.of(900.0,119.3745,  25.7752, 1000.0));
        path.addAll(List.of(1200.0,119.4253,  25.6491,  1000.0));
        path.addAll(List.of(1500.0,121.5654,  25.0330,   1000.0));
//        ZDJ_Path_Template_Reader.setPath(path);
//        ZDJ_Path_Template_Reader.setStartAndEnd(0,60,0);
        String re=ZDJ_Path_Template_Reader.SetZDJPath("J20.glb",path,0,0,1500);
        return ResponseEntity.ok().body(re);
    }
    @GetMapping("/CZML_RDs")
    public ResponseEntity<String> getCZML_RDs(){
        System.out.println(RDTemplateReader.readTemplate("src/main/resources/static/CZML/RD.czml"));
        RDTemplateReader.AddRD(121.0,23.5,0, 200*1000);
        RDTemplateReader.AddRD(121.0,24.5,0, 100*1000);
        String re=RDTemplateReader.getRDs();
        return ResponseEntity.ok().body(re);
    }
    @GetMapping("/CZML_Area")
    public ResponseEntity<String> getCZML_Area(){
        System.out.println(Area_Template_Reader.readTemplate("src/main/resources/static/CZML/Area.czml"));
        String re=Area_Template_Reader.setArea(117,  22.0745,125,  27.0745);
        return ResponseEntity.ok().body(re);
    }
}
