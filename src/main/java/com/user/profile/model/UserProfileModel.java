package com.user.profile.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Document(value = "user_profile")
@JsonInclude(value = Include.NON_NULL)
@ToString
@NoArgsConstructor
public class UserProfileModel implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	private String userId;
	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String lastName;
	@Getter
	@Setter
	private String createdBy;
	@Getter
	@Setter
	private String createdDate;
	@Getter
	@Setter
	private String updatedDate;
	@Getter
	@Setter
	private String updatedBy;
	@Getter
	@Setter
	private Integer status;
}
