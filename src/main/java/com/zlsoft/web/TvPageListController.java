package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.TvPageListDto;
import com.zlsoft.model.entity.TvPageList;
import com.zlsoft.service.TvPageListService;
import com.zlsoft.model.common.BaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by DP on 2019/07/24.
*/
@RestController
@RequestMapping("/tv/page/list")
public class TvPageListController {
    @Resource
    private TvPageListService tvPageListService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String URL;

    @PostMapping
    public Result add(@RequestBody TvPageList tvPageList) {
        tvPageListService.save(tvPageList);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tvPageListService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TvPageList tvPageList) {
        tvPageListService.update(tvPageList);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TvPageList tvPageList = tvPageListService.findById(id);
        return ResultGenerator.genSuccessResult(tvPageList);
    }

    @GetMapping
    public Result list(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<TvPageList> list = tvPageListService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("getByWardId")
    public Result getByWardId(String wardId){

        List<TvPageList> byCondition = tvPageListService.selectByWardId(wardId);
        //List<TvPageList> all = tvPageListService.findAll();
        return ResultGenerator.genSuccessResult(byCondition);
    }
    @GetMapping("get")
    public Result get(String wardId){
        return restTemplate.getForObject(URL + "/patient?wardId="+wardId, Result.class);
    }
}
