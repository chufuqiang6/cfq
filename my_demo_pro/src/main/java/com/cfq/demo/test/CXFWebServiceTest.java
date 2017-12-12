package com.cfq.demo.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.cfq.demo.entity.User;
import com.cfq.demo.util.DateUtil;
import com.cfq.demo.util.HttpClientUtil;
import com.cfq.demo.util.JsonUtil;
import com.cfq.demo.util.UUIDUtil;
import com.cfq.demo.webservice.UserJaxRsService;

public class CXFWebServiceTest {
  public static void main(String[] args) throws IOException {
		 List<User> userList=new ArrayList<User>();
		 for(int i=0;i<4;i++){
		 User userDTO = new User();
		 userDTO.setId(UUIDUtil.creatUUID());
		 userDTO.setUserName("userName"+i);
		 userDTO.setPassWord("loginName"+i);
		 userDTO.setUpdatePeople("褚夫强");
		 userDTO.setUpdateTime(DateUtil.getDateTimeFormat(new Date()));
//		 userDTO.setUpdateTime("");
		 userList.add(userDTO);
		 }
//			User userDTO = new User();  
//			userDTO.setUserName("userName");  
//		    userDTO.setPassWord("loginName");
//		    String url="http://localhost:8080/my_maven_pro/cxf/webService/user/1";
		    String url="http://localhost:8080/my_maven_pro/cxf/webService/user/addUser";
		    
		    //传递listJson
			String json= JsonUtil.getJsonString4JavaArray(userList.toArray());
			//传递model
//		    String json= JsonUtil.getJsonString4JavaPOJO(userDTO);
//			String getResult=HttpClientUtil.doPost(url);
			//传递listJson
			String getResult=HttpClientUtil.doPostJson(url, json);
			System.out.println(getResult);
	  
	    }  
}
