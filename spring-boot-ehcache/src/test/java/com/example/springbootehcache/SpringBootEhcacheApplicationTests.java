package com.example.springbootehcache;

import com.example.springbootehcache.bean.Student;
import com.example.springbootehcache.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableCaching
class SpringBootEhcacheApplicationTests {
	@Autowired
	private StudentService studentService;

	@Test
	void contextLoads() {
		Student student = new Student();
		student.setSname("李wu");
		student.setSno("003");
		student.setSsex("F");
		studentService.update(student);

	}
	@Test
	void test2(){
		studentService.deleteStudentBySno("002");
	}
	@Test
	void test3(){
		Student student = studentService.queryStudentBySno("003");
		System.out.println(student.getSname() + "  "
				+ student.getSno() + "   "
				+ student.getSsex());
	}

}
