package com.wing.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author heweiye
 * @version 1.0
 * @description 自动填充保存数据库设置创建、更新时间、删除状态
 * https://mp.baomidou.com/guide/auto-fill-metainfo.html
 * @date 2019/9/11 14:00
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    /**
     * 在插入的时候填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 判断数据库中是否有这个列
        boolean hasSetter = metaObject.hasSetter("createTime");
        // 如果有就向这个列插入数据
        // 如果没有就不插
        Date now = new Date();
        if (hasSetter) {
            setInsertFieldValByName("createTime", now, metaObject);
        }

        hasSetter = metaObject.hasSetter("isDeleted");
        if (hasSetter) {
            setInsertFieldValByName("isDeleted", 0, metaObject);
        }

        hasSetter = metaObject.hasSetter("updateTime");
        if (hasSetter) {
            setInsertFieldValByName("updateTime", now, metaObject);
        }
    }

    /**
     * 在更新的时候填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        boolean hasSetter = metaObject.hasSetter("updateTime");
        if (hasSetter) {
            setUpdateFieldValByName("updateTime", new Date(), metaObject);
        }
    }
}
