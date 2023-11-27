package com.wz.jiangsu.controller;

import cn.hutool.core.util.StrUtil;
import com.wz.jiangsu.bean.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: FlinkTest
 * @author: wangzhou
 * @create: 2023-11-24 15:25
 * @description:
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String getStr(){
        return "my name is wangzhou";
    }

    @PostMapping("/test/my")
    public String getString(@RequestBody Event dto){
        String str = StrUtil.toString(dto);
        return str;
    }
}
