package com.gosmart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.UserConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.UserRepository;
import com.gosmart.repository.entity.UserEntity;
import com.gosmart.service.UserService;

import lombok.extern.slf4j.Slf4j;
/**
 * <h1>UserServiceImpl</h1>
 * @author AKHM SOLUTION
 *
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService
{	
	@Autowired
	private  UserRepository userRepository;
	/**
	 * This method is used for the insertUser
	 * @param userEntity This is the parameter to insertUser()
	 * @return Integer This returns userId
	 * 
	 */
	@Override
	public Integer insertUser(UserEntity userEntity)
	{
		Integer userId=0;
		log.info("{}-ServiceImpl insertUser() started",UserConstants.USER);
		
		try 
		{
			log.info("{}-ServiceImpl insertUser() saving userDetails in repository",UserConstants.USER);
			
			if(userEntity!=null)
			{
				UserEntity userEntity2=userRepository.save(userEntity);
				log.info("{}-ServiceImpl insertUser() saved userDetails in repository",UserConstants.USER);
				if(userEntity2!=null)
				{
					userId=userEntity2.getUserId();
					log.info("{}-ServiceImpl insertUser() userId is-{}",UserConstants.USER,userId);
				}
			}
			
		} 
		catch (Exception e) 
		{
			log.error("{}-Serviceimpl insertUser() exception occured-{}",UserConstants.USER,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return userId;
	}
	@Override
	public UserEntity getUser(String emailId, String password)
	{
		log.info("{}-ServiceImpl getUser() saving userDetails in repository",UserConstants.USER);
		UserEntity userEntity=null;
		try 
		{
			log.info("{}-ServiceImpl getUser() saving userDetails in repository",UserConstants.USER);
			userEntity=userRepository.findByEmailIdAndPassword(emailId, password);
		} 
		catch (Exception e)
		{
			log.error("{}-Serviceimpl getUser() exception occured-{}",UserConstants.USER,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return userEntity;
	}
	@Override
	public UserEntity getUsers(Integer UserId)
	{
		log.info("{}-ServiceImpl getUsers() saving userDetails in repository",UserConstants.USER);
		
		UserEntity userEntity=null;
		try {
			log.info("{}-ServiceImpl getUsers() saving userDetails in repository",UserConstants.USER);
			userEntity=userRepository.findByUserId(UserId);
		} catch (Exception e) {
			log.error("{}-Serviceimpl getUsers() exception occured-{}",UserConstants.USER,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return userEntity;
	}					
}
