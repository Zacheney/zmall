package cn.zach.cloud.service.impl;

import cn.zach.cloud.openfeign.GoodsService;
import cn.zach.cloud.openfeign.ShopCartService;
import cn.zach.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zach
 * @date 2022/12/7 17:37
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public Boolean saveOrder(int cartId) {
        //简单的模拟下单过程

        //1.获取商品id
        int goodsId = shopCartService.getGoodsId(cartId);
        //2.减库存
        goodsService.deStock(goodsId);
        //3.删除购物车
        shopCartService.deleteItem(cartId);
        //4.生成订单
        String sql = "insert into tb_order (cart_id) values (?)";
        int result = jdbcTemplate.update(sql, cartId);
        //5.返回结果
        return result > 0;
    }

}
