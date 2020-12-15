package com.example.springbootehcache.controller;

import com.example.springbootehcache.bean.Student;
import com.example.springbootehcache.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class StudentController {

    @RequestMapping("queryStudent")
    public Student getStudent() {
        Student student = new Student();
        student.setSname("李wu");
        student.setSno("003");
        student.setSsex("F");
        return student;
    }
    @RequestMapping("queryUser")
    public User getUser() {
        User user = new User();
        user.setSname("李wu");
        user.setSno("003");
        user.setSsex("F");
        user.setDate(new Date());
        return user;
    }
}
