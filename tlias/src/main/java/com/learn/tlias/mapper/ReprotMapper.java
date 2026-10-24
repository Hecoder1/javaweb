package com.learn.tlias.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReprotMapper {
    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();
}
