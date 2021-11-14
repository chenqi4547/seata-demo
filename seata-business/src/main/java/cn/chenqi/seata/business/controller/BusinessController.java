package cn.chenqi.seata.business.controller;

import cn.chenqi.seata.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2021-11-13 19:02
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/purchase/commit")
    public boolean purchaseCommit(@RequestParam String userId) {
        businessService.purchase(userId, "C201901140001", 1);
        return true;
    }
}
