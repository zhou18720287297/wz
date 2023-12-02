package com.wz.jiangsu.service;

import com.wz.jiangsu.bean.entity.Student;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-01 15:06
 * @description:
 **/
public interface TestService {
    Boolean insertStudent(Student student);

    Student findOneByKey(String id);

    Boolean deleteStuById(String id);
}
