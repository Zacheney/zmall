package cn.zach.cloud.config;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.http.codec.json.Jackson2JsonDecoder;

import java.util.concurrent.TimeUnit;

/**
 * @author Zach
 * @date 2022/7/23 23:35
 */
//@Configuration
public class FeignConfig {

//    @Bean
//    public Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }
//
//    @Bean
//    public Contract feignContract() {
//        return new Contract.Default();
//    }

//    @Bean
//    public Request.Options options() {
//        return new Request.Options(5000, TimeUnit.MILLISECONDS, 5000, TimeUnit.MILLISECONDS, true);
//    }

    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor() {
        return new BasicAuthenticationInterceptor("user", "password");
    }
}
