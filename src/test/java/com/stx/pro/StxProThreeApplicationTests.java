package com.stx.pro;

import com.stx.pro.mapper.ProductMapper;
import com.stx.pro.mapper.UserMapper;
import com.stx.pro.pojo.Product;
import com.stx.pro.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/*
 *SpringBoot测试
 * @author RenBoQing
 * @date 2022/5/30 0030 16:00
 * @param null
 * @return null
 */
@SpringBootTest
class StxProThreeApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    /*
     *基础测试
     * @author RenBoQing
     * @date 2022/5/30 0030 16:01
     */
    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     *根据openid查询用户
     * @author RenBoQing
     * @date 2022/6/8 0008 8:51
     */
    @Test
    void addUser() {
        User user = new User();
        user.setVgrade(1);
        user.setTelnumber("1223343");
        user.setPassword("fefewfwefdw");
        user.setSex(2);
        user.setNickname("人间至味是清欢");
        userMapper.insert(user);
    }

    /*
     *查询所有的用户数据
     * @author RenBoQing
     * @date 2022/6/8 0008 10:53
     */
    @Test
    void queryuse() {
        List<User> users = userMapper.selectList(null);
        int i = userMapper.deleteById(1534814745824976898L);
        for (User user : users) {
            System.out.println(user);
        }
    }



    @Test
    void insert(){
        Product product=new Product();

        int insert = productMapper.insert(product);
    }
}
