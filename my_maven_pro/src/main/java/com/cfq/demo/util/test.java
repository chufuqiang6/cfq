package com.cfq.demo.util;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

import com.cfq.demo.entity.User;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	    String format = MediaType.APPLICATION_XML;  
	    System.out.println("testAddCategory called with format " );     
	    WebClient client = WebClient.create("http://localhost:8080/my_maven_pro/cxf/webService");     
	    client.path("/user/addUser.xml").accept(format).type(format); 
//	    User userDTO = new User();  
//	    userDTO.setUserName("userName");  
//	    userDTO.setPassWord("loginName");  
//	    User returnUser = client.post(userDTO,User.class);    
	    User returnUser = client.get(User.class);    
	    System.out.println("userName: " + returnUser.getUserName()  
	            +" lgoinName: "+returnUser.getPassWord());     
	}

}
