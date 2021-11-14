package cn.chenqi.seata.storage.service;

import cn.chenqi.seata.storage.entity.Stock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author chenqi
* @description 针对表【t_stock】的数据库操作Service
* @createDate 2021-11-11 18:53:50
*/
public interface StockService extends IService<Stock> {

    void deduct(String commodityCode, Integer count);
}
