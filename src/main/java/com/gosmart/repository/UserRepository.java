package com.gosmart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.UserEntity;
/**
 * <h1>UserRepository</h1>
 * This is for the maps to USER_REPOSITORY
 * @author Ananda
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	public UserEntity findByEmailIdAndPassword(String emailId,String password);
	public Optional<UserEntity> getUsers(Integer UserId);
}
