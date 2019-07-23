package com.zlsoft.service.impl;

import com.zlsoft.dao.TvPageListMapper;
import com.zlsoft.model.entity.TvPageList;
import com.zlsoft.service.TvPageListService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by DP on 2019/07/23.
 */
@Service
@Transactional
public class TvPageListServiceImpl extends AbstractService<TvPageList> implements TvPageListService {
    @Resource
    private TvPageListMapper tvPageListMapper;

}
