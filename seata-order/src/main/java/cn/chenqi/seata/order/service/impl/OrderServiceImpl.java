package cn.chenqi.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chenqi.seata.order.entity.Order;
import cn.chenqi.seata.order.service.OrderService;
import cn.chenqi.seata.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author chenqi
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2021-11-11 18:51:56
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




