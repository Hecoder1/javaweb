package com.learn.tlias.mapper;

import com.learn.tlias.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量保存员工工作经历
     */
     void insertBatch(List<EmpExpr> exprList);
}
