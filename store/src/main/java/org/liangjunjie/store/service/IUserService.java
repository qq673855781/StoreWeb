package org.liangjunjie.store.service;

import org.liangjunjie.store.entity.User;
import org.liangjunjie.store.service.ex.InsertException;
import org.liangjunjie.store.service.ex.UsernameDuplicateException;

public interface IUserService {
	void reg(User user) throws UsernameDuplicateException, InsertException;

}
