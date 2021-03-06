package com.tsien.usercenter.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/9/25 0025 23:05
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRespDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 积分
     */
    private Integer bonus;

    /**
     * 微信昵称
     */
    private String wxNickname;

}
