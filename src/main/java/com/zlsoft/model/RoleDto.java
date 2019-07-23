package com.zlsoft.model;

import com.zlsoft.model.entity.Role;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dp926454
 * @date 2018/8/30 10:47
 */
@Table(name = "role")
public class RoleDto extends Role {

    @Transient
    private List<PermissionDto> permissions = new ArrayList<>();

    public List<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}