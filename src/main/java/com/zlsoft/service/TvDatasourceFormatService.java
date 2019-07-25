package com.zlsoft.service;
import com.zlsoft.model.entity.TvDatasourceFormat;
import com.zlsoft.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/07/25.
 */
public interface TvDatasourceFormatService extends Service<TvDatasourceFormat> {
    void timingUpdate();

    Map<String,String> getTimingTime(String parameterName);

    List<String> getAllWardId();
}
