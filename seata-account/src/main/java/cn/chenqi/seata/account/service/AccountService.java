package cn.chenqi.seata.account.service;

import cn.chenqi.seata.account.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
* @author chenqi
* @description 针对表【t_account】的数据库操作Service
* @createDate 2021-11-11 18:45:55
*/
public interface AccountService extends IService<Account> {

    void debit(String userId, BigDecimal orderMoney);
}
