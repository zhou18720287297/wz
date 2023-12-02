package com.wz.jiangsu.controller;

import cn.hutool.core.util.StrUtil;
import com.wz.jiangsu.bean.Event;
import com.wz.jiangsu.bean.entity.Student;
import com.wz.jiangsu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: FlinkTest
 * @author: wangzhou
 * @create: 2023-11-24 15:25
 * @description:
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String getStr(){
        return "my name is wangzhou";
    }

    @PostMapping("/test/my")
    public String getString(@RequestBody Event dto){
        System.out.println("王洲");
        String str = StrUtil.toString(dto);
        return str;
    }

    @PostMapping("/db/test/insert")
    public Boolean insertStudent(@RequestBody Student student){
        return testService.insertStudent(student);
    }

    @GetMapping("/db/findStuById/{id}")
    public Student findOneByKey(@PathVariable String id ){
        return testService.findOneByKey(id);
    }

    @GetMapping("/db/deleteStuById/{id}")
    public Boolean deleteStuById( @PathVariable("id") String id ){
        return testService.deleteStuById(id);
    }

}
