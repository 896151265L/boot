package com.example.boot.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created
 * author:  lqk
 * 2019/8/26 15:43   项目启动会加载
 */
@Component
public class DefaultConfig implements InitializingBean {



    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * 项目启动就会加载执行该方法
         */
    }
}
