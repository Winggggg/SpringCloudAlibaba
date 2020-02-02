package com.wing.organization.service.impl;

import com.wing.organization.entity.po.Users;
import com.wing.organization.mapper.UsersMapper;
import com.wing.organization.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
