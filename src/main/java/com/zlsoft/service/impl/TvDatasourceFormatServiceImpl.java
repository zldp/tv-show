package com.zlsoft.service.impl;

import com.zlsoft.dao.TvDatasourceDataMapper;
import com.zlsoft.dao.TvDatasourceFormatMapper;
import com.zlsoft.model.entity.TvDatasourceData;
import com.zlsoft.model.entity.TvDatasourceFormat;
import com.zlsoft.service.TvDatasourceFormatService;
import com.zlsoft.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/07/25.
 */
@Service
@Transactional
public class TvDatasourceFormatServiceImpl extends AbstractService<TvDatasourceFormat> implements TvDatasourceFormatService {
    @Resource
    private TvDatasourceFormatMapper tvDatasourceFormatMapper;

    @Autowired
    private TvDatasourceDataMapper tvDatasourceDataMapper;

    @Override
    public void timingUpdate() {
        List<TvDatasourceFormat> tvDatasourceFormats = tvDatasourceFormatMapper.selectAll();
        List<Map<String, Object>> insertAll = new ArrayList<>();

        // 得到增加的数据
        for (TvDatasourceFormat tvDatasource : tvDatasourceFormats) {
            // 根据条件获取跟新数据
            if (tvDatasource.getType() == 1) {
                List<Map<String, Object>> update = tvDatasourceFormatMapper.getUpdate(tvDatasource);
                if (update.size() > 0) {
                    insertAll.addAll(update);
                }

            }
            // 根据SQL获取跟新数据
            if (tvDatasource.getType() == 2) {
                List<Map<String, Object>> updateBySQL = tvDatasourceFormatMapper.getUpdateBySQL(tvDatasource.getQuerySql());
                if (updateBySQL.size() > 0) {
                    insertAll.addAll(updateBySQL);
                }
                //tvDatasourceMapper.updateByPrimaryKeySelective(datasource);
            }

        }
        // 删除所有表格的数据
        Condition condition = new Condition(TvDatasourceData.class);
        condition.createCriteria().andCondition("1=1");
        tvDatasourceDataMapper.deleteByCondition(condition);
        // 开始增加
        tvDatasourceDataMapper.insertByMap(insertAll);

    }

    @Override
    public Map<String, String> getTimingTime(String parameterName) {
        return tvDatasourceFormatMapper.getTimingTime(parameterName);
    }

    @Override
    public List<String> getAllWardId() {
        return tvDatasourceFormatMapper.getAllWardId();
    }
}
