package com.busbooking.service;

import com.busbooking.model.User;

public interface UserManager {

	User createUser();
	boolean deleteUser(User user);
}
