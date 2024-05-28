package com.dlut.pathviewer;

import com.dlut.pathviewer.pojo.PathInfo;
import com.dlut.pathviewer.service.pathService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PathViewerApplicationTests {
    @Autowired
    private pathService pathservice;
    @Test
    void contextLoads() throws JsonProcessingException {
    }

}
