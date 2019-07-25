package com.zlsoft.service.impl;

import com.zlsoft.dao.TvPageDetailMapper;
import com.zlsoft.model.entity.TvPageDetail;
import com.zlsoft.service.TvPageDetailService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/07/24.
 */
@Service
@Transactional
public class TvPageDetailServiceImpl extends AbstractService<TvPageDetail> implements TvPageDetailService {
    @Resource
    private TvPageDetailMapper tvPageDetailMapper;

    @Override
    public List<Map<String, Object>> getPageDeTail() {
        return tvPageDetailMapper.getPageDeTail();
    }
}
