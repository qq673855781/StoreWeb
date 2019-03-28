package org.liangjunjie.store.controller;

import org.liangjunjie.store.entity.User;
import org.liangjunjie.store.service.IUserService;
import org.liangjunjie.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("users")
@RestController
public class UserController extends BaseController{
	@Autowired
	public IUserService userService;
	@RequestMapping("reg")
	public ResponseResult<Void> reg(User user){
		userService.reg(user);
		//会直接在网页中显示对象
		return new ResponseResult<Void>(SUCCESS);
	}
}
