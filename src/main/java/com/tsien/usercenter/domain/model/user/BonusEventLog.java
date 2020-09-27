package com.tsien.usercenter.domain.model.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/9/12 0012 0:22
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BonusEventLog {
    /**
     * Id
     */
    private Integer id;

    /**
     * user.id
     */
    private Integer userId;

    /**
     * 积分操作值
     */
    private Integer value;

    /**
     * 发生的事件
     */
    private String event;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 描述
     */
    private String description;
}