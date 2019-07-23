package com.zlsoft.dao;

import com.zlsoft.model.RoleDto;
import com.zlsoft.model.UserDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * RoleMapper
 * @author dp926454
 * @date 2018/8/31 14:42
 */
public interface RoleMapper extends Mapper<RoleDto> {
    /**
     * 根据User查询Role
     * @param userDto
     * @return java.util.List<com.dp.model.RoleDto>
     * @author dp926454
     * @date 2018/8/31 11:30
     */
    public List<RoleDto> findRoleByUser(UserDto userDto);
}