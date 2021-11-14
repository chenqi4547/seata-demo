package cn.chenqi.seata.order.service;

import cn.chenqi.seata.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author chenqi
 * @description 针对表【t_order】的数据库操作Service
 * @createDate 2021-11-11 18:51:56
 */
public interface OrderService extends IService<Order> {

    void create(String userId, String commodityCode, Integer count);
}
