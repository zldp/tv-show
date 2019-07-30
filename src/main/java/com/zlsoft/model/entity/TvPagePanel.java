package com.zlsoft.model.entity;

import javax.persistence.*;

@Table(name = "tv_page_panel")
public class TvPagePanel {
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
     * 左边距离
     */
    @Column(name = "panel_left")
    private Integer panelLeft;

    /**
     * 顶部距离
     */
    @Column(name = "panel_top")
    private Integer panelTop;

    /**
     * 版块宽度
     */
    @Column(name = "panel_width")
    private Integer panelWidth;

    /**
     * 版块高度
     */
    @Column(name = "panel_height")
    private Integer panelHeight;

    /**
     * 数据类型0:本地 1:接口
     */
    @Column(name = "data_type")
    private Integer dataType;

    /**
     * sql语句
     */
    @Column(name = "data_sql")
    private String dataSql;

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
     * 获取左边距离
     *
     * @return panel_left - 左边距离
     */
    public Integer getPanelLeft() {
        return panelLeft;
    }

    /**
     * 设置左边距离
     *
     * @param panelLeft 左边距离
     */
    public void setPanelLeft(Integer panelLeft) {
        this.panelLeft = panelLeft;
    }

    /**
     * 获取顶部距离
     *
     * @return panel_top - 顶部距离
     */
    public Integer getPanelTop() {
        return panelTop;
    }

    /**
     * 设置顶部距离
     *
     * @param panelTop 顶部距离
     */
    public void setPanelTop(Integer panelTop) {
        this.panelTop = panelTop;
    }

    /**
     * 获取版块宽度
     *
     * @return panel_width - 版块宽度
     */
    public Integer getPanelWidth() {
        return panelWidth;
    }

    /**
     * 设置版块宽度
     *
     * @param panelWidth 版块宽度
     */
    public void setPanelWidth(Integer panelWidth) {
        this.panelWidth = panelWidth;
    }

    /**
     * 获取版块高度
     *
     * @return panel_height - 版块高度
     */
    public Integer getPanelHeight() {
        return panelHeight;
    }

    /**
     * 设置版块高度
     *
     * @param panelHeight 版块高度
     */
    public void setPanelHeight(Integer panelHeight) {
        this.panelHeight = panelHeight;
    }

    /**
     * 获取数据类型0:本地 1:接口
     *
     * @return data_type - 数据类型0:本地 1:接口
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * 设置数据类型0:本地 1:接口
     *
     * @param dataType 数据类型0:本地 1:接口
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     * 获取sql语句
     *
     * @return data_sql - sql语句
     */
    public String getDataSql() {
        return dataSql;
    }

    /**
     * 设置sql语句
     *
     * @param dataSql sql语句
     */
    public void setDataSql(String dataSql) {
        this.dataSql = dataSql;
    }
}