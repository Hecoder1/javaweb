package com.learn.tlias.controller;

import com.learn.tlias.pojo.Dept;
import com.learn.tlias.pojo.Result;
import com.learn.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制器
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;

    /**查询部门列表
     *
     */
    @GetMapping
    public Result list() {
        log.debug("查询部门列表");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门
     */
    @DeleteMapping
    public Result delete(Integer id){
        log.debug("根据id删除部门"+id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.debug("添加部门"+dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id){
        log.debug("根据id查询部门"+id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.debug("更新部门"+dept);
        deptService.update(dept);
        return Result.success();
    }
}