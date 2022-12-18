package com.gosmart.service;

import java.util.Optional;

import com.gosmart.repository.entity.UserEntity;
/**
 * <h1>UserService</h1>
 * @author Ananda
 *
 */
public interface UserService 
{
	public Integer insertUser(UserEntity userEntity);
	public UserEntity getUser(String emailId,String password);
	public Optional<UserEntity> getUsers(Integer UserId);
}
