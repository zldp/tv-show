package com.zlsoft.service.impl;

import com.zlsoft.core.Result;
import com.zlsoft.dao.TvDatasourceDataMapper;
import com.zlsoft.dao.TvDatasourceFormatMapper;
import com.zlsoft.model.entity.TvDatasourceData;
import com.zlsoft.model.entity.TvDatasourceFormat;
import com.zlsoft.service.TvDatasourceFormatService;
import com.zlsoft.core.AbstractService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.net.URI;
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

    @Autowired
    private RestTemplate restTemplate;
    @Value("${api.url}")
    private String URL;

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
            /*if (tvDatasource.getType() == 2) {
                List<Map<String, Object>> updateBySQL = tvDatasourceFormatMapper.getUpdateBySQL(tvDatasource.getQuerySql());
                if (updateBySQL.size() > 0) {
                    insertAll.addAll(updateBySQL);
                }
                //tvDatasourceMapper.updateByPrimaryKeySelective(datasource);
            }*/

            // 根据SQL到his获取shuju
            if (3 == tvDatasource.getType()) {
                Result result = restTemplate.getForObject(URL + "/tv/bySql?sql=" + tvDatasource.getQuerySql() + "&format_id=" + tvDatasource.getId() + "&data_name=" + tvDatasource.getDataName() + "&abbreviation=" + tvDatasource.getAbbreviation(), Result.class);
                if (null != result) {
                    List<Map<String,Object>> data = (List<Map<String,Object>>) result.getData();
                    if (data.size() > 0) {
                        insertAll.addAll(data);
                    }
                }
            }

        }
        // 删除所有表格的数据
        if (insertAll.size() > 0) {
            Condition condition = new Condition(TvDatasourceData.class);
            condition.createCriteria().andCondition("1=1");
            tvDatasourceDataMapper.deleteByCondition(condition);
            // 开始增加
            tvDatasourceDataMapper.insertByMap(insertAll);
        }


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
