package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.TvDatasourceFormat;
import com.zlsoft.service.TvDatasourceFormatService;
import com.zlsoft.model.common.BaseDto;
import org.springframework.validation.annotation.Validated;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by DP on 2019/07/25.
*/
@RestController
@RequestMapping("/tv/datasource/format")
public class TvDatasourceFormatController {
    @Resource
    private TvDatasourceFormatService tvDatasourceFormatService;

    @PostMapping
    public Result add(@RequestBody TvDatasourceFormat tvDatasourceFormat) {
        tvDatasourceFormatService.save(tvDatasourceFormat);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tvDatasourceFormatService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TvDatasourceFormat tvDatasourceFormat) {
        tvDatasourceFormatService.update(tvDatasourceFormat);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TvDatasourceFormat tvDatasourceFormat = tvDatasourceFormatService.findById(id);
        return ResultGenerator.genSuccessResult(tvDatasourceFormat);
    }

    @GetMapping
    public Result list(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<TvDatasourceFormat> list = tvDatasourceFormatService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("timingUpdate")
    public Result timingUpdate(){
        tvDatasourceFormatService.timingUpdate();
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("getAllWardId")
    public Result getAllWardId(){

        return ResultGenerator.genSuccessResult(tvDatasourceFormatService.getAllWardId());
    }
}
