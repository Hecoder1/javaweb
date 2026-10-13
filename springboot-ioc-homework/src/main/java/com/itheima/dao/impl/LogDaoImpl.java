package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.LogDao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LogDaoImpl implements LogDao {
    @Override
    public List<String> findAll() {
        //1. 加载log.txt文件数据
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("log.txt");
        ArrayList<String> lines = IoUtil.readUtf8Lines(inputStream, new ArrayList<String>());
        return lines;
    }
}
