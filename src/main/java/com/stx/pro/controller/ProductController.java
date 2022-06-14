package com.stx.pro.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stx.pro.pojo.Product;
import com.stx.pro.service.ProductService;
import com.stx.pro.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月14日 14:54
 * @Description
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /*
     *查询所有的商品
     * @author RenBoQing
     * @date 2022/6/14 0014 15:03
     * @param product
     * @param page
     * @param limit
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping("/productList")
    @ResponseBody
    public CommonResult queryAllProducts(Product product, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        //添加信息
        Page pageInfo = new Page(page, pageSize);
        //添加过滤条件
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.
                like(StringUtils.isNotEmpty(product.getPname()), Product::getPname, product.getPname())
        ;
        queryWrapper.orderByDesc(Product::getPid);
        //执行查询
        productService.page(pageInfo, queryWrapper);
        if (pageInfo.getRecords().size() > 0) {
            return CommonResult.success(pageInfo, "查询成功");
        } else {
            return CommonResult.failed("暂无数据");
        }
    }
}
