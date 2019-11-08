package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.entity.TvDatasourceData;

import java.util.List;
import java.util.Map;

public interface TvDatasourceDataMapper extends Mapper<TvDatasourceData> {
    /**
     * 根据list集合增加数据
     * @param list
     */
    void insertByMap(List<Map<String, Object>> list);

    List<Map<String,Object>> selectByWardI(String wardId);
}