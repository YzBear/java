package com.example.spring_boot_redis.mapper;


import com.example.spring_boot_redis.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;

@Mapper
@CacheConfig(cacheNames = "student")
public interface StudentMapper {

	@Update("update student set sname=#{sname},ssex=#{ssex} where sno=#{sno}")
	int update(Student student);

	@Delete("delete from student where sno=#{sno}")
	void deleteStudentBySno(String sno);

	@Select("select * from student where sno=#{sno}")
	@Results(id = "student", value = { @Result(property = "sno", column = "sno", javaType = String.class),
			@Result(property = "sname", column = "sname", javaType = String.class),
			@Result(property = "ssex", column = "ssex", javaType = String.class) })
	Student queryStudentBySno(String sno);
}
