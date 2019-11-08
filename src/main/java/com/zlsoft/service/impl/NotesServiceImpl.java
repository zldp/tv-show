package com.zlsoft.service.impl;

import com.zlsoft.dao.NotesMapper;
import com.zlsoft.model.entity.Notes;
import com.zlsoft.service.NotesService;
import com.zlsoft.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by DP on 2019/10/12.
 */
@Service
@Transactional
public class NotesServiceImpl extends AbstractService<Notes> implements NotesService {
    @Resource
    private NotesMapper notesMapper;

}
