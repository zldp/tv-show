package com.zlsoft.dao;

import com.zlsoft.model.PermissionDto;
import com.zlsoft.model.RoleDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * PermissionMapper
 * @author dp926454
 * @date 2018/8/31 14:42
 */
public interface PermissionMapper extends Mapper<PermissionDto> {
    /**
     * 根据Role查询Permission
     * @param roleDto
     * @return java.util.List<com.dp.model.PermissionDto>
     * @author dp926454
     * @date 2018/8/31 11:30
     */
    public List<PermissionDto> findPermissionByRole(RoleDto roleDto);
}