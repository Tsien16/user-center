package com.tsien.usercenter.service.user;

import com.tsien.usercenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.tsien.usercenter.domain.dto.user.UserLoginDTO;
import com.tsien.usercenter.domain.model.user.User;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/7/19 0019 2:41
 */

public interface UserService {

    /**
     * 根据用户ID查询User
     *
     * @param id userId
     * @return User
     */
    User findById(Integer id);

    /**
     * 加积分
     *
     * @param message message
     */
    void addBonus(UserAddBonusMsgDTO message);

    /**
     * 用户登录
     *
     * @param loginDTO loginDTO
     * @param openId   openId
     * @return user
     */
    public User login(UserLoginDTO loginDTO, String openId);
}
