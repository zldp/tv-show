package com.zlsoft.service;

import com.zlsoft.model.UserDto;


/**
 *
 * @author dp926454
 * @date 2018/8/9 15:44
 */
public interface IUserService extends IBaseService<UserDto> {
    UserDto selectInfo(String account);
}
