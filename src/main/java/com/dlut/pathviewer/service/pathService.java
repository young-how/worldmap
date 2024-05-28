package com.dlut.pathviewer.service;

import com.dlut.pathviewer.mapper.PathMapper;
import com.dlut.pathviewer.pojo.PathInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class pathService {
    @Autowired
    private  PathMapper pathMapper;
    public List<PathInfo> getPaths() throws JsonProcessingException {
        List<PathInfo> paths=new ArrayList<>();
        List<String> re=pathMapper.getPaths();
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        for(String path:re){
            PathInfo result=mapper.readValue(path,PathInfo.class);
            paths.add(result);
        }
        return paths;
    }
    public static void main(String[] args) {
        String jsonString = "{\n" +
                "  \"Threaten\": [\n" +
                "    {\n" +
                "      \"Threaten_Type\": \"building\",\n" +
                "      \"position\": {\n" +
                "        \"x\": 285.3311642197549,\n" +
                "        \"y\": 454.6501406344541,\n" +
                "        \"z\": 0.0\n" +
                "      },\n" +
                "      \"_R\": 36.88654255742157,\n" +
                "      \"_H\": 14.12086054077978\n" +
                "    },\n" +
                "    {\n" +
                "      \"Threaten_Type\": \"building\",\n" +
                "      \"position\": {\n" +
                "        \"x\": 129.24417454273063,\n" +
                "        \"y\": 197.42805563348264,\n" +
                "        \"z\": 0.0\n" +
                "      },\n" +
                "      \"_R\": 18.842250703647814,\n" +
                "      \"_H\": 31.114940169707282\n" +
                "    },\n" +
                "    {\n" +
                "      \"Threaten_Type\": \"building\",\n" +
                "      \"position\": {\n" +
                "        \"x\": 33.11602320013623,\n" +
                "        \"y\": 97.15156496261274,\n" +
                "        \"z\": 0.0\n" +
                "      },\n" +
                "      \"_R\": 44.09622411738608,\n" +
                "      \"_H\": 25.003991868136175\n" +
                "    }\n" +
                "  ],\n" +
                "  \"path\": [\n" +
                "    [42.602790281716395, 21.189367848028745, 0],\n" +
                "    [43.42065282673397, 21.764781488340972, 0],\n" +
                "    [43.865265872248834, 22.66050423548877, 0],\n" +
                "    [44.61817825660102, 23.318625000614063, 0],\n" +
                "    [45.07507009235394, 24.208147260269396, 0],\n" +
                "    [45.03738642314203, 25.207436978556704, 0],\n" +
                "    [44.5715465731523, 26.092306027716827, 0],\n" +
                "    [43.831249189973384, 26.764585571105183, 0],\n" +
                "    [42.859891358979816, 27.002207043551316, 0]\n" +
                "  ],\n" +
                "  \"epoch\": 4\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            PathInfo result = mapper.readValue(jsonString, PathInfo.class);
            System.out.println(result.getThreaten()); // 应该打印出不为null的列表
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
