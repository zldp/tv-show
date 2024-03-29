package com.zlsoft.model.entity;

import javax.persistence.*;

@Table(name = "tv_datasource_format")
public class TvDatasourceFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 数据名称
     */
    @Column(name = "data_name")
    private String dataName;

    /**
     * 名称简写
     */
    private String abbreviation;

    /**
     * 病区id 为空全院共享 不为空科室独有
     */
    @Column(name = "ward_id")
    private String wardId;

    /**
     * 类别 1:来源于医嘱表 2:来源于sql语句
     */
    private Integer type;

    /**
     * 项目id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * 项目名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 条件语句
     */
    @Column(name = "where_str")
    private String whereStr;

    /**
     * 查询语句
     */
    @Column(name = "query_sql")
    private String querySql;

    /**
     * 列表字段
     */
    @Column(name = "list_field")
    private String listField;

    /**
     * 是否行转换 0:不转换 1:转换
     */
    @Column(name = "is_convert")
    private Integer isConvert;

    /**
     * 是否启用 0:不启用 1:启用
     */
    private Integer enabled;

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
     * 获取名称简写
     *
     * @return abbreviation - 名称简写
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * 设置名称简写
     *
     * @param abbreviation 名称简写
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * 获取病区id 为空全院共享 不为空科室独有
     *
     * @return ward_id - 病区id 为空全院共享 不为空科室独有
     */
    public String getWardId() {
        return wardId;
    }

    /**
     * 设置病区id 为空全院共享 不为空科室独有
     *
     * @param wardId 病区id 为空全院共享 不为空科室独有
     */
    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    /**
     * 获取类别 1:来源于医嘱表 2:来源于sql语句
     *
     * @return type - 类别 1:来源于医嘱表 2:来源于sql语句
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类别 1:来源于医嘱表 2:来源于sql语句
     *
     * @param type 类别 1:来源于医嘱表 2:来源于sql语句
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取项目id
     *
     * @return item_id - 项目id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置项目id
     *
     * @param itemId 项目id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取项目名称
     *
     * @return item_name - 项目名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置项目名称
     *
     * @param itemName 项目名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取条件语句
     *
     * @return where_str - 条件语句
     */
    public String getWhereStr() {
        return whereStr;
    }

    /**
     * 设置条件语句
     *
     * @param whereStr 条件语句
     */
    public void setWhereStr(String whereStr) {
        this.whereStr = whereStr;
    }

    /**
     * 获取查询语句
     *
     * @return query_sql - 查询语句
     */
    public String getQuerySql() {
        return querySql;
    }

    /**
     * 设置查询语句
     *
     * @param querySql 查询语句
     */
    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    /**
     * 获取列表字段
     *
     * @return list_field - 列表字段
     */
    public String getListField() {
        return listField;
    }

    /**
     * 设置列表字段
     *
     * @param listField 列表字段
     */
    public void setListField(String listField) {
        this.listField = listField;
    }

    /**
     * 获取是否行转换 0:不转换 1:转换
     *
     * @return is_convert - 是否行转换 0:不转换 1:转换
     */
    public Integer getIsConvert() {
        return isConvert;
    }

    /**
     * 设置是否行转换 0:不转换 1:转换
     *
     * @param isConvert 是否行转换 0:不转换 1:转换
     */
    public void setIsConvert(Integer isConvert) {
        this.isConvert = isConvert;
    }

    /**
     * 获取是否启用 0:不启用 1:启用
     *
     * @return enabled - 是否启用 0:不启用 1:启用
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * 设置是否启用 0:不启用 1:启用
     *
     * @param enabled 是否启用 0:不启用 1:启用
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}