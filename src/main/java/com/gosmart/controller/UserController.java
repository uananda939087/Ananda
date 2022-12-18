package com.gosmart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constants.UserConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.entity.UserEntity;
import com.gosmart.service.UserService;

import lombok.extern.slf4j.Slf4j;
/**
 * <h1>UserController</h1>
 * @author Ananda
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/save")
	public ResponseEntity<Integer> insertUser(@RequestBody UserEntity userEntity)
	{
		log.info("{}-UserController insertUser() started",UserConstants.USER);
		try 
		{
			
						
			log.info("{}-UserController insertUser() saving userDetails in repository",UserConstants.USER);
			
			Integer userId=userService.insertUser(userEntity);
			return new ResponseEntity<>(userId,HttpStatus.CREATED);
		} 
		catch (Exception e) 
		{
			log.error("{}-UserController insertUser() exception occured-{}",UserConstants.USER,e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<UserEntity> getUser(@RequestBody UserEntity userEntity)
	{
		log.info("{}-UserController getUser() started",UserConstants.USER);
		try {
			
						
			log.info("{}-UserController getUser() saving userDetails in repository",UserConstants.USER);
			
			UserEntity user=userService.getUser(userEntity.getEmailId(), userEntity.getPassword());
			return new ResponseEntity<>(user,HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			log.error("{}-UserController getUser() exception occured-{}",UserConstants.USER,e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<UserEntity> getUserId(@PathVariable Integer userId)
	{
		log.info("{}-UserController getUser() started",UserConstants.USER);
		try 
		{
			log.info("{}-UserController getUser() saving userDetails in repository",UserConstants.USER);
			Optional<UserEntity> entity=userService.getUsers(userId);
			return new ResponseEntity<UserEntity>(HttpStatus.OK);
		}
		catch (Exception e) 
		{
			log.error("{}-UserController getUser() exception occured-{}",UserConstants.USER,e.getMessage());
			throw new GoSmartException(e.getMessage());

		}
	}
}
