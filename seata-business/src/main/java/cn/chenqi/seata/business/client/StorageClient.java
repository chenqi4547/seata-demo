package cn.chenqi.seata.business.client;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2021-11-13 19:06
 */
@Component
@Slf4j
public class StorageClient {
    @Autowired
    private RestTemplate restTemplate;

    public void deduct(String commodityCode, int orderCount) {
        System.out.println("business to stock " + RootContext.getXID());
        String url = "http://127.0.0.1:8094/api/stock/deduct?commodityCode=" + commodityCode + "&count=" + orderCount;
        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception e) {
            throw new RuntimeException(String.format("deduct url %s ,error:", url), e);
        }
    }
}
