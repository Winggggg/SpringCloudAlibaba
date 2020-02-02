package com.wing.organization.service.impl;

import com.wing.organization.entity.po.Resource;
import com.wing.organization.mapper.ResourceMapper;
import com.wing.organization.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author heweiye
 * @since 2020-01-17
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
