package cn.zach.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Zach
 * @date 2022/7/14 17:34
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"cn.zach.cloud.openfeign"})
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
