package cn.chenqi.seata.storage.service.impl;

import cn.chenqi.seata.storage.entity.Stock;
import cn.chenqi.seata.storage.mapper.StockMapper;
import cn.chenqi.seata.storage.service.StockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author chenqi
 * @description 针对表【t_stock】的数据库操作Service实现
 * @createDate 2021-11-11 18:53:50
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock>
        implements StockService {

    @Override
    public void deduct(String commodityCode, Integer count) {
        Stock stock = lambdaQuery().eq(Stock::getCommodityCode, commodityCode).one();
        stock.setCount(stock.getCount() - count);
        baseMapper.updateById(stock);
    }
}




