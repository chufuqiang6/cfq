package com.cfq.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfq.demo.entity.User;
import com.cfq.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

  @Resource
  private UserService userService;

  @RequestMapping(value = "/login.do")
  public @ResponseBody Map<String, Object> insertPatient(User user, HttpServletRequest request,
      HttpServletResponse response) {

    Map<String, Object> resultMap = new HashMap<String, Object>();
    try {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    String username = user.getUserName();
    String password = user.getPassWord();

    if ((username == null || username.length() == 0)
        || (password == null || password.length() == 0)) {
      resultMap.put("result", "error");
      resultMap.put("message", "帐号或者密码不能为空");
    } else {
      User user2 = userService.getUserByUsername(username);
      if (user2 == null) {
        resultMap.put("result", "error");
        resultMap.put("message", "用户不存在");
      } else {
        if (password.equals(user2.getPassWord())) {
          resultMap.put("result", "success");
        } else {
          resultMap.put("resultCode", 0);
          resultMap.put("message", "密码错误");
        }
      }
    }
    return resultMap;
  }

}
