package com.user.profile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.user.profile.constants.IConstants;
import com.user.profile.model.UserProfileCriteria;
import com.user.profile.model.UserProfileModel;
import com.user.profile.repository.UserProfileRepository;
import com.user.profile.service.UserProfileService;
import com.user.profile.util.CommonUtil;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileRepository repository;

	/**
	 * Method used for Saving the Service Configuration Document!.
	 */
	@Override
	public UserProfileModel saveUserProfile(UserProfileModel model) throws Exception {
		try {
			model = repository.save(prepareObject(model));
		} catch (Exception e) {
			log.info(IConstants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return model;
	}

	/**
	 * Method used for searching the profile by criteria!.
	 */
	@Override
	public List<UserProfileModel> getUserProfileByCriteria(UserProfileCriteria criteria) throws Exception {
		List<UserProfileModel> list = null;
		try {
			list = repository.findByCriteria(criteria);
		} catch (Exception e) {
			log.info(IConstants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return list;
	}

	/**
	 * Method used for preparing the Object!.
	 * 
	 * @param model
	 * @return
	 */
	private UserProfileModel prepareObject(UserProfileModel model) {
		if (!StringUtils.isEmpty(model.getUserId())) {
			model.setUpdatedDate(CommonUtil.getCurrentDateInString());
			model.setUpdatedBy(IConstants.USER_PROFILE_SERVICE);
		} else {
			model.setCreatedDate(CommonUtil.getCurrentDateInString());
			model.setCreatedBy(IConstants.USER_PROFILE_SERVICE);
		}
		return model;
	}

}
