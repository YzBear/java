package com.example.spring_boot_mybatisplus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring_boot_mybatisplus.dao.UserDao;
import com.example.spring_boot_mybatisplus.entity.User;
import com.example.spring_boot_mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yzx
 * @since 2021-02-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
