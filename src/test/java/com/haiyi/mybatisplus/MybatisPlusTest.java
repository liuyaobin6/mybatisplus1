package com.haiyi.mybatisplus;

import com.haiyi.mybatisplus.mapper.UserMapper;
import com.haiyi.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectList(){
        List<User> usersList = userMapper.selectList(null);
        usersList.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert=" + insert);
    }
    @Test
    public void testDelete(){
        int i = userMapper.deleteById(1694603660095606785l);
        System.out.println("i=" + i);
    }
    @Test
    public void testDeleteByMap(){
        Map<String,Object> map = new HashMap();
        map.put("name","张三");
        map.put("age","23");
        int result = userMapper.deleteByMap(map);
        System.out.println("result=" + result);
    }
    @Test
    public void testDeleteBatchIds(){
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(ids);
        System.out.println("result = " + result);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setEmail("lisi@qq.com");
        user.setName("李四");
        user.setId(4l);
        int result = userMapper.updateById(user);
        System.out.println("result = " + result);
    }
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(4L);
        System.out.println(user);
    }
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(4l, 5l));
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","李四");
        map.put("age",21);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectMapById(){
        Map<String, Object> result = userMapper.selectMapById(4l);
        System.out.println(result);
    }

}
