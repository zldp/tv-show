package com.zlsoft.service;
import com.zlsoft.core.Service;
import com.zlsoft.model.entity.TvPageDetail;

import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/07/24.
 */
public interface TvPageDetailService extends Service<TvPageDetail> {
    /**
     * 获取大屏显示的数据
     * @return
     */
    List<Map<String,Object>> getPageDeTail();
}
