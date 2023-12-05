package com.wz.jiangsu.controller;

import cn.hutool.core.util.StrUtil;
import com.wz.jiangsu.bean.Event;
import com.wz.jiangsu.bean.vo.StudentVO;
import com.wz.jiangsu.bean.vo.resp.R;
import com.wz.jiangsu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: FlinkTest
 * @author: wangzhou
 * @create: 2023-11-24 15:25
 * @description:
 **/
@RestController
public class TestStudentController {

    @Autowired
    private TestService testService;


    @GetMapping("/test")
    public String getStr(@RequestParam("message") String message) {
        return message;
    }

    @PostMapping("/test/my")
    public String getString(@RequestBody Event dto) {
        System.out.println("王洲");
        String str = StrUtil.toString(dto);
        return str + "王洲";
    }

    @PostMapping("/db/test/insert")
    public Boolean insertStudent(@RequestBody StudentVO vo) {
        return testService.insertStudent(vo);
    }

    @GetMapping("/db/findStuById/{id}")
    public StudentVO findOneByKey(@PathVariable String id) {

        return testService.findOneByKey(id);
    }

    @GetMapping("/db/deleteStuById/{id}")
    public Boolean deleteStuById(@PathVariable("id") String id) {
        return testService.deleteStuById(id);
    }


    @PostMapping("/db/test/plus/insert")
    public R<Boolean> insertStuByPlus(@RequestBody StudentVO vo) {
        return testService.insertStudentByPlus(vo);
    }

    /**
     * 通过学生 ids 进行查询
     * @param list
     * @return
     */
    @PostMapping("/db/test/plus/listByIds")
    public R<List<StudentVO>> listByKeyIds(@RequestBody List<String> list) {
        List<StudentVO> studentVOList = testService.listByKeyIds(list);
        return R.success(studentVOList);
    }

}
