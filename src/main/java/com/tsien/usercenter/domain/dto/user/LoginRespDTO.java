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
 * @date 2020/9/25 0025 23:08
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRespDTO {

    /**
     * token
     */
    private JwtTokenRespDTO token;

    /**
     * 用户信息
     */
    private UserRespDTO user;
}
