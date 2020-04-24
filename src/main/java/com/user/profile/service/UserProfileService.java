package com.user.profile.service;

import java.util.List;

import com.user.profile.model.UserProfileCriteria;
import com.user.profile.model.UserProfileModel;

public interface UserProfileService {

	public UserProfileModel saveUserProfile(UserProfileModel model) throws Exception;
	public List<UserProfileModel> getUserProfileByCriteria(UserProfileCriteria criteria) throws Exception;
}
