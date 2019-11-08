package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.TvDatasourceData;
import com.zlsoft.service.TvDatasourceDataService;
import com.zlsoft.model.common.BaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by DP on 2019/07/25.
*/
@RestController
@RequestMapping("/tv/datasource/data")
public class TvDatasourceDataController {
    @Resource
    private TvDatasourceDataService tvDatasourceDataService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String URL;
    @PostMapping
    public Result add(@RequestBody TvDatasourceData tvDatasourceData) {
        tvDatasourceDataService.save(tvDatasourceData);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tvDatasourceDataService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TvDatasourceData tvDatasourceData) {
        tvDatasourceDataService.update(tvDatasourceData);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TvDatasourceData tvDatasourceData = tvDatasourceDataService.findById(id);
        return ResultGenerator.genSuccessResult(tvDatasourceData);
    }

    @GetMapping
    public Result list(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<TvDatasourceData> list = tvDatasourceDataService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("getBedNoAndGroup")
    public Result getBedNoAndGroup(String wardId){

        return ResultGenerator.genSuccessResult(tvDatasourceDataService.selectByWardI(wardId));
    }

    /**
     * 查询手术信息
     */
    @GetMapping("/operation/{wardId}")
    public Result operation(
            @PathVariable Integer wardId
    ){

        return restTemplate.getForObject(URL+"/operation?wardId="+wardId, Result.class);
    }
}
