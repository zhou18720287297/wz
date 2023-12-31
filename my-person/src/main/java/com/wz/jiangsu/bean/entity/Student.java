package com.wz.jiangsu.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-01 14:42
 * @description:
 **/
@Getter
@Setter
@TableName("student")
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity{
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private Integer age;

}
