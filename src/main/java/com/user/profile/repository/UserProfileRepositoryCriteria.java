package com.user.profile.repository;

import java.util.List;

import com.user.profile.model.UserProfileCriteria;
import com.user.profile.model.UserProfileModel;

@FunctionalInterface
public interface UserProfileRepositoryCriteria {

	public List<UserProfileModel> findByCriteria(UserProfileCriteria criteria)
			throws Exception;
}
