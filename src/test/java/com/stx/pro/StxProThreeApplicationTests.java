package com.stx.pro;

import com.stx.pro.mapper.UserMapper;
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

}
