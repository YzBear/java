package com.example.spring_boot_mybatisplus.controller;

import com.example.spring_boot_mybatisplus.dao.UserDao;
import com.example.spring_boot_mybatisplus.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserDao userDao;

    @GetMapping("/all")
    public List<User> getUsers(){
        return userDao.selectList(null);
    }
    @GetMapping("/insert")
    public String addUser(){
        User user = new User();
        user.setAge(18);
        user.setEmail("876434567@qq.com");
        user.setName("李四");
        int insert = userDao.insert(user);
        if(insert == 1){
            System.out.println(user);
            System.out.println(insert);
            return "插入成功！";
        }
        return "插入失败！";
    }
    @GetMapping("/update")
    public String updateUser(){
        User user = new User();
        user.setId(6L);
        user.setName("kwhua_mybatis-plus_updateTest");
        user.setAge(20);
        int insert = userDao.updateById(user);
        if(insert == 1){
            System.out.println(user);
            System.out.println(insert);
            return "修改成功！";
        }
        return "修改失败！";
    }
}
