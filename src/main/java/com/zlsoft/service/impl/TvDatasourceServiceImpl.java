package com.zlsoft.service.impl;

import com.zlsoft.dao.TvDatasourceMapper;
import com.zlsoft.model.entity.TvDatasource;
import com.zlsoft.service.TvDatasourceService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by DP on 2019/07/24.
 */
@Service
@Transactional
public class TvDatasourceServiceImpl extends AbstractService<TvDatasource> implements TvDatasourceService {
    @Resource
    private TvDatasourceMapper tvDatasourceMapper;

    @Override
    public void timingUpdate() {
        List<TvDatasource> tvDatasources = tvDatasourceMapper.selectAll();
        for (TvDatasource tvDatasource : tvDatasources) {
            // 根据条件获取跟新数据
            if (tvDatasource.getType() == 1) {
                Map<String,Object> update = tvDatasourceMapper.getUpdate(tvDatasource);
                System.out.println(update);
                // 进行跟新
                TvDatasource datasource = new TvDatasource();
                datasource.setId(tvDatasource.getId());
                datasource.setCountValue(Integer.valueOf(update.get("count_value").toString()));
                datasource.setListValue(update.get("list_value").toString());
                tvDatasourceMapper.updateByPrimaryKeySelective(datasource);
            }
            // 根据SQL获取跟新数据
            if (tvDatasource.getType() == 2) {
                Map<String,Object> updateBySQL = tvDatasourceMapper.getUpdateBySQL(tvDatasource.getQuerySql());
                System.out.println(updateBySQL);
                // 进行跟新
                TvDatasource datasource = new TvDatasource();
                datasource.setId(tvDatasource.getId());
                datasource.setCountValue(Integer.valueOf(updateBySQL.get("count_value").toString()));
                datasource.setListValue(updateBySQL.get("list_value").toString());
                tvDatasourceMapper.updateByPrimaryKeySelective(datasource);
            }

        }
    }
}
