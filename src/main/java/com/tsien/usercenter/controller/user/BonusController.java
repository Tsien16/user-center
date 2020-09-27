package com.tsien.usercenter.controller.user;

import com.tsien.usercenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.tsien.usercenter.domain.dto.user.UserAddBonusDTO;
import com.tsien.usercenter.domain.model.user.User;
import com.tsien.usercenter.service.user.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/9/27 0027 14:59
 */

@RestController
@RequestMapping("/users")
public class BonusController {

    @Resource
    private UserService userService;

    @PutMapping("/add-bonus")
    public User addBonus(@RequestBody UserAddBonusDTO userAddBonusDTO) {
        userService.addBonus(
                UserAddBonusMsgDTO.builder()
                        .userId(userAddBonusDTO.getUserId())
                        .bonus(userAddBonusDTO.getBonus())
                        .description("兑换分享")
                        .event("BUY")
                        .build());

        return userService.findById(userAddBonusDTO.getUserId());
    }
}
