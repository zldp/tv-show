package com.zlsoft.service.impl;

import com.zlsoft.dao.TvDatasourceMapper;
import com.zlsoft.model.entity.TvDatasource;
import com.zlsoft.service.TvDatasourceService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by DP on 2019/07/23.
 */
@Service
@Transactional
public class TvDatasourceServiceImpl extends AbstractService<TvDatasource> implements TvDatasourceService {
    @Resource
    private TvDatasourceMapper tvDatasourceMapper;

}
