package com.wz.jiangsu.bean.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-04 10:49
 * @description:
 **/
@Data
public abstract class BaseEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Long id; //主键id

    @TableField(fill = FieldFill.INSERT,value = "create_time") //MP自动填充
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE,value = "update_time")
    private LocalDateTime updateTime;
}
