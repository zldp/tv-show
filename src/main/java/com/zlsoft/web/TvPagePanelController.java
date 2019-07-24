package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.TvPagePanel;
import com.zlsoft.service.TvPagePanelService;
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
@RequestMapping("/tv/page/panel")
public class TvPagePanelController {
    @Resource
    private TvPagePanelService tvPagePanelService;

    @PostMapping
    public Result add(@RequestBody TvPagePanel tvPagePanel) {
        tvPagePanelService.save(tvPagePanel);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tvPagePanelService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TvPagePanel tvPagePanel) {
        tvPagePanelService.update(tvPagePanel);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TvPagePanel tvPagePanel = tvPagePanelService.findById(id);
        return ResultGenerator.genSuccessResult(tvPagePanel);
    }

    @GetMapping
    public Result list(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<TvPagePanel> list = tvPagePanelService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
