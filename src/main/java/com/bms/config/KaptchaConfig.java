package com.bms.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.google.code.kaptcha.util.Config;

import java.util.Properties;

@Component
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        com.google.code.kaptcha.impl.DefaultKaptcha defaultKaptcha = new com.google.code.kaptcha.impl.DefaultKaptcha();
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no"); // 是否加边框
        properties.put("kaptcha.image.width", "150"); // 图片宽度
        properties.put("kaptcha.image.height", "40"); // 图片高度
        properties.put("kaptcha.textproducer.font.size", "30"); // 字体大小
        properties.put("kaptcha.textproducer.font.color", "black"); // 字体颜色
        properties.put("kaptcha.session.key", "verifyCode"); // 验证码
        properties.put("kaptcha.textproducer.char.space", "5");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}