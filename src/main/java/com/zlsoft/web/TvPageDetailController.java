package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.TvPageDetail;
import com.zlsoft.service.TvPageDetailService;
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
@RequestMapping("/tv/page/detail")
public class TvPageDetailController {
    @Resource
    private TvPageDetailService tvPageDetailService;

    @PostMapping
    public Result add(@RequestBody TvPageDetail tvPageDetail) {
        tvPageDetailService.save(tvPageDetail);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tvPageDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TvPageDetail tvPageDetail) {
        tvPageDetailService.update(tvPageDetail);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TvPageDetail tvPageDetail = tvPageDetailService.findById(id);
        return ResultGenerator.genSuccessResult(tvPageDetail);
    }

    @GetMapping
    public Result list(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<TvPageDetail> list = tvPageDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @GetMapping("getPageDeTail")
    public Result getPageDeTail(){

        return ResultGenerator.genSuccessResult(tvPageDetailService.getPageDeTail());
    }
}
