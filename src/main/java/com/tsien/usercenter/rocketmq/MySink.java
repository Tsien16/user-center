package com.tsien.usercenter.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/9/20 0020 4:38
 */

public interface MySink {
    String MY_INPUT = "my-input";

    /**
     * input
     *
     * @return input
     */
    @Input(MY_INPUT)
    SubscribableChannel input();
}
