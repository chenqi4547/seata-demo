package cn.chenqi.seata.order.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2021-11-13 18:55
 */
@Component
@Slf4j
public class AccountServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    public void debit(String userId, BigDecimal orderMoney) {
        String url = "http://127.0.0.1:8095/account/debit?userId=" + userId + "&orderMoney=" + orderMoney;
        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception e) {
            throw new RuntimeException(String.format("debit url %s ,error:",url),e);
        }
    }
}
