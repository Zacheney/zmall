package cn.zach.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Zach
 * @date 2022/12/7 17:29
 */
@FeignClient(name = "zmall-cloud-goods-service",path = "/goods")
public interface GoodsService {

    @PostMapping(value = "/delStock/{goodsId}")
    public Boolean deStock(@PathVariable("goodsId") int goodsId);
}
