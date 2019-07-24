package com.zlsoft.service;

import com.zlsoft.Tester;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TvDatasourceServiceTest extends Tester {

    @Autowired
    private TvDatasourceService tvDatasourceService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void timingUpdate(){
        tvDatasourceService.timingUpdate();

    }
}