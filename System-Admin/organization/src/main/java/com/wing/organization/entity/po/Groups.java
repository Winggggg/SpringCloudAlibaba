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
 * 用户组表
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Groups extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 用户组父id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 用户组名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("description")
    private String description;



}
