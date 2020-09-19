package com.tsien.usercenter.rocketmq;

import com.tsien.usercenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.tsien.usercenter.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/9/11 0011 23:56
 */

@Service
@Slf4j
public class AddBonusStreamConsumer {

    @Resource
    private UserService userService;

    /**
     * 增加积分
     *
     * @param userAddBonusMsgDTO userAddBonusMsgDTO
     */
    @StreamListener(Sink.INPUT)
    public void receive(UserAddBonusMsgDTO userAddBonusMsgDTO) {
        userService.addBonus(userAddBonusMsgDTO);

    }
}
