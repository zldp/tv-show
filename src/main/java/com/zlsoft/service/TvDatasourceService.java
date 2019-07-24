package com.zlsoft.service;
import com.zlsoft.model.entity.TvDatasource;
import com.zlsoft.core.Service;


/**
 * Created by DP on 2019/07/24.
 */
public interface TvDatasourceService extends Service<TvDatasource> {
    void timingUpdate();
}
