package com.tsien.usercenter.rocketmq;

import com.tsien.usercenter.dao.user.BonusEventLogMapper;
import com.tsien.usercenter.dao.user.UserMapper;
import com.tsien.usercenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.tsien.usercenter.domain.model.user.BonusEventLog;
import com.tsien.usercenter.domain.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/9/11 0011 23:56
 */

@Service
@RocketMQMessageListener(consumerGroup = "consumerGroup", topic = "add-bonus")
@Slf4j
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDTO> {

    @Resource
    private UserMapper userMapper;

    @Resource
    private BonusEventLogMapper bonusEventLogMapper;

    /**
     * 当收到消息的时候，执行的业务
     *
     * @param message message
     */
    @Override
    public void onMessage(UserAddBonusMsgDTO message) {
        log.error("onMessage方法被调用了");
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
}
