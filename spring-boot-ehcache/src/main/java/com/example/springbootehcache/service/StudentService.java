package com.example.springbootehcache.service;



import com.example.springbootehcache.bean.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = {"students"})
public interface StudentService {
	@CachePut( value = "students",key = "#p0.sno")
	Student update(Student student);

	@CacheEvict(value = "students",key = "#p0")
	void deleteStudentBySno(String sno);

	@Cacheable(value = "students",key = "#p0")
	Student queryStudentBySno(String sno);
}
