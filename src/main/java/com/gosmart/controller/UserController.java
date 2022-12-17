package com.gosmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constants.UserConstants;
import com.gosmart.repository.entity.UserEntity;
import com.gosmart.service.UserService;

import lombok.extern.slf4j.Slf4j;

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
		try {
			
						
			log.info("{}-UserController insertUser() saving userDetails in repository",UserConstants.USER);
			
			Integer userId=userService.insertUser(userEntity);
			return new ResponseEntity(userId,HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("{}-UserController insertUser() exception occured-{}",UserConstants.USER,e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
