package com.myall.mybatis.service;


import com.myall.mybatis.bean.Student;

public interface StudentService {
    int add(Student student);

    int update(Student student);

    int deleteBysno(String sno);

    Student queryStudentBySno(String sno);
}
