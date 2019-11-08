package com.zlsoft.service;
import com.zlsoft.model.entity.HandoverInfo;
import com.zlsoft.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/10/12.
 */
public interface HandoverInfoService extends Service<HandoverInfo> {
    /**
     * 获取交班信息 根据病区id
     * @param wardId
     * @return
     */
    List<Map<String, Object>> selectHandoverInfoByWardId(Integer wardId);
}
