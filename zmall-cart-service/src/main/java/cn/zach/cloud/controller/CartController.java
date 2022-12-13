package cn.zach.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Zach
 * @date 2022/7/15 10:14
 */
@RestController
@RequestMapping("/shop-cart")
public class CartController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/getGoodsId")
    public int getGoodsId(@RequestParam("cartId") int cartId) {
        // 根据主键id查询购物表
        Map<String, Object> cartItemObject = jdbcTemplate.queryForMap("select * from tb_cart_item where cart_id=" + cartId + " limit 1");
        if (cartItemObject.containsKey("goods_id")) {
            // 返回商品id
            return (int) cartItemObject.get("goods_id");
        }
        return 0;
    }

    @PostMapping("/{cartId}")
    public Boolean deleteItem(@PathVariable("cartId") int cartId) {
        // 删除购物车数据
        int result = jdbcTemplate.update("delete from tb_cart_item where cart_id=" + cartId);
        if (result > 0) {
            return true;
        }
        return false;
    }


}
