package com.cfq.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cfq.demo.entity.User;
import com.cfq.demo.service.UserService;
import com.cfq.demo.util.EncodeByMD5Util;
import com.cfq.demo.util.JsonUtil;

@Controller
@RequestMapping(value = "/madmin/page")

public class LoginController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/login.do")
	public String doLogin() {
		return "/Login";
	}

	@RequestMapping(value = "/validateLogin.do")
	public ModelAndView validateLogin(User user,HttpServletRequest request) throws IOException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
//		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		String encodPsd=EncodeByMD5Util.EcodStr(user.getPassWord());
		user.setPassWord(encodPsd);
		User getUser = userService.getUser(user);
		ModelAndView view=new ModelAndView("redirect");
		if (getUser != null) {
			session.setAttribute("user", getUser);
			view.setViewName("redirect:/madmin/page/toIndex.do");
		}else{
			view.setViewName("redirect:/madmin/page/login.do");
		} 
		return view;
	}

	@RequestMapping(value = "/toIndex.do")
	public String toIndex() {
		return "/FirstPage";
	}
	@RequestMapping(value="/jsonTest.do")
	@ResponseBody
	public User getUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		User user= new User();
		user.setId("1");
		user.setAddPeople("111");
		return user;
	}
}
