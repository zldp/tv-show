package com.zlsoft.service.impl;

import com.zlsoft.dao.HandoverInfoMapper;
import com.zlsoft.model.entity.HandoverInfo;
import com.zlsoft.service.HandoverInfoService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/10/12.
 */
@Service
@Transactional
public class HandoverInfoServiceImpl extends AbstractService<HandoverInfo> implements HandoverInfoService {
    @Resource
    private HandoverInfoMapper handoverInfoMapper;

    @Override
    public List<Map<String, Object>> selectHandoverInfoByWardId(Integer wardId) {
        return handoverInfoMapper.selectHandoverInfoByWardId(wardId);
    }

}
