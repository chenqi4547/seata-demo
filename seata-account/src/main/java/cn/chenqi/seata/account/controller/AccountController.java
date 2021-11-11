package cn.chenqi.seata.account.controller;

import cn.chenqi.seata.account.entity.Account;
import cn.chenqi.seata.account.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
