package com.stx.pro.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stx.pro.pojo.Product;
import com.stx.pro.service.ProductService;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月14日 14:54
 * @Description 水果视图层
 */
@Controller
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    //引入redis的template
    @Autowired
    private RedisTemplate redisTemplate;

    /*
     *返回前端的数据接口
     * @author RenBoQing
     * @date 2022/6/15 0015 9:26
     * @param product
     * @param page
     * @param pageSize
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping("/productList")
    @ResponseBody
    public CommonResult queryProductList(Product product, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        //String keyword = "productListForWx";
        Page pageInfo = new Page(page, pageSize);
        //ListOperations<String, Page> operations = redisTemplate.opsForList();
        //if (redisTemplate.hasKey(keyword)) {
        //    return CommonResult.success(operations.range(keyword, 0, -1), "查询成功");
        //    //当key不存在的时候  获取数据并传入redis
        //} else {
        //添加过滤条件
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(product.getPname()), Product::getPname, product.getPname());
        //添加排序条件
        queryWrapper.orderByDesc(Product::getPid);
        //执行查询
        productService.page(pageInfo, queryWrapper);
        //operations.leftPushAll(keyword, pageInfo);
        return CommonResult.success(pageInfo, "查询成功");
        //}
    }

    /*
     *为后台数据接口
     * @author RenBoQing
     * @date 2022/6/15 0015 9:33
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping("/productListForWeb")
    @ResponseBody
    public JsonObject productListForWeb(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        List<Product> productList = productService.list();
        return JsonObject.success(0, productList, "查询成功", (long) productList.size());
        //当key不存在的时候  获取数据并传入redis
    }

    /*
     *添加商城
     * @author RenBoQing
     * @date 2022/6/16 0016 21:29
     * @param product
     * @return com.stx.pro.utils.JsonObject
     */
    @RequestMapping("/productAdd")
    @ResponseBody
    public JsonObject productAdd(Product product) {
        boolean save = productService.save(product);
        if (save) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }
    @RequestMapping(value = "/del/{pid}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonObject productDel(@PathVariable("pid") Long pid) {
        boolean b = productService.removeById(pid);
        if (b) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/6/17 0017 9:11
     * @param ids
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping("/delProduictByIds")
    @ResponseBody
    public CommonResult delProductByIds(String ids) {
        //将获取到的ids的数组进行分割
        String[] strs = ids.split(",");
        List<Long> delList = new ArrayList<>();
        //遍历这些ids 并将其添加到List集合中  强制转换
        for (String str : strs) {
            delList.add(Long.parseLong(str));
        }
        //是否删除成功
        boolean b = productService.removeByIds(delList);
        if (b) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.failed("删除失败");
        }
    }

    /*
     *修改相关数据
     * @author RenBoQing
     * @date 2022/6/17 0017 10:21
     * @param product
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping(value = "/updateProductByPid", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateProductByPid(Product product) {
        boolean updateById = productService.updateById(product);
        if (updateById) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }
}