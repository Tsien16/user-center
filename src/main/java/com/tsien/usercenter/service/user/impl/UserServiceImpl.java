package com.tsien.usercenter.service.user.impl;

import com.tsien.usercenter.dao.user.UserMapper;
import com.tsien.usercenter.domain.model.user.User;
import com.tsien.usercenter.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/8/4 0004 17:32
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户ID查询User
     *
     * @param id userId
     * @return User
     */
    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
