package com.wz.jiangsu.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: FlinkTest
 * @author: wangzhou
 * @create: 2023-11-24 15:35
 * @description:
 **/
@Data
public class Event {
    @JsonProperty("USER")
    private String user;

    private String url;

    public long timestamp;
}
