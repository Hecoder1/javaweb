package com.learn.tlias.service.Impl;

import com.learn.tlias.mapper.EmpMapper;
import com.learn.tlias.mapper.ReprotMapper;
import com.learn.tlias.pojo.JobOption;
import com.learn.tlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReprotMapper reportMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> mapList = reportMapper.countEmpJobData();
        List<String> jobList = new ArrayList<>();
        List<Object> dataList = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            jobList.add(map.get("pos").toString());
            dataList.add(map.get("total"));
        }
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
