package cn.chenqi.seata.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chenqi.seata.account.entity.Account;
import cn.chenqi.seata.account.service.AccountService;
import cn.chenqi.seata.account.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author chenqi
 * @description 针对表【t_account】的数据库操作Service实现
 * @createDate 2021-11-11 18:45:55
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
        implements AccountService {

    @Override
    public void debit(String userId, BigDecimal orderMoney) {
        Account account = this.lambdaQuery().eq(Account::getUserId, userId).one();
        account.setAmount(account.getAmount().subtract(orderMoney));
        this.updateById(account);

        if ("1002".equals(userId)) {
            // 模拟异常
            throw new RuntimeException("userId not exits, branch exception");
        }
    }
}




