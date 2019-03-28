package org.liangjunjie.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liangjunjie.store.entity.User;
import org.liangjunjie.store.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConnection {
	@Autowired
	public UserMapper mapper;
	
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("root1111");
		user.setPassword("1234");
		Integer rows = mapper.insert(user);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByUsername() {
		String username = "root";
		User user = mapper.findByUsername(username);
		System.err.println(user);
	}
}
