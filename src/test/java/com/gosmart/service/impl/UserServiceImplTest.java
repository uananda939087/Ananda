package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import javax.annotation.meta.When;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.UserRepository;
import com.gosmart.repository.entity.UserEntity;

import jakarta.annotation.security.RunAs;

@RunWith(SpringJUnit4ClassRunner.class)

public class UserServiceImplTest
{
	@InjectMocks
	private UserServiceImpl service;
	@Mock
	private UserRepository repository;
	@Test
	public void testInsertUser() throws Exception
	{
		
		UserEntity userEntity=new UserEntity();
		UserEntity userEntity2=Mockito.any();
		when(repository.save(userEntity)).thenReturn(userEntity2);
		Integer userId=service.insertUser(userEntity);
		assertNotNull(userId);		
	}
	@Test(expected = GoSmartException.class)
	public void testInsertUser_Exception() throws Exception
	{
		UserEntity userEntity=new UserEntity();		
		when(repository.save(userEntity)).thenThrow(NullPointerException.class);
		service.insertUser(userEntity);				
	}
	@Test
	public void testGetUser()throws Exception
	{
		String emailId="emailId";
		String password="password";
		UserEntity userEntity=new UserEntity();
		when(repository.findByEmailIdAndPassword(emailId, password)).thenReturn(userEntity);
		UserEntity entity=service.getUser(emailId, password);
		assertNotNull(entity);		
	}
	@Test(expected = GoSmartException.class)
	public void testGetUser_Exception() throws Exception
	{
		String emailId="emailId";
		String password="password";
		when(repository.findByEmailIdAndPassword(emailId, password)).thenThrow(NullPointerException.class);
		service.getUser(emailId, password);
	}
}
