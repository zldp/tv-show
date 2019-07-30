package com.zlsoft.service;
import com.zlsoft.core.Service;
import com.zlsoft.model.TvPageListDto;
import com.zlsoft.model.entity.TvPageList;

import java.util.List;


/**
 * Created by DP on 2019/07/24.
 */
public interface TvPageListService extends Service<TvPageList> {
    /**
     * 根据wardId获取菜单栏的数据
     * @param wardId
     * @return
     */
    List<TvPageList> selectByWardId(String wardId);
}
