package cn.chenqi.seata.business.service;

import cn.chenqi.seata.business.client.OrderClient;
import cn.chenqi.seata.business.client.StorageClient;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2021-11-13 19:03
 */
@Service
@Slf4j
public class BusinessService {
    @Autowired
    private StorageClient storageClient;
    @Autowired
    private OrderClient orderClient;

    /**
     * 减库存，下订单
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount) {
        log.info("purchase begin ... xid: " + RootContext.getXID());
        storageClient.deduct(commodityCode, orderCount);
        orderClient.create(userId, commodityCode, orderCount);
    }
}
