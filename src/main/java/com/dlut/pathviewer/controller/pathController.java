package com.dlut.pathviewer.controller;

import com.dlut.pathviewer.CZML.*;
import com.dlut.pathviewer.CZML.entityElement.Model;
import com.dlut.pathviewer.CZML.entityElement.Position;
import com.dlut.pathviewer.pojo.coordinate;
import com.dlut.pathviewer.pojo.threaten;
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
    @GetMapping("/worldMap")
    public String getWorldMap(){
        return "earth";
    }
    @GetMapping("/CZMLTest")
    public String getCZMLPath(){
        return "CZML_Earth";
    }
    @GetMapping("/getThreatens")
    public ResponseEntity<List<threaten>> getThreatens(){
        List<threaten> re=new ArrayList<>();
        //案例，在该处得到威胁数据并加入响应体中
        threaten rd1=new threaten(new coordinate(121.0,23.5,0), 200*1000);
        threaten rd2=new threaten(new coordinate(122.2,24.7, 0), 100*1000);
        re.add(rd1);
        re.add(rd2);
        return  ResponseEntity.ok().body(re);
    }
    @GetMapping("/pathInfo")
    public ResponseEntity<List<coordinate>> getPath(){
        List<coordinate> re=new ArrayList<>();
        //案例，将航线点放入相应中
        re.add(new coordinate( 119.2965,  26.0745,  0));
        re.add(new coordinate( 119.3036,  25.9948,  0));
        re.add(new coordinate( 119.3484,   25.8741,  0));
        re.add(new coordinate( 119.3745,  25.7752,  0));
        re.add(new coordinate( 119.4253,  25.6491,  0));
        re.add(new coordinate( 121.5654,  25.0330,  0));
        return  ResponseEntity.ok().body(re);
    }
    @GetMapping("/CZML_threatens")
    public ResponseEntity<String> getCZML_Threatens(){
        String re="[\n" +
                "  {\n" +
                "    \"id\": \"document\",\n" +
                "    \"name\": \"CZML Model\",\n" +
                "    \"version\": \"1.0\"\n" + // 移除逗号
                "  },\n" +
                "  {\n" +
                "    \"id\": \"aircraft model\",\n" +
                "    \"name\": \"Cesium Air\",\n" +
                "    \"position\": {\n" +
                "      \"cartographicDegrees\": [-77, 37, 10000]\n" + // 移除逗号
                "    },\n" +
                "    \"model\": {\n" +
                "      \"gltf\": \"http://localhost:4399/model/J20.glb\",\n" +
                "      \"scale\": 2.0,\n" +
                "      \"minimumPixelSize\": 128\n" + // 移除逗号
                "    }\n" +
                "  }\n" +
                "]";
        return  ResponseEntity.ok().body(re);
    }
    @GetMapping("/CZML_string")
    public ResponseEntity<List<Object>> getCZML(){
        CZML re=new CZML();
        re.addEntity(new Head("document","CZML Model","1.0"));
        Entity zdj=new Entity();
        zdj.setId("zdj");
        zdj.setName("zdj_entity");
        zdj.setPosition(new Position(-77, 37, 10000));
        Model model=new Model();
        model.setGltf("http://localhost:4399/model/J20.glb");
        model.setScale(2.0);
        model.setMinimumPixelSize(128);
        model.setMaximumScale(20000);
        zdj.setModel(model);
        re.addEntity(zdj);
        return  ResponseEntity.ok().body(re.getCzml());
    }
    @GetMapping("/czml")
    public List<Map<String, Object>> getCzml() {
        Map<String, Object> document = Map.of(
                "id", "document",
                "name", "CZML Model",
                "version", "1.0"
        );

        Map<String, Object> aircraftModel = Map.of(
                "id", "aircraft model",
                "name", "Cesium Air",
                "position", Map.of("cartographicDegrees", Arrays.asList(-77, 37, 10000)),
                "model", Map.of(
                        "gltf", "../SampleData/models/CesiumAir/Cesium_Air.glb",
                        "scale", 2.0,
                        "minimumPixelSize", 128
                )
        );

        return Arrays.asList(document, aircraftModel);
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
        System.out.println(ZDJ_Path_Template_Reader.readTemplate("C:\\younghow\\gitworkspace\\worldmap\\src\\main\\resources\\static\\CZML\\ZDJ_Path_template.czml"));
        ZDJ_Path_Template_Reader.setModelName("J20.glb");
        List<Double> path=new ArrayList<>();
        path.addAll(List.of(0.0,119.2965,  26.0745,  1000.0));
        path.addAll(List.of(300.0,119.3036,  25.9948,  1000.0));
        path.addAll(List.of(600.0,119.3484,   25.8741,  1000.0));
        path.addAll(List.of(900.0,119.3745,  25.7752, 1000.0));
        path.addAll(List.of(1200.0,119.4253,  25.6491,  1000.0));
        path.addAll(List.of(1500.0,121.5654,  25.0330,   1000.0));
        ZDJ_Path_Template_Reader.setPath(path);
        ZDJ_Path_Template_Reader.setStartAndEnd(0,60,0);
        String re=ZDJ_Path_Template_Reader.currentTemplate;
        return ResponseEntity.ok().body(re);
    }
    @GetMapping("/CZML_RDs")
    public ResponseEntity<String> getCZML_RDs(){
        System.out.println(RDTemplateReader.readTemplate("C:\\younghow\\gitworkspace\\worldmap\\src\\main\\resources\\static\\CZML\\RD.czml"));
        RDTemplateReader.AddRD(121.0,23.5,0, 200*1000);
        RDTemplateReader.AddRD(121.0,24.5,0, 100*1000);
        String re=RDTemplateReader.getRDs();
        return ResponseEntity.ok().body(re);
    }
}
