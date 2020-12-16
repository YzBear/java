package com.example.springbootlog.service;


import com.example.springbootlog.bean.Student;

public interface StudentService {

	Student update(Student student);


	void deleteStudentBySno(String sno);
	

	Student queryStudentBySno(String sno);
}
