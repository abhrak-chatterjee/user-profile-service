package com.user.profile.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@ToString
@JsonInclude(value = Include.NON_NULL)
public class UserProfileCriteria implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Integer status;

}
