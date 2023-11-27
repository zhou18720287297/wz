package com.wz.jiangsu.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: bertram
 * @Date: 2023/11/22 14:10
 * @Description: 自定义上报数据 DTO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityEventDataCommonDto implements Serializable {

    /**
     * 数据类型
     */
    @JsonProperty("data_type")
    private String data_type;

    /**
     * Agent IP，用于唯一标识Agent
     */
    @JsonProperty("agent_ip")
    private String agent_ip;

    /**
     * 数据发送的时间戳
     */
    private Long ts;

    /**
     * 本次数据包的唯一ID标识
     */
    private String uuid;

    /**
     * “1-1”
     */
    private String seq;

    /**
     * 具体数据内容，根据不同的日志有不同的数据结构
     */
    private Object payload;

    /**
     * 事件分类
     */
    private String eventType;

    /**
     * 事件分级
     */
    private int eventLevel;

}
