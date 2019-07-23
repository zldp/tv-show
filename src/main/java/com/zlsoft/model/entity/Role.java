package com.zlsoft.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Role
 * @author dp926454
 * @date 2018/8/31 14:42
 */
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 6382925944937625109L;

    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色备注
     */
    private String remake;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置ID
     *
     * @param roleId ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获得角色名称
     * @return
     */

    public String getRemake() {
        return remake;
    }

    /**
     * 设置角色名称
     * @param remake
     */

    public void setRemake(String remake) {
        this.remake = remake;
    }
}