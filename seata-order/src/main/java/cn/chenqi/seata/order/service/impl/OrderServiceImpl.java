package cn.chenqi.seata.order.service.impl;

import cn.chenqi.seata.order.client.AccountServiceClient;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chenqi.seata.order.entity.Order;
import cn.chenqi.seata.order.service.OrderService;
import cn.chenqi.seata.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author chenqi
 * @description 针对表【t_order】的数据库操作Service实现
 * @createDate 2021-11-11 18:51:56
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    @Autowired
    private AccountServiceClient accountServiceClient;

    @Override
    public void create(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setAmount(orderMoney);

        this.baseMapper.insert(order);

        accountServiceClient.debit(userId, orderMoney);

    }
}




