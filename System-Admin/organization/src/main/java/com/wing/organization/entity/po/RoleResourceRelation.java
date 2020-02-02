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
 * 角色和资源关系表
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RoleResourceRelation extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 关系id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 角色id
     */
    @TableField("resource_id")
    private String resourceId;

    /**
     * 资源id
     */
    @TableField("role_id")
    private String roleId;



}
