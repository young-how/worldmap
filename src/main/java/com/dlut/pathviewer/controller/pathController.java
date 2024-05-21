package com.dlut.pathviewer.controller;

import com.dlut.pathviewer.pojo.coordinate;
import com.dlut.pathviewer.pojo.threaten;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class pathController {
    @GetMapping("/getThreatens")
    public ResponseEntity<List<threaten>> getThreatens(){
        List<threaten> re=new ArrayList<>();
        //案例，在该处得到威胁数据并加入响应体中
        threaten rd1=new threaten(new coordinate(23.5, 121.0,0), 200);
        threaten rd2=new threaten(new coordinate(24.7, 122.2,0), 100);
        re.add(rd1);
        re.add(rd2);
        return  ResponseEntity.ok().body(re);
    }
}
