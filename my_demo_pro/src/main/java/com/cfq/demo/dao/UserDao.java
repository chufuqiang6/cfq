package com.cfq.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cfq.demo.entity.User;

public interface UserDao {

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);
	
	User getUser(@Param("user") User user);
	
	User selectByUsername(String username);

	int updateByPrimaryKeySelective(User record);
	
	public int insertUserByBunch(List<User> userList);

	int updateByPrimaryKey(User record);

	List<User> getAllUser();
}