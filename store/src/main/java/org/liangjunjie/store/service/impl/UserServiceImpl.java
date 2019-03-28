package org.liangjunjie.store.service.impl;

import java.util.Date;
import java.util.UUID;

import org.liangjunjie.store.entity.User;
import org.liangjunjie.store.mappers.UserMapper;
import org.liangjunjie.store.service.IUserService;
import org.liangjunjie.store.service.ex.InsertException;
import org.liangjunjie.store.service.ex.UsernameDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 将密码执行加密
	 * @param password 原密码
	 * @param salt 盐值
	 * @return 加密后的结果
	 */
	private String getMd5Password(String password, String salt) {
		// 拼接原密码与盐值
		String str = salt + password + salt;
		// 循环加密5次
		for (int i = 0; i < 5; i++) {
			str = DigestUtils.md5DigestAsHex(
					str.getBytes()).toUpperCase();
		}
		// 返回结果
		return str;
	}

	@Override
	public void reg(User user) throws UsernameDuplicateException, InsertException {
		User result = 
				userMapper.findByUsername(
					user.getUsername());
		// 判断查询结果是否为null
		if (result == null) {
			// 是：允许注册
			// 执行注册
			user.setIsDelete(0);
			Date now = new Date();
			user.setCreatedUser(user.getUsername());
			user.setCreatedTime(now);
			user.setModifiedTime(now);
			user.setModifiedUser(user.getUsername());
			String salt = UUID.randomUUID().toString().toUpperCase();
			String md5Password = getMd5Password(user.getPassword(), salt);
			user.setSalt(salt);
			user.setPassword(md5Password);
			Integer rows = userMapper.insert(user);
			if (rows != 1) {
				throw new InsertException("注册时发生未知错误，请联系系统管理员！");
			}
		} else {
			// 否：不允许注册，抛出异常
			throw new UsernameDuplicateException("尝试注册的用户名(" + user.getUsername() + ")已经被占用！");
		}
	}
}
