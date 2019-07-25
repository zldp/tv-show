package com.zlsoft.service.impl;

import com.zlsoft.dao.TvPageListMapper;
import com.zlsoft.model.TvPageListDto;
import com.zlsoft.model.entity.TvPageList;
import com.zlsoft.service.TvPageListService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by DP on 2019/07/24.
 */
@Service
@Transactional
public class TvPageListServiceImpl extends AbstractService<TvPageList> implements TvPageListService {
    @Resource
    private TvPageListMapper tvPageListMapper;
    /**
     * 根据wardId获取菜单栏的数据
     * @param wardId
     * @return
     */
    @Override
    public List<TvPageListDto> selectByWardId(String wardId) {
        return tvPageListMapper.selectByWardId(wardId);
    }
}
