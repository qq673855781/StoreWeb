package org.liangjunjie.store.controller;

import org.liangjunjie.store.service.ex.InsertException;
import org.liangjunjie.store.service.ex.ServiceException;
import org.liangjunjie.store.service.ex.UsernameDuplicateException;
import org.liangjunjie.store.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {
	protected static final int SUCCESS = 200;
	/**
	 * 响应结果时用于表示操作成功
	 */

	@ExceptionHandler(ServiceException.class)
	public ResponseResult<Void> handleException(ServiceException e) {
		ResponseResult<Void> rr
			= new ResponseResult<>();
		rr.setMessage(e.getMessage());
		
		if (e instanceof UsernameDuplicateException) {
			// 400-用户名冲突异常
			rr.setState(400);
		} else if (e instanceof InsertException) {
			// 500-插入数据异常
			rr.setState(500);
		}
		
		return rr;
	}
}
