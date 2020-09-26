package com.tsien.usercenter.controller.user;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.tsien.usercenter.auth.CheckLogin;
import com.tsien.usercenter.domain.dto.user.JwtTokenRespDTO;
import com.tsien.usercenter.domain.dto.user.LoginRespDTO;
import com.tsien.usercenter.domain.dto.user.UserLoginDTO;
import com.tsien.usercenter.domain.dto.user.UserRespDTO;
import com.tsien.usercenter.domain.model.user.User;
import com.tsien.usercenter.service.user.UserService;
import com.tsien.usercenter.util.JwtOperator;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/7/19 0019 2:48
 */

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private WxMaService wxMaService;

    @Resource
    private JwtOperator jwtOperator;

    @GetMapping("/{id}")
    @CheckLogin
    public User findById(@PathVariable Integer id) {
        log.info("我是用户中心，我被请求了...");
        return userService.findById(id);
    }

    @GetMapping("/gen-token")
    public String genToken() {
        Map<String, Object> userInfo = new HashMap<>(5);
        userInfo.put("id", 1);
        userInfo.put("wxNickname", "Tsien");
        userInfo.put("role", "admin");
        return jwtOperator.generateToken(userInfo);
    }

    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody UserLoginDTO loginDTO) throws WxErrorException {

        // 微信小程序服务端校验是否已经登陆的结果
        WxMaJscode2SessionResult result = wxMaService.getUserService().getSessionInfo(loginDTO.getCode());

        // 微信的openId，用户在微信这边的唯一标识
        String openId = result.getOpenid();

        // 看用户是否注册，如果没有注册就插入
        User user = userService.login(loginDTO, openId);

        // 如果已经注册，就直接办法token
        Map<String, Object> userInfo = new HashMap<>(5);
        userInfo.put("id", user.getId());
        userInfo.put("wxNickname", user.getWxNickname());
        userInfo.put("role", user.getRoles());
        String token = jwtOperator.generateToken(userInfo);
        log.info("用户{}登陆成功，生成的token = {}, 有效期到:{}", loginDTO.getWxNickname(), token,
                jwtOperator.getExpirationTime());

        // 构建响应
        return LoginRespDTO.builder()
                .user(UserRespDTO.builder()
                        .id(user.getId())
                        .avatarUrl(user.getAvatarUrl())
                        .bonus(user.getBonus())
                        .wxNickname(user.getWxNickname())
                        .build())
                .token(JwtTokenRespDTO.builder()
                        .expirationTime(jwtOperator.getExpirationTime().getTime())
                        .token(token)
                        .build())
                .build();

    }

}
