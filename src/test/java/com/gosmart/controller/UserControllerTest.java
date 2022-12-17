package com.gosmart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.repository.UserRepository;
import com.gosmart.repository.entity.UserEntity;
import com.gosmart.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest
{
	@InjectMocks
	private UserController userController;
	@Mock
	private UserService userService;
	@Test
	public void testInsertUser() throws Exception
	{
		UserEntity userEntity=new UserEntity();
		Integer userId=1;
		when(userService.insertUser(userEntity)).thenReturn(userId);
		ResponseEntity<Integer>	response=userController.insertUser(userEntity);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testInsertUser_Exception() throws Exception
	{
		UserEntity userEntity=new UserEntity();
		when(userService.insertUser(userEntity)).thenThrow(NullPointerException.class);
		ResponseEntity<Integer>	response=userController.insertUser(userEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
}
