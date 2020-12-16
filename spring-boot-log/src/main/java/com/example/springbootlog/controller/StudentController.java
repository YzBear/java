package com.example.springbootlog.controller;

import com.example.springbootlog.bean.Student;
import com.example.springbootlog.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/update")
    String update(){
        Student student = new Student();
        student.setSname("里斯");
        student.setSno("001");
        student.setSsex("F");
        studentService.update(student);
        log.info("修改成功！"+student);
        return "修改成功!";
    }

    @GetMapping("/delete")
    String deleteStudentBySno(){
        studentService.deleteStudentBySno("001");
        log.error("删除！"+"001");
        return "删除成功！";
    }

    @GetMapping("/query")
    Student queryStudentBySno(){
        Student student = studentService.queryStudentBySno("001");
        log.error("查询！"+student);
        return student;
    }
}
