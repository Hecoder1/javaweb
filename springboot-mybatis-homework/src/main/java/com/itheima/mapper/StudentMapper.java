package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

//    /*
//    查询所有学生信息
//     */
//    @Select("select * from student")
//    public List<Student> findAll();
//
//    /*
//    插入一条学生信息
//     */
//    @Insert("insert into student(name,`no`,gender,phone,id_card,degree,graduation_date,create_time,update_time) values(#{name},#{no},#{gender},#{phone},#{idCard},#{degree},#{graduationDate},#{createTime},#{updateTime})")
//    public void insert(Student student);

    /*
    更新一条学生信息
     */
    //@Update("update student set `no`=#{no},phone=#{phone},id_card=#{idCard} where `id`=#{id}")
    public void update(Student student);


//    /*
//    查询一条学生信息
//     */
//    @Select("select * from student where `id`=#{id}")
//    public Student findById(Integer id);

    /*
    删除一条学生信息
     */
    //@Delete("delete from student where `id`=#{id}")
    public void delete(Integer id);
}