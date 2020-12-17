package com.example.demo.oracledao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OracleStudentMapper {
	List<Map<String, Object>> getAllStudents();
}

