package com.wz.jiangsu.service.serviceImpl;

import com.wz.jiangsu.bean.entity.Student;
import com.wz.jiangsu.mapper.TestMapper;
import com.wz.jiangsu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-01 15:07
 * @description:
 **/
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public Boolean insertStudent(Student student) {

        Student stu = testMapper.findOneByKey(student.getId());

        if (stu == null) {
            return testMapper.insertStudent(student.getId(),student.getName(),student.getAge());
        }

        return false;
    }
}
