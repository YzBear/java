package com.myall.mybatis.controller;

import com.myall.mybatis.bean.Student;
import com.myall.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return this.studentService.queryStudentBySno(sno);
    }
}
