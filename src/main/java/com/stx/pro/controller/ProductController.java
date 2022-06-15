package com.stx.pro.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stx.pro.pojo.Product;
import com.stx.pro.service.ProductService;
import com.stx.pro.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author RenBoQing
 * @date 2022年06月14日 14:54
 * @Description
 */
@Controller
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/productListDemo")
    @ResponseBody
    public CommonResult queryProductList(Product product, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        String keyword = "demo";
        Page pageInfo = new Page(page, pageSize);
        ListOperations<String, Page> operations = redisTemplate.opsForList();
        if (redisTemplate.hasKey(keyword)) {
            log.info("使用了Redis缓存");
            return CommonResult.success(operations.range(keyword, 0, -1), "查询成功");
        } else {
            //当key不存在的时候  获取数据并传入redis
            //添加过滤条件
            LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.like(StringUtils.isNotEmpty(product.getPname()), Product::getPname, product.getPname());
            //添加排序条件
            queryWrapper.orderByDesc(Product::getPid);
            //执行查询
            productService.page(pageInfo, queryWrapper);
            operations.leftPushAll(keyword, pageInfo);
            return CommonResult.success(pageInfo, "查询成功");
        }
    }
}