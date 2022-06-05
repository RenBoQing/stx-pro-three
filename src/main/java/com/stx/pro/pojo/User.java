package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author RenBoQing
 * @date 2022年05月30日 16:32
 * @Description 测试实体类测试
 */
@Data
@TableName("user")
public class User {
    private Long id;
    private String name;
}
