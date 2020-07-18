package com.tsien.usercenter.service.user;

import com.tsien.usercenter.dao.user.UserMapper;
import com.tsien.usercenter.domain.model.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/7/19 0019 2:41
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户ID查询User
     *
     * @param id userId
     * @return User
     */
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
