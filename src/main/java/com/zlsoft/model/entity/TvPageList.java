package com.zlsoft.model.entity;

import javax.persistence.*;

@Table(name = "tv_page_list")
public class TvPageList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 页面标题
     */
    private String title;

    /**
     * 页面类型 0:原生 1:web
     */
    private Integer type;

    /**
     * 页面地址
     */
    @Column(name = "page_address")
    private String pageAddress;

    /**
     * 病区ID 为空表示所有病区公用
     */
    @Column(name = "ward_id")
    private String wardId;

    /**
     * 排序ID
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 是否显示 0:不显示 1:显示
     */
    private Integer visible;

    /**
     * 停留时间 单位:秒
     */
    @Column(name = "stay_time")
    private Integer stayTime;

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
     * 获取页面标题
     *
     * @return title - 页面标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置页面标题
     *
     * @param title 页面标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取页面类型 0:原生 1:web
     *
     * @return type - 页面类型 0:原生 1:web
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置页面类型 0:原生 1:web
     *
     * @param type 页面类型 0:原生 1:web
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取页面地址
     *
     * @return page_address - 页面地址
     */
    public String getPageAddress() {
        return pageAddress;
    }

    /**
     * 设置页面地址
     *
     * @param pageAddress 页面地址
     */
    public void setPageAddress(String pageAddress) {
        this.pageAddress = pageAddress;
    }

    /**
     * 获取病区ID 为空表示所有病区公用
     *
     * @return ward_id - 病区ID 为空表示所有病区公用
     */
    public String getWardId() {
        return wardId;
    }

    /**
     * 设置病区ID 为空表示所有病区公用
     *
     * @param wardId 病区ID 为空表示所有病区公用
     */
    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    /**
     * 获取排序ID
     *
     * @return order_id - 排序ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置排序ID
     *
     * @param orderId 排序ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取是否显示 0:不显示 1:显示
     *
     * @return visible - 是否显示 0:不显示 1:显示
     */
    public Integer getVisible() {
        return visible;
    }

    /**
     * 设置是否显示 0:不显示 1:显示
     *
     * @param visible 是否显示 0:不显示 1:显示
     */
    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    /**
     * 获取停留时间 单位:秒
     *
     * @return stay_time - 停留时间 单位:秒
     */
    public Integer getStayTime() {
        return stayTime;
    }

    /**
     * 设置停留时间 单位:秒
     *
     * @param stayTime 停留时间 单位:秒
     */
    public void setStayTime(Integer stayTime) {
        this.stayTime = stayTime;
    }
}