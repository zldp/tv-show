package com.zlsoft.dao;

import com.zlsoft.Tester;
import com.zlsoft.model.TvPageListDto;
import com.zlsoft.model.entity.TvPageList;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class TvPageListMapperTest extends Tester {
    @Autowired
    private TvPageListMapper tvPageListMapper;
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void test(){
        List<TvPageList> tvPageListDtos = tvPageListMapper.selectByWardId("1");

    }
}