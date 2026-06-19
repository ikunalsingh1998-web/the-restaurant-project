package com.kunal.restaurant.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.kunal.restaurant.Models.ResponseObject;

@ControllerAdvice
public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super();
	}

	public ServiceException(String exceptionMsg) {
		super(exceptionMsg);
	}
	

    public ServiceException(String exceptionMsg, Throwable cause) {
        super(exceptionMsg, cause);
    }
	
	/**
	 * Method to handle exception
	 * 
	 * @param respObject type ResponseObject
	 * @param e                  type Exception
	 * @return type ResponseObject
	 */
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseObject> handleExpeption(ResponseObject respObject,
			Throwable e) {
		//if (null != e.getMessage() && e.getMessage().contains(MessageConstants.MESSAGE_NO_CONTENT_FOUND) || ((ApiException)e).getErrMsg().contains(MessageConstants.MESSAGE_NO_CONTENT_FOUND)) {
			//resObjectListParty
			//		.setStatusCode(propertyManager.getProperty(MessageConstants.STATUS_CODE_SUCCESS_NO_CONTENT_KEY));
		//	resObjectListParty.setMessage(MessageConstants.MESSAGE_NO_CONTENT_FOUND);
		//	resObjectListParty.setResponsePayload(null);
		//	return new ResponseEntity<>(resObjectListParty, HttpStatus.OK);
		//} else {
			//resObjectListParty.setStatusCode(propertyManager.getProperty(MessageConstants.STATUS_CODE_FAILURE));
		//	resObjectListParty.setMessage(e.getMessage());
		//	resObjectListParty.setResponsePayload(null);
			return new ResponseEntity<>(respObject, HttpStatus.OK);
	}

}
