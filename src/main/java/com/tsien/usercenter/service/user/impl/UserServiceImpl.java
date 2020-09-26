package com.tsien.usercenter.service.user.impl;

import com.tsien.usercenter.dao.user.BonusEventLogMapper;
import com.tsien.usercenter.dao.user.UserMapper;
import com.tsien.usercenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.tsien.usercenter.domain.dto.user.UserLoginDTO;
import com.tsien.usercenter.domain.model.user.BonusEventLog;
import com.tsien.usercenter.domain.model.user.User;
import com.tsien.usercenter.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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

    @Resource
    private BonusEventLogMapper bonusEventLogMapper;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addBonus(UserAddBonusMsgDTO message) {

        // 1.为用户加积分
        Integer userId = message.getUserId();
        Integer bonus = message.getBonus();
        User user = userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + bonus);
        userMapper.updateByPrimaryKeySelective(user);

        // 2.记录日志到bonus_event_log表里
        bonusEventLogMapper.insert(BonusEventLog.builder()
                .userId(userId)
                .value(bonus)
                .event("CONTRIBUTE")
                .createTime(new Date())
                .description("投稿加积分")
                .build());
    }

    /**
     * 用户登录
     *
     * @param loginDTO loginDTO
     * @param openId   openId
     * @return user
     */
    @Override
    public User login(UserLoginDTO loginDTO, String openId) {
        User user = userMapper.selectOne(User.builder().wxId(openId).build());

        if (user == null) {
            User userToSave = User.builder()
                    .wxId(openId)
                    .bonus(300)
                    .wxNickname(loginDTO.getWxNickname())
                    .avatarUrl(loginDTO.getAvatarUrl())
                    .roles("user")
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            userMapper.insertSelective(userToSave);
            return userToSave;
        }

        return user;

    }
}
