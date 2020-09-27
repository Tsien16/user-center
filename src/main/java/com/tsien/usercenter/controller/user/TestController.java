package com.tsien.usercenter.controller.user;

import com.tsien.usercenter.dao.user.UserMapper;
import com.tsien.usercenter.domain.model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/7/19 0019 17:10
 */

@RestController
public class TestController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/test")
    public User testInsert() {
        User user = new User();
        user.setAvatarUrl("XXX");
        user.setBonus(100);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);
        return user;
    }

    @GetMapping("/q")
    public User query(User user) {
        return user;
    }
}
