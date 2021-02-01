package com.example.spring_boot_mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring_boot_mybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
