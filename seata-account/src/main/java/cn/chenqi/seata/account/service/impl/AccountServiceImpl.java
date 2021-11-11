package cn.chenqi.seata.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chenqi.seata.account.entity.Account;
import cn.chenqi.seata.account.service.AccountService;
import cn.chenqi.seata.account.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
* @author chenqi
* @description 针对表【t_account】的数据库操作Service实现
* @createDate 2021-11-11 18:45:55
*/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

}




