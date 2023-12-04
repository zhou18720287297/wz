package com.wz.jiangsu.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-04 10:59
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO extends BaseEntityVO{


    private String name;

    private Integer age;

}
