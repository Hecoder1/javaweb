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
import java.util.Arrays;
import java.util.List;

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

    /**
     * 分页查询员工信息
     * @param empQueryParam
     * @return
     */
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

    /**
     * 批量删除员工
     */
    @DeleteMapping
//    public Result delete(Integer[] ids){
//        log.info("批量删除部门: ids={} ", Arrays.asList(ids));
//        return Result.success();
//    }
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除员工: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工的详细信息");
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);
    }


    /**
     * 更新员工信息
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }

}