package org.liangjunjie.store.mappers;

import org.liangjunjie.store.entity.User;

public interface UserMapper {
	Integer insert(User user);
	User findByUsername(String username);
}
