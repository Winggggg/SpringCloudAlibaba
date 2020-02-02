package com.wing.organization.service.impl;

import com.wing.organization.entity.po.UserRoleRelation;
import com.wing.organization.mapper.UserRoleRelationMapper;
import com.wing.organization.service.IUserRoleRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关系表 服务实现类
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Service
public class UserRoleRelationServiceImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelation> implements IUserRoleRelationService {

}
