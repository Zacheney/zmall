package cn.zach.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zach
 * @date 2022/12/7 16:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private String goodsId;
    private String goodsName;
    private String goodsStock;
}
