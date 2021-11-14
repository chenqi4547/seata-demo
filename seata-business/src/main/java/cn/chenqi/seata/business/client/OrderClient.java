package cn.chenqi.seata.business.client;

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
public class OrderClient {

    @Autowired
    private RestTemplate restTemplate;

    public void create(String userId, String commodityCode, int orderCount) {
        String url = "http://127.0.0.1:8092/api/order/debit?userId=" + userId + "&commodityCode=" + commodityCode
                + "&count=" + orderCount;
        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception e) {
            throw new RuntimeException(String.format("create url %s ,error:", url));
        }
    }

}
