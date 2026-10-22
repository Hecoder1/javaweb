package com.learn.tlias.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.learn.tlias.mapper.EmpExprMapper;
import com.learn.tlias.mapper.EmpMapper;
import com.learn.tlias.pojo.Emp;
import com.learn.tlias.pojo.EmpExpr;
import com.learn.tlias.pojo.EmpQueryParam;
import com.learn.tlias.pojo.PageResult;
import com.learn.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Autowired
    private EmpExprMapper empExprMapper;

/*@Override
    public PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(page, pageSize);
        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        //3. 封装分页结果
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult(p.getTotal(), p.getResult());
    }*/

    public PageResult page(EmpQueryParam empQueryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        //2. 执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        //3. 封装分页结果
        Page<Emp> p = (Page<Emp>)empList;
        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Emp emp) {
        //补全创建时间和修改时间
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        //执行保存
        empMapper.insert(emp);

        //TODO 保存员工工作经历 -批量
        Integer empId=emp.getId();
        List<EmpExpr> exprList=emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            //批量保存员工工作经历
            exprList.forEach(expr->{
                expr.setEmpId(empId);
                empExprMapper.insertBatch(exprList);
            });
        }
    }


}