package com.pps.back.frame.pupansheng.common.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Classname PayConfig
 * @Description
 * @@Author Pupansheng
 * @Date 2019/7/1 17:11
 * @Vestion 1.0
 **/
@Component
@ConfigurationProperties(prefix = "email")
@PropertySource(value = "classpath:config.properties")
public class Config {

    private  String servers;

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }
}
