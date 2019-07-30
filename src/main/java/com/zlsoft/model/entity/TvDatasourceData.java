package com.zlsoft.model.entity;

import javax.persistence.*;

@Table(name = "tv_datasource_data")
public class TvDatasourceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * format表id
     */
    @Column(name = "format_id")
    private Integer formatId;

    /**
     * 数据名称
     */
    @Column(name = "data_name")
    private String dataName;

    /**
     * 数据简称
     */
    private String abbreviation;

    /**
     * 病区id
     */
    @Column(name = "ward_id")
    private String wardId;

    /**
     * 统计值
     */
    @Column(name = "count_value")
    private Integer countValue;

    /**
     * 列表值
     */
    @Column(name = "list_value")
    private String listValue;

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
     * 获取format表id
     *
     * @return format_id - format表id
     */
    public Integer getFormatId() {
        return formatId;
    }

    /**
     * 设置format表id
     *
     * @param formatId format表id
     */
    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
    }

    /**
     * 获取数据名称
     *
     * @return data_name - 数据名称
     */
    public String getDataName() {
        return dataName;
    }

    /**
     * 设置数据名称
     *
     * @param dataName 数据名称
     */
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    /**
     * 获取数据简称
     *
     * @return abbreviation - 数据简称
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * 设置数据简称
     *
     * @param abbreviation 数据简称
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * 获取病区id
     *
     * @return ward_id - 病区id
     */
    public String getWardId() {
        return wardId;
    }

    /**
     * 设置病区id
     *
     * @param wardId 病区id
     */
    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    /**
     * 获取统计值
     *
     * @return count_value - 统计值
     */
    public Integer getCountValue() {
        return countValue;
    }

    /**
     * 设置统计值
     *
     * @param countValue 统计值
     */
    public void setCountValue(Integer countValue) {
        this.countValue = countValue;
    }

    /**
     * 获取列表值
     *
     * @return list_value - 列表值
     */
    public String getListValue() {
        return listValue;
    }

    /**
     * 设置列表值
     *
     * @param listValue 列表值
     */
    public void setListValue(String listValue) {
        this.listValue = listValue;
    }
}