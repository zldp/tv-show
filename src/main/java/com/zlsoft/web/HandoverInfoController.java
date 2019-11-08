package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.HandoverInfo;
import com.zlsoft.service.HandoverInfoService;
import com.zlsoft.model.common.BaseDto;
import org.springframework.validation.annotation.Validated;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by DP on 2019/10/12.
*/
@RestController
@RequestMapping("/handover/info")
public class HandoverInfoController {
    @Resource
    private HandoverInfoService handoverInfoService;

    @PostMapping
    public Result add(@RequestBody HandoverInfo handoverInfo) {
        handoverInfoService.save(handoverInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        handoverInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody HandoverInfo handoverInfo) {
        handoverInfoService.update(handoverInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        HandoverInfo handoverInfo = handoverInfoService.findById(id);
        return ResultGenerator.genSuccessResult(handoverInfo);
    }

    @GetMapping
    public Result list(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<HandoverInfo> list = handoverInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据wardId 获取交班
     * @param wardId
     * @return
     */
    @GetMapping("/getHandoverInfoByWardId/{wardId}")
    public Result getHandoverInfoByWardId(
            @PathVariable Integer wardId
    ){
        return ResultGenerator.genSuccessResult(handoverInfoService.selectHandoverInfoByWardId(wardId));
    }

}
