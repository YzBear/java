package com.example.spring_boot_redis.service;


import com.example.spring_boot_redis.bean.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "student")
public interface StudentService {
	@CachePut(key = "#p0.sno")
	Student update(Student student);

	@CacheEvict(key = "#p0", allEntries = false)
	void deleteStudentBySno(String sno);
	
	@Cacheable(key = "#p0")
	Student queryStudentBySno(String sno);
}
