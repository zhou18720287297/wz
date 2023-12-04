package com.wz.jiangsu.bean.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
public abstract class BaseEntityVO implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id; //主键id

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updateTime;
}
