package com.stx.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stx.pro.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author RenBoQing
 * @date 2022年06月14日 14:50
 * @Description  商品Mapper接口
 */
@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}
