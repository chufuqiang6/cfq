package com.cfq.demo.service;

import java.util.List;

import com.cfq.demo.entity.User;
public interface UserService {

//	public int insertUser(User user);
//
//	public int deleteUserById(String id);
//
//	public int updateUser(User user);
	public int insertUserByBunch(List<User> userList);
	
    public User getUserById(String id); 
   
	public User getUser(User user);

	public User getUserByUsername(String username);

	public List<User> getAllUser();

}
