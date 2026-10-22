package com.learn.tlias.service;

import com.learn.tlias.pojo.Emp;
import com.learn.tlias.pojo.EmpQueryParam;
import com.learn.tlias.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {

    PageResult page(EmpQueryParam empQueryParam);

    void save(Emp emp);
}