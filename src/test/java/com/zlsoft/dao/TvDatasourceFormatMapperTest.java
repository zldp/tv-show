package com.zlsoft.dao;

import com.zlsoft.Tester;
import com.zlsoft.model.entity.TvDatasourceFormat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TvDatasourceFormatMapperTest extends Tester {
    @Autowired
    private TvDatasourceFormatMapper tvDatasourceFormatMapper;

    @Test
    public void test(){
        TvDatasourceFormat tvDatasourceFormat = new TvDatasourceFormat();
        tvDatasourceFormat.setItemId("2530,493");
        //tvDatasourceFormat.setWardId("58");
        tvDatasourceFormat.setListField("bed_no");

        List<Map<String, Object>> update = tvDatasourceFormatMapper.getUpdate(tvDatasourceFormat);
        System.out.println(update.size());
        for (Map<String, Object> map : update) {
            System.out.println(map);
        }
    }

}