package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.entity.TvDatasource;

import java.util.List;
import java.util.Map;

public interface TvDatasourceMapper extends Mapper<TvDatasource> {
    /**
     * 根据条件获取跟新的数据
     * @param tvDatasource
     * @return
     */
   Map<String,Object> getUpdate(TvDatasource tvDatasource);

    /**
     *
     * @param sql
     * @return
     */
   Map<String,Object> getUpdateBySQL(String sql);


}