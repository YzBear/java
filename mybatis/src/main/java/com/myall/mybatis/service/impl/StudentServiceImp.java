package com.myall.mybatis.service.impl;


import com.myall.mybatis.bean.Student;
import com.myall.mybatis.dao.StudentMapper;
import com.myall.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return this.studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public int deleteBysno(String sno) {
        return this.studentMapper.deleteBysno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentMapper.queryStudentBySno(sno);
    }
}
