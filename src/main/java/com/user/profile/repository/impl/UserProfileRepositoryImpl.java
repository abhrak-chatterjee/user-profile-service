package com.user.profile.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.user.profile.constants.IConstants;
import com.user.profile.model.UserProfileCriteria;
import com.user.profile.model.UserProfileModel;
import com.user.profile.repository.UserProfileRepositoryCriteria;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class UserProfileRepositoryImpl implements UserProfileRepositoryCriteria {

	@Autowired
	private MongoTemplate repository;

	@Override
	public List<UserProfileModel> findByCriteria(UserProfileCriteria criteria) throws Exception {
		List<UserProfileModel> list = null;
		try {
			list = repository.find(getWhereClause(criteria), UserProfileModel.class);
		} catch (Exception e) {
			log.info(IConstants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return list;
	}

	/**
	 * Method used for Preparing the Where Clause
	 * 
	 * @param criteria
	 * @param builder
	 * @param model
	 * @return
	 */
	private Query getWhereClause(UserProfileCriteria criteria) {
		Query whereClause = new Query();
		if (!StringUtils.isEmpty(criteria.getFirstName())) {
			whereClause.addCriteria(Criteria.where(IConstants.FIRST_NAME).is(criteria.getFirstName()));
		}
		if (!StringUtils.isEmpty(criteria.getLastName())) {
			whereClause.addCriteria(Criteria.where(IConstants.LAST_NAME).is(criteria.getLastName()));
		}
		if (!StringUtils.isEmpty(criteria.getUserId())) {
			whereClause.addCriteria(Criteria.where(IConstants.USER_ID).is(criteria.getUserId()));
		}
		if (criteria.getStatus() != null && criteria.getStatus() > 0) {
			whereClause.addCriteria(Criteria.where(IConstants.STATUS).is(criteria.getStatus()));
		}
		return whereClause;
	}

}
