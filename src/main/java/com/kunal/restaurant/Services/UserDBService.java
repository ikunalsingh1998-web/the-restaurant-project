package com.kunal.restaurant.Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kunal.restaurant.Entity.UserSaveEntity;
import com.kunal.restaurant.Exceptions.ServiceException;
import com.kunal.restaurant.Models.UserModel;
import com.kunal.restaurant.Repository.UserSaveRepository;

@Service
public class UserDBService {
	private static final String USER_DETAILS_KEY = "User_Details_Required";
	@SuppressWarnings("rawtypes")
	@Autowired
	RedisService redisService;
	@Autowired
	private UserSaveRepository userSaveRepository;

	public UserSaveEntity saveUserDetails(UserSaveEntity userSaveEntity) throws SQLException {

		try {
			return userSaveRepository.save(userSaveEntity);
		} catch (Exception e) {
			throw new ServiceException("Unable to save user details!!");
		}

	}

	@SuppressWarnings("unchecked")
	public List<UserModel> fetchAllUserDetails() throws SQLException {
		List<UserModel> users = new ArrayList<UserModel>();
		try {
			List<UserSaveEntity> userList = userSaveRepository.findAll();
			TypeReference<List<UserModel>> typeReference = new TypeReference<List<UserModel>>() {
			};
			List<UserModel> usersCache = redisService.getFromRedis(USER_DETAILS_KEY, typeReference);
			if (null != usersCache) {
				System.out.println("UserDetails Returned from Redis Cache!!");
				return usersCache;
			} else {
				userList.forEach(user -> {
					UserModel userDetails = new UserModel();
					userDetails.setClientId(user.getClientId());
					userDetails.setClientName(user.getClientName());
					userDetails.setClientMobileNumber(user.getClientMobileNumber());
					userDetails.setClientEmail(user.getClientEmailId());
					userDetails.setClientPassword(user.getClientPassword());
					users.add(userDetails);
				});
				if (null != users) {
					redisService.saveToRedis(USER_DETAILS_KEY, users, 300l);
				}
				System.out.println("UserDetails Returned from Database!!");
				return users;
			}
		} catch (Exception e) {
			throw new ServiceException("Unable to fetch UserDetails!!");
		}
	}

}
