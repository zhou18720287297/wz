package com.wz.jiangsu.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-04 10:31
 * @description:
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object created = getFieldValByName("createTime", metaObject);
        if (null == created) {
            //字段为空，可以进行填充
            setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }

        Object updated = getFieldValByName("updateTime", metaObject);
        if (null == updated) {
            //字段为空，可以进行填充
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新数据时，直接更新字段
        setFieldValByName("updatedTime", LocalDateTime.now(), metaObject);
    }
}
