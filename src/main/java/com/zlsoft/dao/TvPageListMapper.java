package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.TvPageListDto;
import com.zlsoft.model.entity.TvPageList;

import java.util.List;

public interface TvPageListMapper extends Mapper<TvPageList> {
    /**
     * 根据wardId获取数据
     * @param wardId
     * @return
     */
    List<TvPageListDto> selectByWardId(String wardId);
}