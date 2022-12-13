package cn.zach.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zach
 * @date 2022/7/15 10:10
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostMapping(value = "/delStock/{goodsId}")
    public Boolean deStock(@PathVariable("goodsId") int goodsId) {
        String sql = "update tb_goods set goods_stock = goods_stock - 1 where goods_id = ?";
        int result = jdbcTemplate.update(sql, goodsId);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
