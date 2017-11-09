package com.cfq.demo.webservice;

import java.io.IOException;

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

import com.cfq.demo.entity.User;
import com.cfq.demo.service.UserService;
@Path("/user")  
public class UserJaxRsService {  
    @Autowired  
    private UserService userService;//业务系统类接口，省略  
  
    @GET  
    @Path("/{personCode}.xml")  
    @Produces(MediaType.APPLICATION_XML)  
    public User getAsXml(@PathParam("personCode") String personCode) {  
        if (personCode == null) {  
            String message = "用户不存在(id:" + personCode + ")";  
            throw buildException(Status.NOT_FOUND, message);  
        }  
        User dto = new User();  
        dto.setUserName("111");  
        dto.setPassWord("22222");  
        return dto;  
    }  
  
    @GET  
    @Path("/{userName}.json")  
    @Produces(MediaType.APPLICATION_JSON)  
    public User getUser(@PathParam("userName") String userName) {  
    	User person = userService.getUserByUsername(userName);  
        if (person == null) {  
            String message = "用户不存在(id:" + userName + ")";  
//            throw buildException(Status.NOT_FOUND, message);  
        }  
        User dto = new User();  
        dto.setUserName(person.getUserName());  
        return dto;  
    }  
  
    @POST  
    @Path("/addUser")  
    @Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })  
    public User addUser(User user) throws IOException {  
        System.out.println(user);  
        user.setUserName("褚夫强");;  
        return user;  
    }  
  
    private WebApplicationException buildException(Status status, String message){  
        return new WebApplicationException(Response.status(status).entity(  
            message).type(MediaType.TEXT_PLAIN).build());  
    }  
}  
