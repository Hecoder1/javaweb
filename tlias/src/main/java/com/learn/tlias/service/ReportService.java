package com.learn.tlias.service;

import com.learn.tlias.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();

    List<Map> getEmpGenderData();
}
