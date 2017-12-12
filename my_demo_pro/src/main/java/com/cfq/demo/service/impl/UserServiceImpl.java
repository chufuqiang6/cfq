package com.cfq.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cfq.demo.dao.UserDao;
import com.cfq.demo.entity.User;
import com.cfq.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	// public int insertUser(User user) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// public int deleteUserById(String id) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// public int updateUser(User user) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	 public User getUserById(String id) {
	    // TODO Auto-generated method stub
	    return userDao.selectByPrimaryKey(id);
	 }
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}
    
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(username);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> userList=userDao.getAllUser();
		return userList;
	}
	@Override
	public int insertUserByBunch(List<User> userList) {
		// TODO Auto-generated method stub
		return userDao.insertUserByBunch(userList);
	}

}
