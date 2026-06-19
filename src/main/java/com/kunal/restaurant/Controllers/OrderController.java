package com.kunal.restaurant.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunal.restaurant.Constants.StatusConstants;
import com.kunal.restaurant.Constants.URLConstants;
import com.kunal.restaurant.Entity.OrderEntity;
import com.kunal.restaurant.Entity.UserSaveEntity;
import com.kunal.restaurant.Models.ResponseObject;
import com.kunal.restaurant.Models.UserModel;
import com.kunal.restaurant.Services.OrderService;
import com.kunal.restaurant.Services.UserDBService;

@RestController
public class OrderController {
	
	@Autowired
	private UserDBService userDBService;
	@Autowired
	OrderService orderService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value =URLConstants.SAVE_USER_DETAILS_ENDPOINT, method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseObject> getUserDetails(@RequestBody UserSaveEntity userSaveEntity) throws Exception{
		ResponseObject userResponseObject = new ResponseObject();
		UserSaveEntity savedUserDetails = userDBService.saveUserDetails(userSaveEntity);
		userResponseObject.setStatusCode(String.valueOf(StatusConstants.STATUS_CODE_INTEGER_SUCCESS));
		userResponseObject.setMessage(StatusConstants.MESSAGE_SUCCESS);
		userResponseObject.setResponsePayload(savedUserDetails);
		return new ResponseEntity<>(userResponseObject, HttpStatus.OK );
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value =URLConstants.SAVE_ORDER_DETAILS_ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<ResponseObject> getUserDetails(@RequestBody OrderEntity orderEntity) throws Exception{
		ResponseObject orderResponseObject = new ResponseObject();
		OrderEntity savedOrders = orderService.saveOrders(orderEntity);
		orderResponseObject.setStatusCode(String.valueOf(StatusConstants.STATUS_CODE_INTEGER_SUCCESS));
		orderResponseObject.setMessage(StatusConstants.MESSAGE_SUCCESS);
		orderResponseObject.setResponsePayload(savedOrders);
		return new ResponseEntity<>(orderResponseObject, HttpStatus.OK );
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value =URLConstants.GET_ALL_USER_DETAILS_ENDPOINT, method = RequestMethod.GET)
	public ResponseEntity<ResponseObject> fetchAllUserDetails() throws Exception{
		ResponseObject orderResponseObject = new ResponseObject();
		List<UserModel> allUsers = userDBService.fetchAllUserDetails();
		orderResponseObject.setStatusCode(String.valueOf(StatusConstants.STATUS_CODE_INTEGER_SUCCESS));
		orderResponseObject.setMessage(StatusConstants.MESSAGE_SUCCESS);
		orderResponseObject.setResponsePayload(allUsers);
		return new ResponseEntity<>(orderResponseObject, HttpStatus.OK );
		
	}

}
