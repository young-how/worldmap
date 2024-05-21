package com.dlut.pathviewer.controller;

import com.dlut.pathviewer.pojo.coordinate;
import com.dlut.pathviewer.pojo.path;
import com.dlut.pathviewer.pojo.threaten;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class pathController {
    @GetMapping("/worldMap")
    public String getWorldMap(){
        return "earth";
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
}
