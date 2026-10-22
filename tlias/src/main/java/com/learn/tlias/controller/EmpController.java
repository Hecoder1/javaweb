package com.learn.tlias.controller;

import com.learn.tlias.pojo.Emp;
import com.learn.tlias.pojo.EmpQueryParam;
import com.learn.tlias.pojo.PageResult;
import com.learn.tlias.pojo.Result;
import com.learn.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * 员工管理
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result Page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer PageSize,
//                       String name,Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
//        log.info("查询员工信息，当前页：{}，每页条数：{}，姓名：{}，性别：{}，开始时间：{}，结束时间：{}", page, PageSize,name,gender,begin,end);
//        PageResult pageResult = empService.page(page, PageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result Page(EmpQueryParam empQueryParam) {
        log.info("查询请求参数： {}", empQueryParam);
        PageResult pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("添加员工信息： {}", emp);
        empService.save(emp);
        return Result.success();
    }

}