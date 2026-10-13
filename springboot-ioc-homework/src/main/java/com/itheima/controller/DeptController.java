package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

//    @Resource(name = "deptServiceImpl")

    /*
    @Autowird 与 @Resource的区别
   @Autowired 是spring框架提供的注解，而@Resource是JDK提供的注解
   @Autowired 默认是按照类型注入，而@Resource是按照名称注入
     */

    @Autowired
    @Qualifier("deptServiceImpl")
    private DeptService deptService;

    @RequestMapping("/depts")
    public Result list() {
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
}