package com.wing.organization.service.impl;

import com.wing.organization.entity.po.Menu;
import com.wing.organization.mapper.MenuMapper;
import com.wing.organization.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
