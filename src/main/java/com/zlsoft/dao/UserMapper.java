package com.zlsoft.dao;

import com.zlsoft.model.UserDto;
import tk.mybatis.mapper.common.Mapper;

/**
 * UserMapper
 * @author dp926454
 * @date 2018/8/31 14:43
 */
public interface UserMapper extends Mapper<UserDto> {

    UserDto selectInfo(String account);
}