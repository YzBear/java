package com.example.springbootswagger.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelAnalysisStopException;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.example.springbootswagger.domain.User;
import com.example.springbootswagger.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@Api(value = "用户Controller")
@Controller
@RequestMapping("user")
public class UserController {

	@ApiIgnore
	@GetMapping("hello")
	public @ResponseBody String hello() {
		return "hello2";
	}

	@ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
	@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
	@GetMapping("/{id}")
	public @ResponseBody
	User getUserById(@PathVariable(value = "id") Long id) {
		User user = new User();
		user.setId(id);
		user.setName("mrbird");
		user.setAge(25);
		return user;
	}

	@ApiOperation(value = "获取用户列表", notes = "获取用户列表")
	@GetMapping("/list")
	public @ResponseBody List<User> getUserList() {
		List<User> list = new ArrayList<>();
		User user1 = new User();
		user1.setId(1l);
		user1.setName("mrbird");
		user1.setAge(25);
		list.add(user1);
		User user2 = new User();
		user2.setId(2l);
		user2.setName("scott");
		user2.setAge(29);
		list.add(user2);
		return list;
	}

	@ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
	@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
	@PostMapping("/add")
	public @ResponseBody Map<String, Object> addUser(@RequestBody User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}

	@ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
	@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
	@DeleteMapping("/{id}")
	public @ResponseBody Map<String, Object> deleteUser(@PathVariable(value = "id") Long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}

	@ApiOperation(value = "更新用户", notes = "根据用户id更新用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path"),
			@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User") })
	@PutMapping("/{id}")
	public @ResponseBody Map<String, Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	@ApiOperation(value = "文件导入", notes = "excel导入")
	@PostMapping("/upload")
	public @ResponseBody void upload(MultipartFile multipartFile){
		List<User> read = new ArrayList<>();
		InputStream inputStream = null ;
		File file = null;
		try {
			 inputStream = multipartFile.getInputStream();
			file =  new File(multipartFile.getOriginalFilename());
			ExcelUtil.inputStreamToFile(inputStream,file);
		} catch (IOException e) {
			e.printStackTrace();
		}


		  EasyExcel.read(file,User.class, new AnalysisEventListener<User>() {
			 int count = 0;
			 @Override
			 public void onException(Exception exception, AnalysisContext context)  {
				 System.out.println("解析失败，但是继续解析下一行:{}"+exception.getMessage());
				 // 如果是某一个单元格的转换异常 能获取到具体行号
				 // 如果要获取头的信息 配合invokeHeadMap使用
				 if (exception instanceof ExcelDataConvertException) {
					 ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException)exception;
					 System.out.println("第{}行，第{}列解析异常"+excelDataConvertException.getRowIndex()+
							 excelDataConvertException.getColumnIndex());
				 }
				 //不抛出异常则继续执行下一条
				/* throw new ExcelAnalysisStopException("出错行："+exception.toString()+", 出错列："+context.toString());*/
			 }

			 @Override
			public void invoke(User user, AnalysisContext analysisContext) {
				System.out.println(user);
				read.add(user);
			}

			@Override
			public void doAfterAllAnalysed(AnalysisContext analysisContext) {

			}
		}).doReadAll();

		System.out.println(read);

	}


	@ApiOperation(value = "导入用户模板下载", notes = "导入用户模板下载",produces = "application/octet-stream")
	@GetMapping("/downTemplate")
	public @ResponseBody void downloadTemplate(HttpServletResponse response){
		String fileName = "导入用户模板";
		String sheetName =  "导入用户模板";
		List<User> list = new ArrayList<>();
		list.add(new User(12L,"李四",20));
		try {
			ExcelUtil.writeExcel(response,list,fileName,sheetName,User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ApiOperation(value = "用户列表",notes = "export", produces = "application/octet-stream")
	@GetMapping("/exportExcel")
	public @ResponseBody void exportExcel(HttpServletResponse response){
		String fileName = "用户列表";
		String sheetName = "用户列表";
		List<User> list = new ArrayList<>();
		list.add(new User(12L,"李四",20));
		list.add(new User(13L,"李3",20));
		list.add(new User(14L,"李2",20));
		list.add(new User(15L,"李1",20));
		try {
			ExcelUtil.writeExcel(response,list,fileName,sheetName,User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
