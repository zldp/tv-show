package com.zlsoft.service.impl;

import com.zlsoft.dao.UserMapper;
import com.zlsoft.model.UserDto;
import com.zlsoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dp926454
 * @date 2018/8/9 15:45
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDto> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDto selectInfo(String account) {
        return userMapper.selectInfo(account);
    }
}
