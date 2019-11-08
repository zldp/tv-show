package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.TvPagePanel;
import com.zlsoft.service.TvPagePanelService;
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
@RequestMapping("/tv/page/panel")
public class TvPagePanelController {
    @Resource
    private TvPagePanelService tvPagePanelService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String URL = "http://localhost:8089";

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

    @GetMapping("getBedNoAndGrade")
    public Result getBedNoAndGrade(
            Integer pageId,
            Integer panelId,
            String wardId
    ){
        Condition condition = new Condition(TvPagePanel.class);
        condition.createCriteria().andCondition("page_id=",pageId).andCondition("panel_id=",panelId);
        //condition.createCriteria().andCondition("panel_id=",panelId);
        List<TvPagePanel> byCondition = tvPagePanelService.findByCondition(condition);
        TvPagePanel tvPagePanel = byCondition.size() > 0 ? byCondition.get(0) : null;
        if (tvPagePanel == null) {
            return ResultGenerator.genFailResult("");
        }else {
            return restTemplate.getForObject(URL + "/ward/GM?sql=" + tvPagePanel.getDataSql().replace("[1]",wardId), Result.class);
        }

    }
}
