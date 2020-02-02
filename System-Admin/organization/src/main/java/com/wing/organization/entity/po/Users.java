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
 * 用户表
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Users extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 用户密码密文
     */
    @TableField("password")
    private String password;

    /**
     * 用户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 用户手机
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 简介
     */
    @TableField("description")
    private String description;

    /**
     * 是否有效用户
     */
    @TableField("enabled")
    private Boolean enabled;

    /**
     * 账号是否未过期
     */
    @TableField("account_non_expired")
    private Boolean accountNonExpired;

    /**
     * 密码是否未过期
     */
    @TableField("credentials_non_expired")
    private Boolean credentialsNonExpired;

    /**
     * 是否未锁定
     */
    @TableField("account_non_locked")
    private Boolean accountNonLocked;



}
