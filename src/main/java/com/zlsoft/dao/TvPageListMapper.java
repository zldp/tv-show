package com.zlsoft.dao;

import com.zlsoft.core.Mapper;
import com.zlsoft.model.TvPageListDto;
import com.zlsoft.model.entity.TvPageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TvPageListMapper extends Mapper<TvPageList> {
    /**
     * 根据wardId获取数据
     * @param wardId
     * @return
     */
    /*SELECT
        a.id,
        a.title,
        a.type,
        a.page_address,
        a.ward_id,
        a.order_id,
        a.visible,
        a.stay_time,
        b.id AS pid,
        b.page_id,
        b.panel_id,
        b.panel_left,
        b.panel_top,
        b.panel_width,
        b.panel_height
      FROM tv_page_list AS a  LEFT JOIN tv_page_panel AS b ON a.id=b.page_id
      WHERE (a.ward_id = #{wardId} OR a.ward_id IS NULL OR a.ward_id = "")
      AND a.visible = 1
      ORDER BY a.order_id*/
    List<TvPageList> selectByWardId(@Param(value = "wardId") String wardId);

}