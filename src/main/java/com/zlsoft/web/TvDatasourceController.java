package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.TvDatasource;
import com.zlsoft.service.TvDatasourceService;
import com.zlsoft.model.common.BaseDto;
import org.springframework.validation.annotation.Validated;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by DP on 2019/07/24.
*/
@RestController
@RequestMapping("/tv/datasource")
public class TvDatasourceController {
    @Resource
    private TvDatasourceService tvDatasourceService;

    @PostMapping
    public Result add(@RequestBody TvDatasource tvDatasource) {
        tvDatasourceService.save(tvDatasource);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tvDatasourceService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TvDatasource tvDatasource) {
        tvDatasourceService.update(tvDatasource);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TvDatasource tvDatasource = tvDatasourceService.findById(id);
        return ResultGenerator.genSuccessResult(tvDatasource);
    }

    @GetMapping
    public Result list(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<TvDatasource> list = tvDatasourceService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("timingUpdate")
    public void timingUpdate(){
        tvDatasourceService.timingUpdate();

    }
}
