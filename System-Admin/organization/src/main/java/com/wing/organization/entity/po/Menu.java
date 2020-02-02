package com.wing.organization.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.wing.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Menu extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 父菜单id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 菜单类型
     */
    @TableField("type")
    private String type;

    /**
     * 菜单路径
     */
    @TableField("href")
    private String href;

    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 菜单名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 创建时间
     */
    @TableField("order_num")
    private Integer orderNum;


}
