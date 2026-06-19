package com.kunal.restaurant.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunal.restaurant.Entity.UserSaveEntity;
import com.kunal.restaurant.Exceptions.ServiceException;
import com.kunal.restaurant.Repository.UserSaveRepository;

@Service
public class UserService {
	
	@Autowired
	private UserSaveRepository userSaveRepository;
	
	public UserSaveEntity saveUsers(UserSaveEntity userSaveEntity){
		try {
			return userSaveRepository.save(userSaveEntity);
		} catch (Exception e) {
			throw new ServiceException("Unable to save user details!!");
		}

	}

}
