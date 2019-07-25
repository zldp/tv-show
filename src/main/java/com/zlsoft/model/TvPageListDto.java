package com.zlsoft.model;

import com.zlsoft.model.entity.TvPageList;
import com.zlsoft.model.entity.TvPagePanel;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author dp
 * @version 1.0.0
 * @date 2019-07-25 16:16
 */
@Table(name = "tv_page_list")
public class TvPageListDto extends TvPageList {
    @Transient
    private List<TvPagePanel> tvPagePanels;

    public List<TvPagePanel> getTvPagePanels() {
        return tvPagePanels;
    }

    public void setTvPagePanels(List<TvPagePanel> tvPagePanels) {
        this.tvPagePanels = tvPagePanels;
    }
}
