package com.example.springbootlog.service.impl;


import com.example.springbootlog.bean.Student;
import com.example.springbootlog.mapper.StudentMapper;
import com.example.springbootlog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public Student update(Student student) {
		this.studentMapper.update(student);
		return this.studentMapper.queryStudentBySno(student.getSno());
	}

	@Override
	public void deleteStudentBySno(String sno) {
		this.studentMapper.deleteStudentBySno(sno);
	}

	@Override
	public Student queryStudentBySno(String sno) {
		return this.studentMapper.queryStudentBySno(sno);
	}

}
