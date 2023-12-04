package com.wz.jiangsu.service.serviceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.jiangsu.bean.entity.Student;
import com.wz.jiangsu.bean.vo.StudentVO;
import com.wz.jiangsu.mapper.TestMapper;
import com.wz.jiangsu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-01 15:07
 * @description:
 **/
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper,Student> implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;



    @Override
    public Boolean insertStudent(StudentVO vo) {

        if (vo.getId() == null) {
            return testMapper.insertStudentWithNoPrimarykey(vo.getName(),vo.getAge());
        }

        Student stu = testMapper.findOneByKey(vo.getId());

        if (stu == null) {
            return testMapper.insertStudent(vo.getId(),vo.getName(),vo.getAge());
        }

        return false;
    }

    @Override
    public StudentVO findOneByKey(String id) {
        String value = (String)redisTemplate.opsForValue().get(id);
        if (value != null) {
            return JSONUtil.toBean(value, StudentVO.class);
        }
        Student stu = testMapper.findOneByKey(Long.valueOf(id));
        StudentVO stuVO = BeanUtil.toBean(stu, StudentVO.class);
        if (stuVO == null) {
            return new StudentVO();
        }
        redisTemplate.opsForValue().set(id, JSONUtil.toJsonStr(stuVO));
        return stuVO;
    }

    @Override
    public Boolean deleteStuById(String id) {
        Student stu = testMapper.findOneByKey(Long.valueOf(id));
        if (stu == null) {
            return false;
        }
        return testMapper.deleteStuById(Long.valueOf(id));
    }

    @Override
    public boolean insertStudentByPlus(StudentVO vo) {
        Student student = BeanUtil.toBean(vo, Student.class);
        if (this.save(student)) {
            System.out.println("student.getId() = " + student.getId());
            return true;
        }
        return false;
    }
}
