package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.SystemParameter;
import com.zlsoft.service.SystemParameterService;
import com.zlsoft.model.common.BaseDto;
import org.springframework.validation.annotation.Validated;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by DP on 2019/09/27.
*/
@RestController
@RequestMapping("/system/parameter")
public class SystemParameterController {
    @Resource
    private SystemParameterService systemParameterService;

    @PostMapping
    public Result add(@RequestBody SystemParameter systemParameter) {
        systemParameterService.save(systemParameter);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        systemParameterService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SystemParameter systemParameter) {
        systemParameterService.update(systemParameter);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SystemParameter systemParameter = systemParameterService.findById(id);
        return ResultGenerator.genSuccessResult(systemParameter);
    }

    @GetMapping
    public Result list(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<SystemParameter> list = systemParameterService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/byName/{name}")
    public Result byName(
            @PathVariable String name
    ){
        SystemParameter systemParameter = systemParameterService.findBy("parameterName", name);
        return ResultGenerator.genSuccessResult(systemParameter.getParameterValue());
    }
}
