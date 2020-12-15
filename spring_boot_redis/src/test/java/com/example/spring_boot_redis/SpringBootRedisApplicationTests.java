package com.example.spring_boot_redis;

import com.example.spring_boot_redis.bean.Student;

import com.example.spring_boot_redis.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableCaching
class SpringBootRedisApplicationTests {
	@Autowired
	private StudentService studentService;
	@Resource
	private RedisTemplate<String,Object> redisTemplate;

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
		System.out.println(student.getSname() + "  " + student.getSno() + "   " +
				student.getSsex());
	}
	@Test
	void test4(){
		redisTemplate.opsForValue().set("myKey","myValue");
		System.out.println(redisTemplate.opsForValue().get("myKey"));
	}

}
