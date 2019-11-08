package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.entity.HandoverInfo;

import java.util.List;
import java.util.Map;

public interface HandoverInfoMapper extends Mapper<HandoverInfo> {
    /**
     * 获取交班信息 根据病区id
     * @param wardId
     * @return
     */
    List<Map<String, Object>> selectHandoverInfoByWardId(Integer wardId);
}