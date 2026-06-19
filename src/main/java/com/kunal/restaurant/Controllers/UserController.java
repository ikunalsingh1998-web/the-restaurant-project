package com.kunal.restaurant.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunal.restaurant.Constants.StatusConstants;
import com.kunal.restaurant.Constants.URLConstants;
import com.kunal.restaurant.Entity.UserSaveEntity;
import com.kunal.restaurant.Models.ResponseObject;
import com.kunal.restaurant.Services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value =URLConstants.USER_REGISTRATION_ENDPOINT, method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseObject> getUserDetails(@RequestBody UserSaveEntity userSaveEntity) throws Exception{
		ResponseObject userResponseObject = new ResponseObject();
		UserSaveEntity savedUserDetails = userService.saveUsers(userSaveEntity);
		userResponseObject.setStatusCode(String.valueOf(StatusConstants.STATUS_CODE_INTEGER_SUCCESS));
		userResponseObject.setMessage(StatusConstants.MESSAGE_SUCCESS);
		userResponseObject.setResponsePayload(savedUserDetails);
		return new ResponseEntity<>(userResponseObject, HttpStatus.OK );
		
	}

}
