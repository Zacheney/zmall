package cn.zach.cloud.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zach
 * @date 2022/12/7 17:36
 */
public interface OrderService {
    @Transactional
    Boolean saveOrder(int cartId);
}
