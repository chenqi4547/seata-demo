package cn.chenqi.seata.storage.controller;

import cn.chenqi.seata.storage.entity.Stock;
import cn.chenqi.seata.storage.service.StockService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2021-11-13 18:58
 */
@RestController
@RequestMapping("/api/stock")
public class StorageController {

    @Autowired
    StockService stockService;

    @GetMapping(value = "/deduct")
    public void deduct(@RequestParam String commodityCode, @RequestParam Integer count) throws SQLException {
        System.out.println("stock XID " + RootContext.getXID());
        stockService.deduct(commodityCode, count);
    }

    @GetMapping(value = "/get/{id}")
    public Stock get(@PathVariable Integer id) {
        Stock stock = stockService.getById(id);
        return stock;
    }

}
