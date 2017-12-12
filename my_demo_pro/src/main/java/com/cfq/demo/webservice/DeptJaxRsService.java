package com.cfq.demo.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.cfq.demo.entity.BaseResult;
import com.cfq.demo.entity.User;
import com.cfq.demo.service.UserService;
import com.cfq.demo.util.JsonUtil;
@Path("/dept")  
public class DeptJaxRsService {  
    @Autowired  
    private UserService userService;//业务系统类接口，省略  
  
    @GET  
    @Path("/{deptCode}")  
    @Produces(MediaType.APPLICATION_JSON)  
    public BaseResult getAsXml(@PathParam("deptCode") String deptCode) { 
    	BaseResult result=new BaseResult<>();
    	User user=userService.getUserById(deptCode);
        if (user == null) {  
            String message = "用户不存在(id:" + deptCode + ")";  
            throw buildException(Status.NOT_FOUND, message);  
        }  
        User dto = new User();  
        dto.setUserName("褚夫强");  
        dto.setPassWord("1232434"); 
        result.setData(dto);
        return result;  
    }  
  
    @POST  
    @Path("/{userName}")  
    @Produces(MediaType.APPLICATION_JSON)  
    public BaseResult getUser(@PathParam("userName") String userName) {  
    	BaseResult result=new BaseResult<>();
    	User user=userService.getUserById(userName);
        if (user == null) {  
            String message = "用户不存在(id:" + userName + ")";  
            throw buildException(Status.NOT_FOUND, message);  
        }  
        User dto = new User();  
        dto.setUserName("111");  
        dto.setPassWord("22222"); 
        result.setData(dto);
        return result;   
    }  
  
    @POST  
    @Path("/addDept")  
    @Produces( {MediaType.APPLICATION_JSON })  
    public User addUser(List<User> userList) throws IOException {  
    	String jsonList=JsonUtil.getJsonArray4JavaList(userList);
        System.out.println("收到json:"+jsonList); 
        User user=new User();
        user.setUserName("褚夫强"); 
        return user;  
    }  
  
    private WebApplicationException buildException(Status status, String message){  
        return new WebApplicationException(Response.status(status).entity(  
            message).type(MediaType.TEXT_PLAIN).build());  
    }  
}  
