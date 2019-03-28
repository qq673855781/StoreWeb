package org.liangjunjie.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liangjunjie.store.entity.User;
import org.liangjunjie.store.service.IUserService;
import org.liangjunjie.store.service.ex.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {
	@Autowired
	public IUserService service;

	@Test
	public void reg() {
		try {
			User user = new User();
			user.setUsername("spring");
			user.setPassword("8888");
			service.reg(user);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
		}
	}
}
