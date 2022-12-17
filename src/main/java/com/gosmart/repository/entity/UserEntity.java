package com.gosmart.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/**
 * <h2>UserEntity</h2>
 * This entity class maps to  USER_ENTITY
 * @author Ananda
 * @version 1.0
 * @since 2022/12/17
 */
@Entity
@Table(name="USER_ENTITY")
@Data
public class UserEntity {
	//primary key
	@Id
	@Column(name="USER_ID")
	private Integer userId;
	//name of the user
	@Column(name="NAME")
	private String name;
	//emailId of the user
	@Column(name="EMAIL_ID")
	private String emailId;
	//password of the user
	@Column(name="PASSWORD")
	private String password;
	//mobileNumer of the user
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	//countryCode of the user
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	//userTpe of the user
	@Column(name="USER_TYPE")
	private String userType;
	

}
