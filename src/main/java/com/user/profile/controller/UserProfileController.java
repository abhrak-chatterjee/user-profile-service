package com.user.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.profile.constants.IConstants;
import com.user.profile.model.UserProfileCriteria;
import com.user.profile.model.UserProfileModel;
import com.user.profile.service.UserProfileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@Api(value = "This API is created for User API Specs!")
@CrossOrigin
public class UserProfileController {

	@Autowired
	private UserProfileService service;

	/**
	 * This method is used for getting the Reason Codes by Criteria!
	 * 
	 * @param criteria
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value = "/api-service/users/v1/criteria", produces = "application/json")
	@ApiOperation(httpMethod = "POST", value = "This method is used for getting the Users by Specified Criteria! ", produces = "application/json", response = UserProfileModel.class)
	public ResponseEntity getUsersByCriteria(@RequestBody(required = true) UserProfileCriteria criteria) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getUserProfileByCriteria(criteria), HttpStatus.OK);

		} catch (Exception e) {
			log.info(IConstants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			response = new ResponseEntity(IConstants.EXCEPTION_OCCURED_WHILE_PROCESSING, HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response;
	}

	/**
	 * This method is used for getting the Reason Codes by Criteria!
	 * 
	 * @param criteria
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value = "/api-service/users/v1/save", produces = "application/json")
	@ApiOperation(httpMethod = "POST", value = "This method is used for persisting the Reason Code!.", produces = "application/json", response = UserProfileModel.class)
	public ResponseEntity saveUser(@RequestBody(required = true) UserProfileModel model) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.saveUserProfile(model), HttpStatus.OK);

		} catch (Exception e) {
			log.info(IConstants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			response = new ResponseEntity(IConstants.EXCEPTION_OCCURED_WHILE_PROCESSING, HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response;
	}

}
