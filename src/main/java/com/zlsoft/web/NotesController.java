package com.zlsoft.web;

import com.zlsoft.core.Result;
import com.zlsoft.core.ResultGenerator;
import com.zlsoft.model.entity.Notes;
import com.zlsoft.service.NotesService;
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
@RequestMapping("/notes")
public class NotesController {
    @Resource
    private NotesService notesService;

    @PostMapping
    public Result add(@RequestBody Notes notes) {
        notesService.save(notes);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        notesService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Notes notes) {
        notesService.update(notes);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Notes notes = notesService.findById(id);
        return ResultGenerator.genSuccessResult(notes);
    }

    @GetMapping("/get/{wardId}")
    public Result list(
            @PathVariable String wardId
    ) {
        Condition condition = new Condition(Notes.class);
        condition.createCriteria().andCondition("ward_id=" + wardId);
        List<Notes> byCondition = notesService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(byCondition);
    }

}
