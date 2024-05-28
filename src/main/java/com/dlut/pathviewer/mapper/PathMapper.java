package com.dlut.pathviewer.mapper;

import com.dlut.pathviewer.pojo.PathInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PathMapper {
    @Select("select  json from TrainInfo_Json ")
    List<String> getPaths();
    @Select("select  json from TrainInfo_Json where uuid=#{uuid}")
    PathInfo getPath(String uuid);
}
