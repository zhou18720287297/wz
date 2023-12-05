package com.wz.jiangsu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wz.jiangsu.bean.entity.Student;
import com.wz.jiangsu.bean.vo.StudentVO;
import com.wz.jiangsu.bean.vo.resp.R;

import java.util.List;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-01 15:06
 * @description:
 **/
public interface TestService extends IService<Student> {
    Boolean insertStudent(StudentVO vo);

    StudentVO findOneByKey(String id);

    Boolean deleteStuById(String id);

    R<Boolean> insertStudentByPlus(StudentVO vo);

    List<StudentVO> listByKeyIds(List<String> list);
}
