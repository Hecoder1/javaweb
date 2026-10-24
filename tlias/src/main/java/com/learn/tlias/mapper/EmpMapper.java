package com.learn.tlias.mapper;


import com.learn.tlias.pojo.Emp;
import com.learn.tlias.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

//    List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    List<Emp> list(EmpQueryParam empQueryParam);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values(#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);


    Emp getById(Integer id);


    void updateById(Emp emp);

    /**
     * 统计员工性别信息
     */
    @MapKey("name")
    List<Map> countEmpGenderData();
}