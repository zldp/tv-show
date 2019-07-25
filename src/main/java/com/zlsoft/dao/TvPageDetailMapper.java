package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.entity.TvPageDetail;

import java.util.List;
import java.util.Map;

public interface TvPageDetailMapper extends Mapper<TvPageDetail> {
    /**
     * 获取大屏显示的数据
     * @return
     */
    List<Map<String,Object>> getPageDeTail(Map<String,Object> parpams);
}