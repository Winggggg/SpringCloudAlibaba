package com.wing.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author heweiye
 * @version 1.0
 * @description 基础数据库实体类
 * @date 2020/1/17 16:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BasePo extends Model {

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;

    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;

    /**
     * 更新人
     */
    @TableField("updated_by")
    private String updatedBy;

    /**
     * 逻辑删除 0:未删除 1:删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;
}
