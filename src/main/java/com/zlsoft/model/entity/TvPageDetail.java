package com.zlsoft.model.entity;

import javax.persistence.*;

@Table(name = "tv_page_detail")
public class TvPageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 页面id
     */
    @Column(name = "page_id")
    private Integer pageId;

    /**
     * 版块id
     */
    @Column(name = "panel_id")
    private Integer panelId;

    /**
     * 数据id
     */
    @Column(name = "data_id")
    private Integer dataId;

    /**
     * 说明列样式 eg:{name}({count})
     */
    @Column(name = "caption_style")
    private String captionStyle;

    /**
     * 值列样式 eg:{value}
     */
    @Column(name = "value_style")
    private String valueStyle;

    /**
     * 排序id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 显示护理级别 0:不显示 1:显示
     */
    @Column(name = "show_level")
    private Integer showLevel;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取页面id
     *
     * @return page_id - 页面id
     */
    public Integer getPageId() {
        return pageId;
    }

    /**
     * 设置页面id
     *
     * @param pageId 页面id
     */
    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    /**
     * 获取版块id
     *
     * @return panel_id - 版块id
     */
    public Integer getPanelId() {
        return panelId;
    }

    /**
     * 设置版块id
     *
     * @param panelId 版块id
     */
    public void setPanelId(Integer panelId) {
        this.panelId = panelId;
    }

    /**
     * 获取数据id
     *
     * @return data_id - 数据id
     */
    public Integer getDataId() {
        return dataId;
    }

    /**
     * 设置数据id
     *
     * @param dataId 数据id
     */
    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    /**
     * 获取说明列样式 eg:{name}({count})
     *
     * @return caption_style - 说明列样式 eg:{name}({count})
     */
    public String getCaptionStyle() {
        return captionStyle;
    }

    /**
     * 设置说明列样式 eg:{name}({count})
     *
     * @param captionStyle 说明列样式 eg:{name}({count})
     */
    public void setCaptionStyle(String captionStyle) {
        this.captionStyle = captionStyle;
    }

    /**
     * 获取值列样式 eg:{value}
     *
     * @return value_style - 值列样式 eg:{value}
     */
    public String getValueStyle() {
        return valueStyle;
    }

    /**
     * 设置值列样式 eg:{value}
     *
     * @param valueStyle 值列样式 eg:{value}
     */
    public void setValueStyle(String valueStyle) {
        this.valueStyle = valueStyle;
    }

    /**
     * 获取排序id
     *
     * @return order_id - 排序id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置排序id
     *
     * @param orderId 排序id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取显示护理级别 0:不显示 1:显示
     *
     * @return show_level - 显示护理级别 0:不显示 1:显示
     */
    public Integer getShowLevel() {
        return showLevel;
    }

    /**
     * 设置显示护理级别 0:不显示 1:显示
     *
     * @param showLevel 显示护理级别 0:不显示 1:显示
     */
    public void setShowLevel(Integer showLevel) {
        this.showLevel = showLevel;
    }
}