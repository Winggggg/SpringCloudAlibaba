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
 * 用户和组关系表
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserGroupRelation extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 用户组id
     */
    @TableField("group_id")
    private String groupId;



}
