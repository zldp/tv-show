package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.entity.TvPageDetail;

import java.util.List;
import java.util.Map;

public interface TvPageDetailMapper extends Mapper<TvPageDetail> {
    /**
     * 获取大屏显示的数据
     * @return
     */
    List<Map<String,Object>> getPageDeTail(Map<String,Object> parpams);


    /**
     * 获取医嘱表的医嘱信息（护理看板）
     * @param params
     * @return
     */
    List<Map<String,Object>> selectMedicalByPatientIdAndIndexId(Map<String,Object> params);

    /**
     * 根据病人id和主页id获取护理等级
     *
     * @param parpams
     * @return
     */
    String getNursingGrade(Map<String,Object> parpams);

    /**
     * 根据waidId获取任务信息
     * @param wardId
     * @return
     */
    List<Map<String,Object>> getTaskOrderInfo(Integer wardId);
}