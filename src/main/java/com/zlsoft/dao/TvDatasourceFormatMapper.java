package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.entity.TvDatasourceFormat;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author dp
* @Version 1.0.0
* @date ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
*/
public interface TvDatasourceFormatMapper extends Mapper<TvDatasourceFormat> {
    /**
     * 根据条件获取跟新的数据
     * @param tvDatasourceFormat
     * @return
     */
    // TODO AND DATE_FORMAT(NOW(), '%Y-%m-%d')
    //    BETWEEN DATE_FORMAT(first_time, '%Y-%m-%d') AND DATE_FORMAT(last_time, '%Y-%m-%d')) a GROUP BY ward_id  加载最后
    List<Map<String, Object>> getUpdate(TvDatasourceFormat tvDatasourceFormat);
    /**
     * 传入sql 执行sql
     * @param sql
     * @return
     */
    List<Map<String, Object>> getUpdateBySQL(@Param(value="sql")String sql);

    /**
     * 获取定时时间
     * @param parameterName
     * @return
     */
    Map<String,String> getTimingTime(String parameterName);


    /**
     * 获取所有病区
     * @return
     */
    List<String> getAllWardId();
}