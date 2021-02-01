package com.example.spring_boot_redis;

import com.example.spring_boot_redis.bean.Student;

import com.example.spring_boot_redis.service.StudentService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;

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
	@Test
	void test5(){
		String path = "src/main/resources/file.txt";
		File file = new File(path);
		String path1 = file.getPath();
		System.out.println(path.equals(path1));
	}
	@Test
	void test6() throws IOException {
		FileOutputStream fos = new FileOutputStream("D:/abc.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");

		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("姓名", "年龄", "家乡");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

//        csvPrinter = CSVFormat.DEFAULT.withHeader("姓名", "年龄", "家乡").print(osw);

		for (int i = 0; i < 10; i++) {
			csvPrinter.printRecord("张三", 20, "湖北");
		}

		csvPrinter.flush();
		csvPrinter.close();
	}

}
