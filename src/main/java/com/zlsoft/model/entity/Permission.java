package com.zlsoft.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Permission
 * @author dp926454
 * @date 2018/8/31 14:41
 */
@Table(name = "permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = -8834983208597107688L;

    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer perId;

    /**
     * 资源名称
     */
    private String perName;

    /**
     * 权限代码字符串
     */
    @Column(name = "per_code")
    private String perCode;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getPerId() {
        return perId;
    }

    /**
     * 设置ID
     *
     * @param perId ID
     */
    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getPerName() {
        return perName;
    }

    /**
     * 设置资源名称
     *
     * @param perName 资源名称
     */
    public void setPerName(String perName) {
        this.perName = perName;
    }

    /**
     * 获取权限代码字符串
     *
     * @return per_code - 权限代码字符串
     */
    public String getPerCode() {
        return perCode;
    }

    /**
     * 设置权限代码字符串
     *
     * @param perCode 权限代码字符串
     */
    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }
}