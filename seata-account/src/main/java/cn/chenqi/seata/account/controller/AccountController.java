package cn.chenqi.seata.account.controller;

import cn.chenqi.seata.account.entity.Account;
import cn.chenqi.seata.account.service.AccountService;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2021-11-11 19:00
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping
    @RequestMapping("/get/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        Account account = accountService.getById(id);
        return account;
    }

    @GetMapping
    @RequestMapping("/debit")
    public void debit(@RequestParam String userId, @RequestParam BigDecimal orderMoney) {
        System.out.println("account XID :" + RootContext.getXID());
        accountService.debit(userId, orderMoney);
    }
}
