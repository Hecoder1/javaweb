package com.learn.tlias.service;

import com.learn.tlias.pojo.Emp;
import com.learn.tlias.pojo.EmpQueryParam;
import com.learn.tlias.pojo.LoginInfo;
import com.learn.tlias.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageResult page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);
}