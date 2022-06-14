package com.stx.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stx.pro.mapper.ProductMapper;
import com.stx.pro.mapper.UserMapper;
import com.stx.pro.pojo.Product;
import com.stx.pro.pojo.User;
import com.stx.pro.service.ProductService;
import com.stx.pro.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author RenBoQing
 * @date 2022年06月14日 14:52
 * @Description
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
