package com.zlsoft.service.impl;

import com.zlsoft.dao.TvPagePanelMapper;
import com.zlsoft.model.entity.TvPagePanel;
import com.zlsoft.service.TvPagePanelService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by DP on 2019/07/23.
 */
@Service
@Transactional
public class TvPagePanelServiceImpl extends AbstractService<TvPagePanel> implements TvPagePanelService {
    @Resource
    private TvPagePanelMapper tvPagePanelMapper;

}
