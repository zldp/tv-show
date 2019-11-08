package com.zlsoft.service.impl;

import com.zlsoft.dao.TvDatasourceDataMapper;
import com.zlsoft.model.entity.TvDatasourceData;
import com.zlsoft.service.TvDatasourceDataService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/07/25.
 */
@Service
@Transactional
public class TvDatasourceDataServiceImpl extends AbstractService<TvDatasourceData> implements TvDatasourceDataService {
    @Resource
    private TvDatasourceDataMapper tvDatasourceDataMapper;


    @Override
    public List<Map<String,Object>> selectByWardI(String wardId) {
        return tvDatasourceDataMapper.selectByWardI(wardId);
    }
}
