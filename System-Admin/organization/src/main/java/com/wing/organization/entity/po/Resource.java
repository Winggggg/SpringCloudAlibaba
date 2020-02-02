package com.wing.organization.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Resource extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 资源id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 资源code
     */
    @TableField("code")
    private String code;

    /**
     * 资源类型
     */
    @TableField("type")
    private String type;

    /**
     * 资源名称
     */
    @TableField("name")
    private String name;

    /**
     * 资源url
     */
    @TableField("url")
    private String url;

    /**
     * 资源方法
     */
    @TableField("method")
    private String method;

    /**
     * 简介
     */
    @TableField("description")
    private String description;



}
