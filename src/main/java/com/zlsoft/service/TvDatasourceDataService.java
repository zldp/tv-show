package com.zlsoft.service;
import com.zlsoft.model.entity.TvDatasourceData;
import com.zlsoft.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/07/25.
 */
public interface TvDatasourceDataService extends Service<TvDatasourceData> {
    /**
     * 获取床号喝等级
     * @param wardId
     * @return
     */
    List<Map<String,Object>> selectByWardI(String wardId);
}
