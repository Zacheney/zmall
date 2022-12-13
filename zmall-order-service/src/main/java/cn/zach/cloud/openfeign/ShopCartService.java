package cn.zach.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zach
 * @date 2022/12/7 17:29
 */
@FeignClient(name = "zmall-cloud-cart-service", path = "/shop-cart")
public interface ShopCartService {

    @PostMapping("/getGoodsId")
    public int getGoodsId(@RequestParam("cartId") int cartId);

    @PostMapping("/{cartId}")
    public Boolean deleteItem(@PathVariable("cartId") int cartId);
}
