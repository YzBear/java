package com.example.spring_boot_mybatisplus;

import com.example.spring_boot_mybatisplus.dao.UserDao;
import com.example.spring_boot_mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBootMybatisplusApplicationTests {
	@Resource
	UserDao userDao;
	// 测试乐观锁成功！
	@Test
	public void testOptimisticLocker(){
		// 1、查询用户信息
		User user = userDao.selectById(1L);
		// 2、修改用户信息
		user.setName("kwhua");
		user.setEmail("123456@qq.com");
		// 3、执行更新操作
		userDao.updateById(user);
	}
	@Test
	public void testOptimisticLocker2(){

		// 线程 1
		User user = userDao.selectById(1L);
		user.setName("kwhua111");
		user.setEmail("123456@qq.com");

		// 模拟另外一个线程执行了插队操作
		User user2 = userDao.selectById(1L);
		user2.setName("kwhua222");
		user2.setEmail("123456@qq.com");
		userDao.updateById(user2);

		// 自旋锁来多次尝试提交！
		userDao.updateById(user); // 如果没有乐观锁就会覆盖插队线程的值！
	}
	@Test
	void contextLoads() {
		userDao.deleteById(1L);
	}
	@Test
	void queryAll() {
		List<User> users = userDao.selectList(null);
		System.out.println(users);

	}
}
