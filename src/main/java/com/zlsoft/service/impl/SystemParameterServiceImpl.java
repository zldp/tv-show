package com.zlsoft.service.impl;

import com.zlsoft.dao.SystemParameterMapper;
import com.zlsoft.model.entity.SystemParameter;
import com.zlsoft.service.SystemParameterService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by DP on 2019/09/27.
 */
@Service
@Transactional
public class SystemParameterServiceImpl extends AbstractService<SystemParameter> implements SystemParameterService {
    @Resource
    private SystemParameterMapper systemParameterMapper;

}
