package com.wing.organization.service.impl;

import com.wing.organization.entity.po.Groups;
import com.wing.organization.mapper.GroupsMapper;
import com.wing.organization.service.IGroupsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组表 服务实现类
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Service
public class GroupsServiceImpl extends ServiceImpl<GroupsMapper, Groups> implements IGroupsService {

}
