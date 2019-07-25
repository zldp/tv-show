package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.entity.TvDatasourceFormat;

import java.util.List;
import java.util.Map;

public interface TvDatasourceFormatMapper extends Mapper<TvDatasourceFormat> {
    /**
     * 根据条件获取跟新的数据
     * @param tvDatasourceFormat
     * @return
     */
    List<Map<String, Object>> getUpdate(TvDatasourceFormat tvDatasourceFormat);
    /**
     *
     * @param sql
     * @return
     */
    List<Map<String, Object>> getUpdateBySQL(String sql);

    /**
     * 获取定时时间
     * @param parameterName
     * @return
     */
    Map<String,String> getTimingTime(String parameterName);

    /**
     * 获取所有的病区
     */
    List<String> getAllWardId();
}