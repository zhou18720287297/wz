package com.wz.jiangsu.mapper;

import com.wz.jiangsu.bean.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-01 15:09
 * @description:
 **/

@Mapper
public interface TestMapper {


    Student findOneByKey(Integer id);

    @Insert("insert into student(id,name,age) values (#{id},#{name},#{age})")
    Boolean insertStudent(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age);

    Boolean deleteStuById(@Param("id") Integer id);
}
