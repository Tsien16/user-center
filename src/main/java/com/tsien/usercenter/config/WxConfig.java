package com.tsien.usercenter.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/9/25 0025 23:19
 */

@Configuration
public class WxConfig {

    @Bean
    public WxMaConfig wxMaConfig() {

        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setAppid("wx487790fcf9f56217");
        config.setSecret("412dfc51938dfefe644289f6166e9f1b");
        return config;
    }

    @Bean
    public WxMaService wxMaService(WxMaConfig wxMaConfig) {

        WxMaServiceImpl service = new WxMaServiceImpl();
        service.setWxMaConfig(wxMaConfig);
        return service;
    }
}
