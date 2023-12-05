package com.wz.jiangsu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wz.jiangsu.bean.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-01 15:09
 * @description:
 **/


public interface TestMapper extends BaseMapper<Student> {


    Student findOneByKey(@Param("id") Long id);

    @Insert("insert into student(id,name,age) values (#{id},#{name},#{age})")
    Boolean insertStudent(@Param("id") Long id, @Param("name") String name, @Param("age") Integer age);

    Boolean deleteStuById(@Param("id")  Long id);

    Boolean insertStudentWithNoPrimarykey(@Param("name") String name, @Param("age") Integer age);

    List<Student> listByKeyIds(@Param("list") List<Long> idList);
}
